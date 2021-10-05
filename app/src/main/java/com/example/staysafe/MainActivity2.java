package com.example.staysafe;


import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;


public class MainActivity2 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
        private DrawerLayout drawerLayout;
        NavigationView navigationView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main2);


            drawerLayout=findViewById(R.id.navView);
            Toolbar toolbar=findViewById(R.id.toolbar);
            navigationView=findViewById(R.id.navigationView);


            navigationView.setNavigationItemSelectedListener(this);

            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new status());
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new settings());



            ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this, drawerLayout,toolbar,R.string.navigation_draw_open,R.string.navigation_draw_close);
            drawerLayout.addDrawerListener(toggle);
            toggle.syncState();

            if(savedInstanceState==null){

                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new status()).commit();
                navigationView.setCheckedItem(R.id.status);

            }

        }

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.status:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new status()).commit();
                case R.id.settings:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new settings()).commit();
            }

            drawerLayout.closeDrawer(GravityCompat.START);

            return true;
        }

        @Override
        public void onBackPressed() {
            if(drawerLayout.isDrawerOpen(GravityCompat.START)){

                drawerLayout.closeDrawer(GravityCompat.START);
            }else{
                super.onBackPressed();
            }
        }
    }

