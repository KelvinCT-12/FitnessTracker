package com.example.fitnesstracker;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class temperatureCode extends AppCompatActivity {

    private static final String TAG = "temperatureCode";

    private SensorManager sensorManager;

    private Sensor mTemp;

    SensorEventListener  sensorEventListener;

    TextView temp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meter);

        temp = (TextView) findViewById(R.id.temp);

        Log.d(TAG, "onCreate: Initializing Sensor Services");
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        mTemp = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);

        sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                float tempS = event.values[0];
                String tempnumber = "Temperature: ";
                tempnumber += String.valueOf(tempS);
                temp.setText(tempnumber);


            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
    }


    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(sensorEventListener, mTemp, sensorManager.SENSOR_DELAY_FASTEST);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(sensorEventListener);
    }


}