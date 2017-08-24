package com.ued.alumni;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class People extends AppCompatActivity implements View.OnClickListener{

    boolean isAddClicked = true;
    ImageButton btnUserAdd, btnUserAddPressed;

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
    public void onClick(View v) {
        switch(v.getId()){

            case R.id.btn_user_add:
                if (isAddClicked){
                    isAddClicked=false;
                    btnUserAdd.setVisibility(View.VISIBLE);
                    btnUserAddPressed.setVisibility(View.GONE);
                    Toast.makeText(getApplicationContext(), "Request Sent", Toast.LENGTH_LONG).show();
                }else{
                    isAddClicked = true;
                    btnUserAdd.setVisibility(View.GONE);
                    btnUserAddPressed.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(), "Request Withdrawn", Toast.LENGTH_LONG).show();

                }

            case R.id.btn_user_add_pressed:
                if (isAddClicked){
                    isAddClicked=false;
                    btnUserAdd.setVisibility(View.VISIBLE);
                    btnUserAddPressed.setVisibility(View.GONE);
                    Toast.makeText(getApplicationContext(), "Request Sent", Toast.LENGTH_LONG).show();
                }else{
                    isAddClicked = true;
                    btnUserAdd.setVisibility(View.GONE);
                    btnUserAddPressed.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(), "Request Withdrawn", Toast.LENGTH_LONG).show();

                }
        }


    }
}
