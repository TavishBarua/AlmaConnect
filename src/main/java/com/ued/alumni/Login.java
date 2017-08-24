package com.ued.alumni;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ued.alumni.Database.DatabaseAlumnie;
import com.ued.alumni.Utils.Constant;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Login extends AppCompatActivity {
    Button btnLogin;
    TextView tvLoginRegister,tvLoginForgot;
    String strUsername,strPassword;
    EditText etUserName,etPassword;
    SharedPreferences sharedPrefrence;
    String prefsLogin="login_prefs",prefsPassword="password",prefsIntent="intent";
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sharedPrefrence=getSharedPreferences(Constant.SHARED_PREFRENCE,MODE_PRIVATE);

        if (sharedPrefrence.getString(prefsIntent,"").equals("login_done")){
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
            finish();
        }
        etUserName=(EditText)findViewById(R.id.et_login_username);
        etPassword=(EditText)findViewById(R.id.et_login_password);
        tvLoginRegister=(TextView)findViewById(R.id.tv_login_signup);
        btnLogin=(Button)findViewById(R.id.btn_login);
        tvLoginForgot=(TextView)findViewById(R.id.tv_login_forgot);
        tvLoginRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Register.class);
                startActivity(intent);
            }
        });
        tvLoginForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ForgotPassword.class);
                startActivity(intent);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                strUsername=etUserName.getText().toString();
                strPassword=etPassword.getText().toString();
                if (etUserName.getText().toString().trim().length()>0&&etPassword.getText().toString().trim().length()>0) {
                    new HttpAsyncTaskLogin().execute();
                }else Toast.makeText(Login.this, "Username or Password is missing", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private class HttpAsyncTaskLogin extends AsyncTask<URL, Void, String> {
        private ProgressDialog pDialog;
        @Override
        protected String doInBackground(URL... params) {

            try {
                URL url=new URL(Constant.COMMON_ENDPOINT+"Login?");
                HttpURLConnection connection= (HttpURLConnection) url.openConnection();
                //Toast.makeText(getBaseContext(), Signup.jsonname+" "+Signup.jsondob+" "+Signup.jsonpin, Toast.LENGTH_LONG).show();
                String urlParameter="email="+strUsername+"&password="+strPassword;
                connection.setRequestMethod("GET");
                //connection.setRequestProperty("USER-AGENT", "Mozilla/5.0");
                //connection.setRequestProperty("ACCEPT-LANGUAGE", "en-US,en;0.5");
                connection.setDoOutput(true);
                DataOutputStream dStream=new DataOutputStream(connection.getOutputStream());
                dStream.writeBytes(urlParameter);
                dStream.flush();
                dStream.close();

                int responseCode=connection.getResponseCode();

                String output="Request URL"+url;
                output+=System.getProperty("line.seprator")+"Request parameter"+urlParameter;
                output+=System.getProperty("line.seprator")+"Response code"+responseCode;
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line="";
                StringBuilder responseOutput=new StringBuilder();

                while ((line= bufferedReader.readLine())!=null){
                    responseOutput.append(line);
                }
                bufferedReader.close();
                output+=System.getProperty("line.seprator")+responseOutput.toString();
                //tvOutput.setText(output);

                Log.e("Login responce",output.toString());
                return output.toString();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;


        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(Login.this);
            pDialog.setMessage("Login ...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }


        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            pDialog.dismiss();
          //  Toast.makeText(getBaseContext(), result, Toast.LENGTH_LONG).show();
            editor=sharedPrefrence.edit();
            editor.putString(prefsIntent,"login_done");
            editor.commit();
            Intent intent=new Intent(Login.this,MainActivity.class);
            startActivity(intent);
            finish();

        }



    }

}
