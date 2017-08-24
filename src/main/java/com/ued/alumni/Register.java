package com.ued.alumni;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ued.alumni.Utils.Constant;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Register extends AppCompatActivity {
    EditText et_batch_from,et_batch_to,etUsername,etPass,etPhoneNo,etEmail;
    String strBatchFrom,strBatchTo,strUsername,strPass,strPhoneNo,strEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etUsername=(EditText)findViewById(R.id.register_username);
        etPass=(EditText)findViewById(R.id.register_pass);
        etPhoneNo=(EditText)findViewById(R.id.register_phone);
        etEmail=(EditText)findViewById(R.id.register_email);
        et_batch_from=(EditText)findViewById(R.id.register_batch_from);
        et_batch_to=(EditText)findViewById(R.id.register_batch_to);

        Button btn=(Button)findViewById(R.id.btn_signup);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strBatchFrom=et_batch_from.getText().toString();
                strBatchTo=et_batch_to.getText().toString();
                strEmail=etEmail.getText().toString();
                strPass=etPass.getText().toString();
                strUsername=etUsername.getText().toString();
                strPhoneNo=etPhoneNo.getText().toString();
                new HttpAsyncTaskSignup().execute();
            }
        });
    }


    private class HttpAsyncTaskSignup extends AsyncTask<URL, Void, String> {
        private ProgressDialog pDialog;
        @Override
        protected String doInBackground(URL... params) {

            try {
                URL url=new URL(Constant.COMMON_ENDPOINT+"SignUp?");
                HttpURLConnection connection= (HttpURLConnection) url.openConnection();
                //Toast.makeText(getBaseContext(), Signup.jsonname+" "+Signup.jsondob+" "+Signup.jsonpin, Toast.LENGTH_LONG).show();
                String urlParameter="name="+strUsername+"&email="+strEmail+"&phoneNo="+strPhoneNo+"&Batch_f="+strBatchFrom+"&T_batch="+strBatchTo+"&password="+strPass;
                connection.setRequestMethod("POST");
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

                Log.e("Signup responce",output.toString());
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
            pDialog = new ProgressDialog(Register.this);
            pDialog.setMessage("Signing ...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }


        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            pDialog.dismiss();
           // Toast.makeText(getBaseContext(), result, Toast.LENGTH_LONG).show();
            Intent intent=new Intent(Register.this,Login.class);
            startActivity(intent);
            finish();
        }



    }


}
