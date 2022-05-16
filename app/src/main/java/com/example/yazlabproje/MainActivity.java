package com.example.yazlabproje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnKGirisYap;
    private Button btnYGirisYap;

    public void init(){

        btnKGirisYap = (Button) findViewById(R.id.btnKGirisYap);
        btnYGirisYap = (Button) findViewById(R.id.btnYGirisYap);


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        btnKGirisYap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentKullanici = new Intent(MainActivity.this, KullaniciActivity.class);
                startActivity(intentKullanici);
            }
        });

        btnYGirisYap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentKullanici = new Intent(MainActivity.this, YoneticiActivity.class);
                startActivity(intentKullanici);
            }
        });
    }
}