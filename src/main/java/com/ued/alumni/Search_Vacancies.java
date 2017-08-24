package com.ued.alumni;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class Search_Vacancies extends AppCompatActivity {
    Button btnForgotSubmit;
    AlertDialog.Builder builder2;
    final CharSequence[] select_salary={"<1 Lac","1 Lac","2 Lacs","3 Lacs","4 Lacs","5 Lacs","6 Lacs","7 Lacs","8 Lacs","9 Lacs","10 Lacs","11 Lacs","12 Lacs","13 Lacs","14 Lacs","15 Lacs","16 Lacs","17 Lacs","18 Lacs","19 Lacs","20 Lacs","21 Lacs","22 Lacs","23 Lacs","24 Lacs","25 Lacs","26 Lacs","27 Lacs","28 Lacs","29 Lacs","30 Lacs","30+ Lacs","35+ Lacs","40+ Lacs","45+ Lacs","50+ Lacs","60+ Lacs","70+ Lacs","80+ Lacs","90+ Lacs","100+ Lacs"};
    final CharSequence[] select_exp={"1 Year","2 Years","3 Years","4 Years","5 Years","> 5"};
    final CharSequence[] select_gender = {"Andhra Pradesh","Arunachal Pradesh","Assam","Bihar","Chhattisgarh","Goa","Gujarat","Haryana","Himachal Pradesh","Jammu & Kashmir","Jharkhand","Karnataka","Kerala","Madhya Pradesh","Maharashtra","Manipur","Meghalaya","Mizoram","Nagaland","New Delhi","Odisha","Punjab","Rajasthan","Sikkim","Tamil Nadu","Telangana","Tripura","Uttarakhand","Uttar Pradesh","West Bengal"};
    EditText etState,etExper,etSalary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_vacancies);
        //START - Adding Back Icon In App Bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_search);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Search");
        etState=(EditText)findViewById(R.id.et_state);
        etExper=(EditText)findViewById(R.id.et_experience);
        etSalary=(EditText)findViewById(R.id.et_salary);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        etSalary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = getLayoutInflater();
                View convertView = (View) inflater.inflate(R.layout.custom, null);
                String[] select_group2 = {"<1 Lac","1 Lac","2 Lacs","3 Lacs","4 Lacs","5 Lacs","6 Lacs","7 Lacs","8 Lacs","9 Lacs","10 Lacs","11 Lacs","12 Lacs","13 Lacs","14 Lacs","15 Lacs","16 Lacs","17 Lacs","18 Lacs","19 Lacs","20 Lacs","21 Lacs","22 Lacs","23 Lacs","24 Lacs","25 Lacs","26 Lacs","27 Lacs","28 Lacs","29 Lacs","30 Lacs","30+ Lacs","35+ Lacs","40+ Lacs","45+ Lacs","50+ Lacs","60+ Lacs","70+ Lacs","80+ Lacs","90+ Lacs","100+ Lacs"};

                ListView lv = (ListView) convertView.findViewById(R.id.listView1);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(Search_Vacancies.this, R.layout.list_item, select_group2);
                lv.setAdapter(adapter);

                builder2 = new AlertDialog.Builder(Search_Vacancies.this)
                        .setTitle("Select Experience")
                        .setView(convertView);
                final AlertDialog alertdialog1 = builder2.create();
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        etSalary.setText(select_salary[position]);

                        alertdialog1.dismiss();
                    }
                });alertdialog1.show();
            }
        });
        etExper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = getLayoutInflater();
                View convertView = (View) inflater.inflate(R.layout.custom, null);
                String[] select_group2 = {"1 Year","2 Year","3 Year","4 Year","5 Year","> 5"};

                ListView lv = (ListView) convertView.findViewById(R.id.listView1);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(Search_Vacancies.this, R.layout.list_item, select_group2);
                lv.setAdapter(adapter);

                builder2 = new AlertDialog.Builder(Search_Vacancies.this)
                        .setTitle("Select Experience")
                        .setView(convertView);
                final AlertDialog alertdialog1 = builder2.create();
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        etExper.setText(select_exp[position]);

                        alertdialog1.dismiss();
                    }
                });
                alertdialog1.show();
            }
        });
        etState.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = getLayoutInflater();
                View convertView = (View) inflater.inflate(R.layout.custom, null);
                String[] select_group2 = {"Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh", "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jammu & Kashmir", "Jharkhand", "Karnataka", "Kerala", "Madhya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "New Delhi", "Odisha", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Telangana", "Tripura", "Uttarakhand", "Uttar Pradesh", "West Bengal"};

                ListView lv = (ListView) convertView.findViewById(R.id.listView1);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(Search_Vacancies.this, R.layout.list_item, select_group2);
                lv.setAdapter(adapter);

                builder2 = new AlertDialog.Builder(Search_Vacancies.this)
                        .setTitle("Select State")
                        .setView(convertView);
                final AlertDialog alertdialog1 = builder2.create();
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        etState.setText(select_gender[position]);

                        alertdialog1.dismiss();
                    }
                });alertdialog1.show();

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
}
