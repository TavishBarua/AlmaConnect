package com.ued.alumni.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.ued.alumni.R;
import com.ued.alumni.Search_Vacancies;


public class CreateGroup extends Fragment {


    final CharSequence[] select_members_limit={"5","10","20","30","40","50","> 50"};
    final CharSequence[] select_batch_year = {"1950","1951","1952","1953","1954","1955","1956","1957","1958","1959","1960","1961",
                            "1962","1963","1964","1965","1966","1967","1968","1969","1970","1971","1972","1973","1974","1975",
                            "1976","1977","1978","1979","1980","1981","1982","1983","1984","1985","1986","1987","1988","1989",
                            "1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003",
                            "2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017",
                            "2018","2019","2020"};
    EditText etVacanState,etGrpFrmBatch,etGrpToBatch;
    AlertDialog.Builder builder3;
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_create_group, container, false);

        etVacanState = (EditText) view.findViewById(R.id.et_vacan_state);
        etGrpFrmBatch = (EditText) view.findViewById(R.id.et_grp_batch);
        etGrpToBatch = (EditText) view.findViewById(R.id.et_grp_batch1);

        etVacanState.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View convertView = (View) inflater.inflate(R.layout.custom, null);
                String[] select_group2 = {"5","10","20","30","40","50","> 50"};

                ListView lv = (ListView) convertView.findViewById(R.id.listView1);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item, select_group2);
                lv.setAdapter(adapter);

                builder3 = new AlertDialog.Builder(getActivity())
                        .setTitle("Select Members Limit")
                        .setView(convertView);
                final AlertDialog alertdialog1 = builder3.create();
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        etVacanState.setText(select_members_limit[position]);

                        alertdialog1.dismiss();
                    }
                });
                alertdialog1.show();
            }
        });

        etGrpFrmBatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View convertView = (View) inflater.inflate(R.layout.custom, null);
                String[] select_group2 = {"1950","1951","1952","1953","1954","1955","1956","1957","1958","1959","1960","1961",
                        "1962","1963","1964","1965","1966","1967","1968","1969","1970","1971","1972","1973","1974","1975",
                        "1976","1977","1978","1979","1980","1981","1982","1983","1984","1985","1986","1987","1988","1989",
                        "1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003",
                        "2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017",
                        "2018","2019","2020"};

                ListView lv = (ListView) convertView.findViewById(R.id.listView1);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item, select_group2);
                lv.setAdapter(adapter);

                builder3 = new AlertDialog.Builder(getActivity())
                        .setTitle("Select Batch Year")
                        .setView(convertView);
                final AlertDialog alertdialog1 = builder3.create();
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        etGrpFrmBatch.setText(select_batch_year[position]);

                        alertdialog1.dismiss();
                    }
                });
                alertdialog1.show();
            }
        });

        etGrpToBatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View convertView = (View) inflater.inflate(R.layout.custom, null);
                String[] select_group2 = {"1950","1951","1952","1953","1954","1955","1956","1957","1958","1959","1960","1961",
                        "1962","1963","1964","1965","1966","1967","1968","1969","1970","1971","1972","1973","1974","1975",
                        "1976","1977","1978","1979","1980","1981","1982","1983","1984","1985","1986","1987","1988","1989",
                        "1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003",
                        "2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017",
                        "2018","2019","2020"};

                ListView lv = (ListView) convertView.findViewById(R.id.listView1);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item, select_group2);
                lv.setAdapter(adapter);

                builder3 = new AlertDialog.Builder(getActivity())
                        .setTitle("Select Batch Year")
                        .setView(convertView);
                final AlertDialog alertdialog1 = builder3.create();
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        etGrpToBatch.setText(select_batch_year[position]);

                        alertdialog1.dismiss();
                    }
                });
                alertdialog1.show();
            }
        });


        return view;
    }


}
