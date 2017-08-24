package com.ued.alumni;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.ued.alumni.Utils.Constant;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;

public class Vacancies extends AppCompatActivity {
    private int year,month,day;
    TextView tvDetails;
    Button btnSubmit;
    final CharSequence[] select_cat={"IT Jobs","Non IT Jobs"};
    AlertDialog.Builder builder2;
    final CharSequence[] select_salary={"<1 Lac","1 Lac","2 Lacs","3 Lacs","4 Lacs","5 Lacs","6 Lacs","7 Lacs","8 Lacs","9 Lacs","10 Lacs","11 Lacs","12 Lacs","13 Lacs","14 Lacs","15 Lacs","16 Lacs","17 Lacs","18 Lacs","19 Lacs","20 Lacs","21 Lacs","22 Lacs","23 Lacs","24 Lacs","25 Lacs","26 Lacs","27 Lacs","28 Lacs","29 Lacs","30 Lacs","30+ Lacs","35+ Lacs","40+ Lacs","45+ Lacs","50+ Lacs","60+ Lacs","70+ Lacs","80+ Lacs","90+ Lacs","100+ Lacs"};
    final CharSequence[] select_exp={"1 Year","2 Years","3 Years","4 Years","5 Years","> 5"};
    final CharSequence[] select_state = {"Andhra Pradesh","Arunachal Pradesh","Assam","Bihar","Chhattisgarh","Goa","Gujarat","Haryana","Himachal Pradesh","Jammu & Kashmir","Jharkhand","Karnataka","Kerala","Madhya Pradesh","Maharashtra","Manipur","Meghalaya","Mizoram","Nagaland","New Delhi","Odisha","Punjab","Rajasthan","Sikkim","Tamil Nadu","Telangana","Tripura","Uttarakhand","Uttar Pradesh","West Bengal"};
    String strDetails,strDOI,strExp,strPack,strState,strCat,strComp,strPro;
    EditText etDOI,etExperience,etDetails,etPackage,etState,etCat,etCompanyName,etPro;
    private DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacancies);
        //START - Adding Back Icon In App Bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_add_vacancies);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Add Vacancies");
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        etState=(EditText)findViewById(R.id.et_vacan_state);
        etCat=(EditText)findViewById(R.id.et_vacan_cat);
        btnSubmit=(Button)findViewById(R.id.btn_add_vacan_submit);
        etPackage=(EditText)findViewById(R.id.et_vacan_package);
        etDetails=(EditText)findViewById(R.id.et_vacan_details);
        tvDetails=(TextView)findViewById(R.id.tv_vacan_text_count);
        etCompanyName=(EditText)findViewById(R.id.et_vacan_cmp_name);
        etPro=(EditText)findViewById(R.id.et_vacan_profile);
          etDOI=(EditText)findViewById(R.id.et_vacan_last_date);
        etCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(Vacancies.this);
                builder.setTitle("Select Experience!");
                builder.setItems(select_cat, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        etCat.setText(select_cat[item]);
                    }
                });
                builder.show();
            }
        });
        etState.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = getLayoutInflater();
                View convertView = (View) inflater.inflate(R.layout.custom, null);
                String[] select_group2 = {"Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh", "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jammu & Kashmir", "Jharkhand", "Karnataka", "Kerala", "Madhya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "New Delhi", "Odisha", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Telangana", "Tripura", "Uttarakhand", "Uttar Pradesh", "West Bengal"};

                ListView lv = (ListView) convertView.findViewById(R.id.listView1);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(Vacancies.this, R.layout.list_item, select_group2);
                lv.setAdapter(adapter);

                builder2 = new AlertDialog.Builder(Vacancies.this)
                        .setTitle("Select State")
                        .setView(convertView);
                final AlertDialog alertdialog1 = builder2.create();
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        etState.setText(select_state[position]);

                        alertdialog1.dismiss();
                    }
                });alertdialog1.show();
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strCat=etCat.getText().toString();
                strDetails=etDetails.getText().toString();
                strDOI=etDOI.getText().toString();
                strExp=etExperience.getText().toString();
                strPack=etPackage.getText().toString();
                strState=etState.getText().toString();
                strComp=etCompanyName.getText().toString();
                strPro=etPro.getText().toString();
                if (strPro.length()>0&&strComp.length()>0&&strDetails.length()>0&&strState.length()>0&&strCat.length()>0&&strDOI.length()>0&&strExp.length()>0&&strPack.length()>0){
                    new HttpAsyncTaskAddVacancies().execute();
                }else Toast.makeText(Vacancies.this, "Fill all the fields", Toast.LENGTH_SHORT).show();
            }
        });

        etPackage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = getLayoutInflater();
                View convertView = (View) inflater.inflate(R.layout.custom, null);
                String[] select_group2 = {"<1 Lac","1 Lac","2 Lacs","3 Lacs","4 Lacs","5 Lacs","6 Lacs","7 Lacs","8 Lacs","9 Lacs","10 Lacs","11 Lacs","12 Lacs","13 Lacs","14 Lacs","15 Lacs","16 Lacs","17 Lacs","18 Lacs","19 Lacs","20 Lacs","21 Lacs","22 Lacs","23 Lacs","24 Lacs","25 Lacs","26 Lacs","27 Lacs","28 Lacs","29 Lacs","30 Lacs","30+ Lacs","35+ Lacs","40+ Lacs","45+ Lacs","50+ Lacs","60+ Lacs","70+ Lacs","80+ Lacs","90+ Lacs","100+ Lacs"};

                ListView lv = (ListView) convertView.findViewById(R.id.listView1);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(Vacancies.this, R.layout.list_item, select_group2);
                lv.setAdapter(adapter);

                builder2 = new AlertDialog.Builder(Vacancies.this)
                        .setTitle("Select Experience")
                        .setView(convertView);
                final AlertDialog alertdialog1 = builder2.create();
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        etPackage.setText(select_salary[position]);

                        alertdialog1.dismiss();
                    }
                });alertdialog1.show();
            }
        });


        etExperience=(EditText)findViewById(R.id.et_vacan_experience);
        etExperience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(Vacancies.this);
                builder.setTitle("Select Experience!");
                builder.setItems(select_exp, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        etExperience.setText(select_exp[item]);
                    }
                });
                builder.show();
            }
        });
        etDOI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calender(v);
            }
        });

       etDetails.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence s, int start, int count, int after) {


           }

           @Override
           public void onTextChanged(CharSequence s, int start, int before, int count) {
                tvDetails.setText(etDetails.getText().toString().length()+"/75");
           }

           @Override
           public void afterTextChanged(Editable s) {

           }
       });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

    // Showing Date picker in android
    public void calender(View v){
        showDialog(0);
    }
    @Override
    @Deprecated
    protected Dialog onCreateDialog(int id) {
        datePickerDialog=new DatePickerDialog(this, datePickerListener, year, month, day);
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        return datePickerDialog;
    }

    private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {
            etDOI.setText(selectedDay + "-" + (selectedMonth + 1) + "-"
                    + selectedYear);
        }
    };


    private class HttpAsyncTaskAddVacancies extends AsyncTask<URL, Void, String> {
        private ProgressDialog pDialog;
        @Override
        protected String doInBackground(URL... params) {

            try {
                URL url=new URL(Constant.COMMON_ENDPOINT+"AddVacancy?");
                HttpURLConnection connection= (HttpURLConnection) url.openConnection();
                //Toast.makeText(getBaseContext(), Signup.jsonname+" "+Signup.jsondob+" "+Signup.jsonpin, Toast.LENGTH_LONG).show();
                String urlParameter="cmp_name="+strComp+"&experience="+strExp+"&job_profile="+strPro+"&salary="+strPack+"&user_id="+"sohan.sharma96@gmail.com"+"&category="+strCat+"&description="+strDetails+"&location="+strState+"&doi="+strDOI;
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

                Log.e("AddEvent_responce",output.toString());
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
            pDialog = new ProgressDialog(Vacancies.this);
            pDialog.setMessage("Uploading ...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }


        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            pDialog.dismiss();
            finish();
            Toast.makeText(getBaseContext(), "Updated", Toast.LENGTH_LONG).show();

        }



    }
}
