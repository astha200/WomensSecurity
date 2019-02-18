package com.example.asthakinra.womenssecurity;

import android.app.FragmentTransaction;
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

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Login c1=new Login();
    Home c2=new Home();
    Account c3=new Account();
    Logout c4=new Logout();
    Aboutus c5=new Aboutus();
    Share c6=new Share();
    Rateapp c7=new Rateapp();
    Exit c8=new Exit();
    ImageView amb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        if(savedInstanceState==null) {
           // getSupportFragmentManager().beginTransaction().replace(R.id.frm, new Home()).commit();
            FragmentTransaction t2=getFragmentManager().beginTransaction();
            t2.replace(R.id.frm,c2);
            t2.commit();
            navigationView.setCheckedItem(R.id.nav_gallery);
        }

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
            FragmentTransaction t1=getFragmentManager().beginTransaction();
            t1.replace(R.id.frm,c1);
            t1.commit();

            // Handle the camera action
        }
        else if (id == R.id.nav_gallery) {
            FragmentTransaction t2=getFragmentManager().beginTransaction();
            t2.replace(R.id.frm,c2);
            t2.commit();


        } else if (id == R.id.nav_slideshow) {
            FragmentTransaction t3=getFragmentManager().beginTransaction();
            t3.replace(R.id.frm,c3);
            t3.commit();
        } else if (id == R.id.nav_manage) {
            FragmentTransaction t4=getFragmentManager().beginTransaction();
            t4.replace(R.id.frm,c4);
            t4.commit();

        } else if (id == R.id.nav_share) {
            FragmentTransaction t5=getFragmentManager().beginTransaction();
            t5.replace(R.id.frm,c5);
            t5.commit();

        } else if (id == R.id.nav_send) {
            FragmentTransaction t6=getFragmentManager().beginTransaction();
            t6.replace(R.id.frm,c6);
            t6.commit();

        }
        else if (id == R.id.rateapp) {
            FragmentTransaction t7=getFragmentManager().beginTransaction();
            t7.replace(R.id.frm,c7);
            t7.commit();

        }
        else if (id == R.id.exit) {
            FragmentTransaction t8=getFragmentManager().beginTransaction();
            t8.replace(R.id.frm,c8);
            t8.commit();


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
