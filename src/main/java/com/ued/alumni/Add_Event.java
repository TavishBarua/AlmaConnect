package com.ued.alumni;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
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

public class Add_Event extends AppCompatActivity {
    EditText etDetails,etLocation,etVenue,etDate;
    private int year,month,day;
    Button btnSubmit;
    String strTopic,strVenue,strDetails,strLocation,strEmail="",strTime="";
    AutoCompleteTextView atTopic;
    final CharSequence[] select_state = {"Andhra Pradesh","Arunachal Pradesh","Assam","Bihar","Chhattisgarh","Goa","Gujarat","Haryana","Himachal Pradesh","Jammu & Kashmir","Jharkhand","Karnataka","Kerala","Madhya Pradesh","Maharashtra","Manipur","Meghalaya","Mizoram","Nagaland","New Delhi","Odisha","Punjab","Rajasthan","Sikkim","Tamil Nadu","Telangana","Tripura","Uttarakhand","Uttar Pradesh","West Bengal"};
    AlertDialog.Builder builder2;
    String[] languages={"Farewell ","Convocation","Reunion","Independence day celebration","Alumnie meet"};
    private DatePickerDialog datePickerDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_events);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        //START - Adding Back Icon In App Bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_add_event);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Add Events");
        atTopic=(AutoCompleteTextView)findViewById(R.id.av_add_event_topic);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,languages);

        atTopic.setAdapter(adapter);
        atTopic.setThreshold(1);
        btnSubmit=(Button)findViewById(R.id.btn_add_event_submit);

        etVenue=(EditText)findViewById(R.id.et_add_event_venue);
        etDetails=(EditText)findViewById(R.id.et_add_event_details);
        etLocation=(EditText)findViewById(R.id.et_add_event_state);
        etDate = (EditText) findViewById(R.id.et_add_event_date);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strDetails=etDetails.getText().toString();
                strTopic=atTopic.getText().toString();
                strLocation=etLocation.getText().toString();
                strVenue=etVenue.getText().toString();

                if (strDetails.length()>0&&strTopic.length()>0&&strLocation.length()>0&&strVenue.length()>0){
                    new HttpAsyncTaskAddEvent().execute();
                }
                else Toast.makeText(Add_Event.this, "Fill all the fields", Toast.LENGTH_SHORT).show();

            }
        });
        etLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = getLayoutInflater();
                View convertView = (View) inflater.inflate(R.layout.custom, null);
                String[] select_group2 = {"Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh", "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jammu & Kashmir", "Jharkhand", "Karnataka", "Kerala", "Madhya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "New Delhi", "Odisha", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Telangana", "Tripura", "Uttarakhand", "Uttar Pradesh", "West Bengal"};

                ListView lv = (ListView) convertView.findViewById(R.id.listView1);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(Add_Event.this, R.layout.list_item, select_group2);
                lv.setAdapter(adapter);

                builder2 = new AlertDialog.Builder(Add_Event.this)
                        .setTitle("Select State")
                        .setView(convertView);
                final AlertDialog alertdialog1 = builder2.create();
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        etLocation.setText(select_state[position]);

                        alertdialog1.dismiss();
                    }
                });alertdialog1.show();
            }
        });

        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               calender(v);
            }
        });

    }
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

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
            etDate.setText(selectedDay + "-" + (selectedMonth + 1) + "-"
                    + selectedYear);
        }
    };

    private class HttpAsyncTaskAddEvent extends AsyncTask<URL, Void, String> {
        private ProgressDialog pDialog;
        @Override
        protected String doInBackground(URL... params) {

            try {
                URL url=new URL(Constant.COMMON_ENDPOINT+"AddEvent?");
                HttpURLConnection connection= (HttpURLConnection) url.openConnection();
                //Toast.makeText(getBaseContext(), Signup.jsonname+" "+Signup.jsondob+" "+Signup.jsonpin, Toast.LENGTH_LONG).show();
                String urlParameter="venue="+strVenue+"&event_name="+strTopic+"&add_dcescript="+strDetails+"&time="+"31/07/2017"+"&user_id="+"sohan.sharma96@gmail.com"+"&location="+strLocation;
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
            pDialog = new ProgressDialog(Add_Event.this);
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
