package com.example.yazlabproje;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class TestActivity extends AppCompatActivity {

    DatabaseReference db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);


        Button btn1 = findViewById(R.id.button1);
        db = FirebaseDatabase.getInstance("https://kintoandroid-default-rtdb.europe-west1.firebasedatabase.app/").getReference().child("Sehirler");


        btn1.setOnClickListener(view -> {
            db.child("Izmit").child("Yolcu").setValue(12);


        });
    }
}