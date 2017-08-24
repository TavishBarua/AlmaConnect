package com.ued.alumni.Fragments;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.ued.alumni.R;



public class GroupJoin extends Fragment implements View.OnClickListener{

    Button btn_group_join_one, btn_group_join_one_pressed;
   private boolean isjoinClicked = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_group_join, container, false);

        final EditText search_group = (EditText) view.findViewById(R.id.search_grp);

        search_group.setBackgroundResource(R.drawable.searchtext_border_bg);

        ShapeDrawable shape = new ShapeDrawable(new RectShape());
        shape.getPaint().setColor(Color.parseColor("#78909c"));
        shape.getPaint().setStyle(Paint.Style.STROKE);
        shape.getPaint().setStrokeWidth(3);

        search_group.setBackground(shape);

        btn_group_join_one = (Button) view.findViewById(R.id.btn_grp_join_one);
        btn_group_join_one.setOnClickListener(this);
        btn_group_join_one_pressed = (Button) view.findViewById(R.id.btn_grp_join_pressed);
        btn_group_join_one_pressed.setOnClickListener(this);
       // joinGroup();

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){

            case R.id.btn_grp_join_one:
                if (isjoinClicked){
                    isjoinClicked=false;
                btn_group_join_one.setVisibility(View.VISIBLE);
                btn_group_join_one_pressed.setVisibility(View.GONE);
                Toast.makeText(getActivity().getApplicationContext(), "Group Leaved", Toast.LENGTH_LONG).show();
                }else{
                    isjoinClicked = true;
                    btn_group_join_one.setVisibility(View.GONE);
                    btn_group_join_one_pressed.setVisibility(View.VISIBLE);
                    Toast.makeText(getActivity().getApplicationContext(), "Group Joined", Toast.LENGTH_LONG).show();

                }

                break;

            case R.id.btn_grp_join_pressed:
                if (isjoinClicked){
                    isjoinClicked=false;
                    btn_group_join_one.setVisibility(View.VISIBLE);
                    btn_group_join_one_pressed.setVisibility(View.GONE);
                    Toast.makeText(getActivity().getApplicationContext(), "Group Leaved", Toast.LENGTH_LONG).show();
                }else{
                    isjoinClicked = true;
                    btn_group_join_one.setVisibility(View.GONE);
                    btn_group_join_one_pressed.setVisibility(View.VISIBLE);
                    Toast.makeText(getActivity().getApplicationContext(), "Group Joined", Toast.LENGTH_LONG).show();

                }

                break;
        }
    }

    /* public void joinGroup(){
        btn_group_join_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             /*   if(isjoinClicked) {
                isjoinClicked = false;
                    btn_group_join.setImageResource(R.id.btn_grp_join_one);
                    Toast.makeText(getActivity().getApplicationContext(), "Group Leaved", Toast.LENGTH_LONG).show();
                }else{
                    isjoinClicked = true;
                    btn_group_join.setImageResource(R.drawable.icn_grp_join_rqst_pressed);
                    Toast.makeText(getActivity().getApplicationContext(), "Group Joined", Toast.LENGTH_LONG).show();
                }

             switch(v.getId()){
                 case R.id.btn_grp_join_one:
                     if(isjoinClicked) {
                         isjoinClicked = false;
                         btn_group_join_one.setVisibility(View.VISIBLE);
                         btn_group_join_one_pressed.setVisibility(View.GONE);
                         Toast.makeText(getActivity().getApplicationContext(), "Group Leaved", Toast.LENGTH_LONG).show();
                     }else{
                         isjoinClicked = true;
                         btn_group_join_one.setVisibility(View.GONE);
                         btn_group_join_one_pressed.setVisibility(View.VISIBLE);
                         Toast.makeText(getActivity().getApplicationContext(), "Group Joined", Toast.LENGTH_LONG).show();

                     }
                     break;
                 case R.id.btn_grp_join_pressed:
                     if(!isjoinClicked) {
                         isjoinClicked = true;
                         btn_group_join_one.setVisibility(View.GONE);
                         btn_group_join_one_pressed.setVisibility(View.VISIBLE);
                         Toast.makeText(getActivity().getApplicationContext(), "Group Joined", Toast.LENGTH_LONG).show();
                     }else{
                         isjoinClicked = false;
                         btn_group_join_one.setVisibility(View.VISIBLE);
                         btn_group_join_one_pressed.setVisibility(View.GONE);
                         Toast.makeText(getActivity().getApplicationContext(), "Group Leaved", Toast.LENGTH_LONG).show();

                     }
                     break;


                /* case R.id.btn_grp_join_pressed:
                     isjoinClicked = true;
                     btn_group_join_one.setVisibility(View.GONE);
                     btn_group_join_one_pressed.setVisibility(View.VISIBLE);
                     Toast.makeText(getActivity().getApplicationContext(), "Group Leaved", Toast.LENGTH_LONG).show();
             }
            }
        });

    }  */



}
