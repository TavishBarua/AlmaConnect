package com.ued.alumni.SubActivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.ued.alumni.R;

public class IT_Jobs extends AppCompatActivity {

    CardView first_CardView_nonit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_it_jobs);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_it);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("IT Jobs");


        first_CardView_nonit = (CardView) findViewById(R.id.card_view);

        first_CardView_nonit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),ITJobDescription.class);
                startActivity(i);
            }
        });


    }
}
