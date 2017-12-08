package com.example.androidapp1d.Prof;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.androidapp1d.R;

public class ProfProfileActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private ActionBar actionBar;
    private NavigationView navigationView;
    EditText staffid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profactivity_profile);
        getSupportActionBar().setTitle("Your Profile");
        drawerLayout =(DrawerLayout)findViewById(R.id.drawerLayout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.opendrawer, R.string.closedrawer);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        staffid = (EditText) findViewById(R.id.staffID);
        if(savedInstanceState != null){
            staffid.setText("Enter your name!", TextView.BufferType.EDITABLE);
        }


        actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        navigationView = (NavigationView)findViewById(R.id.nav_view);
        final Menu menu1 =navigationView.getMenu();
        MenuItem dProfile = menu1.getItem(2);
        dProfile.setChecked(true);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()) {
                    case (R.id.side_feed):
                        Intent h= new Intent(ProfProfileActivity.this,ProfFeedActivity.class);
                        startActivity(h);
                        break;
                    case (R.id.side_booking):
                        Intent i= new Intent(ProfProfileActivity.this,ProfBookingActivity.class);
                        startActivity(i);
                        break;
                    case (R.id.side_profile):
                        drawerLayout.closeDrawer(navigationView);
                        break;
                }
                return  false;
            }
        });



        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
        final Menu menu = bottomNavigationView.getMenu();
        MenuItem bProfile = menu.getItem(2);
        bProfile.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()) {
                    case (R.id.ic_feed):
                        Intent h= new Intent(ProfProfileActivity.this,ProfFeedActivity.class);
                        startActivity(h);
                        break;
                    case (R.id.ic_booking):
                        Intent i= new Intent(ProfProfileActivity.this,ProfBookingActivity.class);
                        startActivity(i);
                        break;
                    case (R.id.ic_profile):
                        break;
                    case(R.id.ic_search):
                        Intent j= new Intent(ProfProfileActivity.this,ProfSearchActivity.class);
                        startActivity(j);
                        break;
                }
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.profmenu_main,menu);
        return true;
    }

    public void goNotificationActivity(){
        startActivity(new Intent(this,ProfNotificationActivity.class)) ;
    }

    public void goSearchActivity(){
        startActivity(new Intent(this,ProfSearchActivity.class)) ;
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

    public void personalInfoPage (View view){
        Intent intent = new Intent (this, ProfPersonalInfoPage.class);
        startActivity(intent);
    }

    public void reportStudentsPage(View view){
        Intent intent = new Intent (this, ProfReportStudentsPage.class);
        startActivity(intent);
    }

    public void ProfBookingsList(View view){
        Intent intent = new Intent (this, ProfBookingsPage.class);
        startActivity(intent);
    }

    public void changePWpage(View view){
        Intent intent = new Intent (this, ProfChangePWpage.class);
        startActivity(intent);
    }

    public void modulesPage(View view){
        Intent intent = new Intent (this, ProfModulesList.class);
        startActivity(intent);
    }

    public void priorityListpage(View view){
        Intent intent = new Intent (this, ProfPriorityListPage.class);
        startActivity(intent);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        String edittextvalue = staffid.getText().toString();
        staffid.setText(edittextvalue); //saving EditText value
    }
}
