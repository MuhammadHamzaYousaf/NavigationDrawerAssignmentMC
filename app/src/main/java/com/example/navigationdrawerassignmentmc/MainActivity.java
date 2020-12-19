package com.example.navigationdrawerassignmentmc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private ActionBarDrawerToggle toggle;

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar= findViewById(R.id.toolbar);
        navigationView=findViewById(R.id.navigation);
        drawer=findViewById(R.id.drawer_layout);
        setSupportActionBar(toolbar);

        toggle=new ActionBarDrawerToggle(this,drawer,toolbar,R.string.open,R.string.close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);




//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()){
//                    case R.id.quiz:
//                        startActivity(new Intent(MainActivity.this,QuizActivity.class));
//                        break;
//                    case R.id.calculator:
//                        startActivity(new Intent(MainActivity.this,CalculatorActivity.class));
//                        break;
//                    default:
//                        break;
//
//                }
//                return  true;
//            }
//        });

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.quiz:
                startActivity(new Intent(MainActivity.this,QuizActivity.class));
                break;
            case R.id.calculator_start:
                startActivity(new Intent(MainActivity.this,CalculatorActivities.class));
                break;
            }
            drawer.closeDrawer(GravityCompat.START);
        return  true;
    }
}