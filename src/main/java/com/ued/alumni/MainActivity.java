package com.ued.alumni;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.ued.alumni.Fragments.ActivityMainFragmentGroup;
import com.ued.alumni.Utils.Constant;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ImageView ivPostPic,ivPostPicOne,ivPostPicFour,ivPostPicThree;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ivPostPic=(ImageView)findViewById(R.id.ivallpostpic);
        ivPostPicOne=(ImageView) findViewById(R.id.ivallpostpic1);
        ivPostPicFour = (ImageView) findViewById(R.id.ivallpostpic4);
        ivPostPicThree = (ImageView) findViewById(R.id.ivallpostpic3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        /*try {
            ivPostPic.setImageResource(R.drawable.post_new);
        }
        catch (Exception e){
            e.printStackTrace();
        }*/

        try {
            Glide.with(this).load(R.drawable.post_new).into(ivPostPic);
            Glide.with(this).load(R.drawable.img_prof_tavish_high).into(ivPostPicOne);
            Glide.with(this).load(R.drawable.img_prof_pawan_high).into(ivPostPicFour);
            Glide.with(this).load(R.drawable.img_prof_kshitij_high).into(ivPostPicThree);
        }catch (Exception e){
            e.printStackTrace();
        }

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent intent=new Intent(getApplicationContext(),Events.class);
            startActivity(intent);
        }else if (id == R.id.nav_people) {
            Intent intent=new Intent(getApplicationContext(),People.class);
            startActivity(intent);

        }  else if (id == R.id.nav_gallery) {
            Intent intent=new Intent(getApplicationContext(),Search_Vacancies.class);
            startActivity(intent);

        }  else if (id == R.id.nav_add_vacan) {
            Intent intent=new Intent(getApplicationContext(),Vacancies.class);
            startActivity(intent);

        } else if (id == R.id.nav_profile) {
            Intent intent=new Intent(getApplicationContext(),Profile.class);
            startActivity(intent);
        } else if (id == R.id.nav_edit_profile) {
            Intent intent=new Intent(getApplicationContext(),EditProfile.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_add_events) {
            Intent intent=new Intent(getApplicationContext(),Add_Event.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_news_updates) {
            Intent intent=new Intent(getApplicationContext(),News_Updates.class);
            startActivity(intent);
        }else if (id == R.id.nav_group) {
            Intent intent=new Intent(getApplicationContext(),ActivityMainFragmentGroup.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_logout) {
            Intent intent=new Intent(this, Login.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);

            //clearing all sharedPrefrence
            SharedPreferences sharedPreferences=getSharedPreferences(Constant.SHARED_PREFRENCE, MODE_PRIVATE);
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.clear();
            editor.apply();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
