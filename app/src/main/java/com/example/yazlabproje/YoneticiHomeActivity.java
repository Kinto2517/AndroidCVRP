package com.example.yazlabproje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class YoneticiHomeActivity extends AppCompatActivity {

    private Button btnMaps, btnSehirler, btn3;

    public void init()  {
        btnMaps = (Button) findViewById(R.id.buttonMaps);
        btnSehirler = (Button) findViewById(R.id.buttonSehirler);
        btn3 = (Button) findViewById(R.id.button3);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yonetici_home);
        init();

        btnMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentMap = new Intent(YoneticiHomeActivity.this, MapsActivity.class);
                startActivity(intentMap);
            }
        });

        btnSehirler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentMap = new Intent(YoneticiHomeActivity.this, YoneticiSehirlerActivity.class);
                startActivity(intentMap);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentMap = new Intent(YoneticiHomeActivity.this, TestActivity.class);
                startActivity(intentMap);
            }
        });

    }
}