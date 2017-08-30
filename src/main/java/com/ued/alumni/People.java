package com.ued.alumni;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.ued.alumni.SubActivities.Profile_Info;

public class People extends AppCompatActivity implements View.OnClickListener{

    boolean isAddClicked = false;
    ImageButton btnUserAdd, btnUserAddPressed;
    CardView card_Profile_one;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Search People");

        searchBody();

        btnUserAdd = (ImageButton) findViewById(R.id.btn_user_add);
        btnUserAdd.setOnClickListener(this);
        btnUserAddPressed = (ImageButton) findViewById(R.id.btn_user_add_pressed);
        btnUserAddPressed.setOnClickListener(this);
        card_Profile_one = (CardView) findViewById(R.id.card_view_first);

        card_Profile_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Profile_Info.class);
                startActivity(i);
            }
        });


    }

    public void searchBody(){

        final EditText search_group = (EditText) findViewById(R.id.search_people);

        search_group.setBackgroundResource(R.drawable.searchtext_border_bg);

        ShapeDrawable shape = new ShapeDrawable(new RectShape());
        shape.getPaint().setColor(Color.parseColor("#78909c"));
        shape.getPaint().setStyle(Paint.Style.STROKE);
        shape.getPaint().setStrokeWidth(3);

        search_group.setBackground(shape);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){

            case R.id.btn_user_add:
                if (isAddClicked){
                    isAddClicked=false;
                    btnUserAdd.setVisibility(View.VISIBLE);
                    btnUserAddPressed.setVisibility(View.GONE);
                    Toast.makeText(getApplicationContext(), "Request Withdrawn", Toast.LENGTH_SHORT).show();

                }else{
                    isAddClicked = true;
                    btnUserAdd.setVisibility(View.GONE);
                    btnUserAddPressed.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(), "Request Sent", Toast.LENGTH_SHORT).show();

                }
                break;

            case R.id.btn_user_add_pressed:
                if (isAddClicked){
                    isAddClicked=false;
                    btnUserAdd.setVisibility(View.VISIBLE);
                    btnUserAddPressed.setVisibility(View.GONE);
                    Toast.makeText(getApplicationContext(), "Request Withdrawn", Toast.LENGTH_SHORT).show();
                }else{
                    isAddClicked = true;
                    btnUserAdd.setVisibility(View.GONE);
                    btnUserAddPressed.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(), "Request Sent", Toast.LENGTH_SHORT).show();

                }
                break;

        }


    }
}
