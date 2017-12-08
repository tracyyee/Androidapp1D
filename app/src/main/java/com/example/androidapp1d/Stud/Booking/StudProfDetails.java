package com.example.androidapp1d.Stud.Booking;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.androidapp1d.R;
import com.example.androidapp1d.Stud.Feed.StudFeedActivity;
import com.example.androidapp1d.Stud.Profile.StudProfileActivity;
import com.example.androidapp1d.Stud.StudNotificationActivity;
import com.example.androidapp1d.Stud.StudSearchActivity;

/**
 * Created by ASUS on 12/7/2017.
 */

public class StudProfDetails extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private ActionBar actionBar;
    private NavigationView navigationView;
    private Button consult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.stud_profdetails);

            getSupportActionBar().setTitle("");

            consult = (Button) findViewById(R.id.consultButton);
            consult.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(StudProfDetails.this, StudBookingProfSlot.class);
                    startActivity(i);
                }
            });

            //=============================================================================

            drawerLayout =(DrawerLayout)findViewById(R.id.drawerLayout);
            actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.opendrawer, R.string.closedrawer);
            drawerLayout.setDrawerListener(actionBarDrawerToggle);
            actionBarDrawerToggle.syncState();

            actionBar = getSupportActionBar();
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);

            navigationView = (NavigationView)findViewById(R.id.nav_view);
            final Menu menu1 =navigationView.getMenu();
            MenuItem dBooking = menu1.getItem(1);
            dBooking.setChecked(true);

            navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch(item.getItemId()) {
                        case (R.id.side_feed):
                            Intent h= new Intent(StudProfDetails.this,StudFeedActivity.class);
                            startActivity(h);
                            break;
                        case (R.id.side_booking):
                            drawerLayout.closeDrawer(navigationView);
                            break;
                        case (R.id.side_profile):
                            Intent i= new Intent(StudProfDetails.this,StudProfileActivity.class);
                            startActivity(i);
                            break;
                        case(R.id.ic_search):
                            Intent j= new Intent(StudProfDetails.this,StudSearchActivity.class);
                            startActivity(j);
                            break;
                    }
                    return  false;
                }
            });

            BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
            Menu menu = bottomNavigationView.getMenu();
            MenuItem bBooking = menu.getItem(1);
            bBooking.setChecked(true);

            bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch(item.getItemId()) {
                        case (R.id.ic_feed):
                            Intent h= new Intent(StudProfDetails.this,StudFeedActivity.class);
                            startActivity(h);
                            break;
                        case (R.id.ic_booking):
                            break;
                        case (R.id.ic_profile):
                            Intent i= new Intent(StudProfDetails.this,StudProfileActivity.class);
                            startActivity(i);
                            break;
                        case(R.id.ic_search):
                            Intent j= new Intent(StudProfDetails.this,StudSearchActivity.class);
                            startActivity(j);
                            break;
                    }
                    return false;
                }
            });
        } catch(Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.studmenu_main,menu);
        return true;
    }

    public void goNotificationActivity(){
        startActivity(new Intent(this,StudNotificationActivity.class)) ;
    }

    public void goSearchActivity(){
        startActivity(new Intent(this,StudSearchActivity.class)) ;
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState){
        super.onPostCreate(savedInstanceState);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id==android.R.id.home) {
            if(drawerLayout.isDrawerOpen(navigationView)){
                drawerLayout.closeDrawer(navigationView);
            }
            else{
                drawerLayout.openDrawer(navigationView);
            }
        }
        if (id==R.id.menu_item_add){
            goNotificationActivity();
        }
        if (id == R.id.ic_search){
            goSearchActivity();
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}