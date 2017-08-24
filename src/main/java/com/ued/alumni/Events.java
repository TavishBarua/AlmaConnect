package com.ued.alumni;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Events extends AppCompatActivity {
    CardView cvCard,cvCard2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        //START - Adding Back Icon In App Bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_events);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Events");
        cvCard=(CardView)findViewById(R.id.cv_event_card);
        cvCard2=(CardView)findViewById(R.id.cv_event_card1);

        cvCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // custom dialog
                final Dialog dialog = new Dialog(Events.this);
                dialog.setContentView(R.layout.custom_dialog);
                dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                Button dialogButton = (Button) dialog.findViewById(R.id.btn_custom_accept);
                Button dialogButton2 = (Button) dialog.findViewById(R.id.btn_custom_reject);
                // if button is clicked, close the custom dialog
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                dialogButton2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
        cvCard2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // custom dialog
                final Dialog dialog = new Dialog(Events.this);
                dialog.setContentView(R.layout.custom_dialog);
                dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                TextView tv=(TextView)dialog.findViewById(R.id.tv_custom);
                tv.setText("");
                tv.setText(R.string.string_farewell);
                Button dialogButton = (Button) dialog.findViewById(R.id.btn_custom_accept);
                Button dialogButton2 = (Button) dialog.findViewById(R.id.btn_custom_reject);
                // if button is clicked, close the custom dialog
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                dialogButton2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
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
