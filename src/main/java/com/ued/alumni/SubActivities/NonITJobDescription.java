package com.ued.alumni.SubActivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.ued.alumni.R;

public class NonITJobDescription extends AppCompatActivity {

    ImageButton star_unpressed;
    boolean isStarPressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nonit_job_description);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_nonit_job_description);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Non IT Job Description");

        star_unpressed = (ImageButton) findViewById(R.id.btn_user_save);

        setListeners();

    }

    public void setListeners(){
       star_unpressed.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
            if(isStarPressed){
                isStarPressed = false;
                star_unpressed.setImageResource(R.drawable.icn_star);
            }else{
                isStarPressed = true;
                star_unpressed.setImageResource(R.drawable.icn_star_pressed);
                Toast.makeText(getApplicationContext(), "Job Saved", Toast.LENGTH_LONG).show();

            }
           }
       });
    }
}
