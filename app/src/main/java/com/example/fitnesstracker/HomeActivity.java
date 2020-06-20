package com.example.fitnesstracker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;



public class HomeActivity extends AppCompatActivity {

    ImageView bcgapp;
    Animation bganim, frombottom;
    LinearLayout textsplash, texthome, menus;

    private android.widget.ImageButton ImageButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        ImageButton = (android.widget.ImageButton) findViewById(R.id.ImageButton);
        ImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openmeter();
            }
        });


        ImageButton = (android.widget.ImageButton) findViewById(R.id.ImageButtonTwo);
        ImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCalculateDistance();
            }
        });


        frombottom = AnimationUtils.loadAnimation(this, R.anim.frombottom);

        bcgapp = (ImageView) findViewById(R.id.bcgapp);
        textsplash = (LinearLayout) findViewById(R.id.textsplash);
        texthome = (LinearLayout) findViewById(R.id.texthome);
        menus = (LinearLayout) findViewById(R.id.menus);

        bganim = AnimationUtils.loadAnimation(this, R.anim.bganim);

        bcgapp.animate().translationY(-1700).setDuration(800).setStartDelay(300);
        textsplash.animate().translationY(140).alpha(0).setDuration(800).setStartDelay(300);

        texthome.startAnimation(frombottom);
        menus.startAnimation(frombottom);


    }
    public void openmeter() {
        Intent intent = new Intent(this, meter.class);
        startActivity(intent);
    }

    public void openCalculateDistance() {
        Intent intent = new Intent( this, CalculateDistance.class);
        startActivity(intent);
    }

}