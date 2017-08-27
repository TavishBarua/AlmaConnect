package com.ued.alumni.SubActivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.ued.alumni.R;

public class ITJobDescription extends AppCompatActivity {


    ImageButton star_it_unpressed;
    boolean isITStarPressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itjob_description);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_itjob_description);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("IT Job Description");
        star_it_unpressed = (ImageButton) findViewById(R.id.btn_user_save_it);

        setListeners();

    }

    public void setListeners(){
        star_it_unpressed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isITStarPressed){
                    isITStarPressed = false;
                    star_it_unpressed.setImageResource(R.drawable.icn_star);
                }else{
                    isITStarPressed = true;
                    star_it_unpressed.setImageResource(R.drawable.icn_star_pressed);
                    Toast.makeText(getApplicationContext(), "Job Saved", Toast.LENGTH_LONG).show();

                }
            }
        });
    }
}
