package com.example.yazlabproje;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class KullaniciHomeActivity extends AppCompatActivity {


    private Button sehirsec;

    public void init(){
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Kullanıcı Paneli");
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        sehirsec = (Button) findViewById(R.id.buttonSehirSec);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kullanici_home);
        init();

        sehirsec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainM = new Intent(KullaniciHomeActivity.this, KullaniciSehirSecActivity.class);
                startActivity(mainM);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

}