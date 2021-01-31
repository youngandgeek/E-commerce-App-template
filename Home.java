package com.example.emow;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ViewFlipper;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {
    ViewFlipper flipper;
    ImageButton btnF;
    ImageButton btnS;
    ImageButton wom;
    ImageButton men;
    ImageButton neutral;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView bottomNavigationView=findViewById(R.id.nav_bar);
        //setHome selected
        bottomNavigationView.setSelectedItemId(R.id.home);
        //item selected
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem Menuitem) {
                switch (Menuitem.getItemId()){
                 //id of the icon in the menu.xml file
                    case R.id.about:
                        startActivity(new Intent(getApplicationContext(),More.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.favorite:
                        startActivity(new Intent(getApplicationContext(),Favorites.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.home:
                        return true;

                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(),Profile.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.cart:
                        startActivity(new Intent(getApplicationContext(),Cart.class));
                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }
        });
        flipper=(ViewFlipper)findViewById(R.id.vFlipper); // get the reference of ViewFlipper
        flipper.setAutoStart(true); // set true value for auto start the flipping between views
/* //for the sliding images
    public void flipperImages(int image){
        ImageView imageView =new ImageView(this);
        imageView.setBackgroundResource(image);
        homeFlipper.addView(imageView);
        homeFlipper.setFlipInterval(4000); //4sec
        homeFlipper.setAutoStart(true);
        homeFlipper.setInAnimation(this, android.R.anim.slide_in_left);
        homeFlipper.setOutAnimation(this, android.R.anim.slide_out_right);

    }
    */

        btnF=(ImageButton)findViewById(R.id.imgOne);

        btnF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent womenIntent=new Intent();
                womenIntent.setClass(Home.this,Women.class);
                startActivity(womenIntent);

            }
        });


        btnS=(ImageButton)findViewById(R.id.imgTwo);
        btnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menIntent=new Intent();
                menIntent.setClass(Home.this,Men.class);
                startActivity(menIntent);
            }
        });
        men=(ImageButton)findViewById(R.id.menBtn);
        men.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menIntent=new Intent();
                menIntent.setClass(Home.this,Men.class);
                startActivity(menIntent);
            }
        });
        wom=(ImageButton)findViewById(R.id.womenBtn);
        wom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent womenIntent=new Intent();
                womenIntent.setClass(Home.this,Women.class);
                startActivity(womenIntent);
            }
        });
        neutral=(ImageButton)findViewById(R.id.neutralBtn);
        neutral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent neutralInten=new Intent();
                neutralInten.setClass(Home.this,Neutral.class);
                startActivity(neutralInten);
            }
        });
    }
}

