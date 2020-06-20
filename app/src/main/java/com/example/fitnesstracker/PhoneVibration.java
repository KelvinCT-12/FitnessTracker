package com.example.fitnesstracker;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class PhoneVibration extends AppCompatActivity {

    //Initialize Variable
    ImageButton ImageButton;
    Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meter);

        //Assign Variable
        ImageButton = findViewById(R.id.ImageButton);
        vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);

        //Perform OnClick Event
        ImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Set Vibration time in MilliSecond
                vibrator.vibrate( 1000);
            }
        });
    }
}