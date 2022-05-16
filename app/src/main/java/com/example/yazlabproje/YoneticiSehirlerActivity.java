package com.example.yazlabproje;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class YoneticiSehirlerActivity extends AppCompatActivity {

    EditText basiskele, cayirova, darica, derince, dilovasi, gebze, golcuk, kandira, karamursel, kartepe, korfez, izmit;
    Button btnGuncelle;

    public void init() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Sehirler");
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        basiskele = (EditText) findViewById(R.id.BasiskeleSayi);
        cayirova = (EditText) findViewById(R.id.CayirovaSayi);
        darica = (EditText) findViewById(R.id.DaricaSayi);
        derince = (EditText) findViewById(R.id.DerinceSayi);
        dilovasi = (EditText) findViewById(R.id.DilovasiSayi);
        gebze = (EditText) findViewById(R.id.GebzeSayi);
        golcuk = (EditText) findViewById(R.id.GolcukSayi);
        kandira = (EditText) findViewById(R.id.KandiraSayi);
        karamursel = (EditText) findViewById(R.id.KaramurselSayi);
        kartepe = (EditText) findViewById(R.id.KartepeSayi);
        korfez = (EditText) findViewById(R.id.KorfezSayi);
        izmit = (EditText) findViewById(R.id.IzmitSayi);
        btnGuncelle = (Button) findViewById(R.id.buttonGuncelle);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yonetici_sehirler);
        init();
        DatabaseReference db = FirebaseDatabase.getInstance("https://kintoandroid-default-rtdb.europe-west1.firebasedatabase.app/").getReference().child("Sehirler");

        btnGuncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id1 = Integer.parseInt(basiskele.getText().toString());
                int id2 = Integer.parseInt(cayirova.getText().toString());
                int id3 = Integer.parseInt(darica.getText().toString());
                int id4 = Integer.parseInt(derince.getText().toString());
                int id5 = Integer.parseInt(dilovasi.getText().toString());
                int id6 = Integer.parseInt(gebze.getText().toString());
                int id7 = Integer.parseInt(golcuk.getText().toString());
                int id8 = Integer.parseInt(kandira.getText().toString());
                int id9 = Integer.parseInt(karamursel.getText().toString());
                int id10 = Integer.parseInt(kartepe.getText().toString());
                int id11 = Integer.parseInt(korfez.getText().toString());
                int id12 = Integer.parseInt(izmit.getText().toString());

                db.child("Basiskele").child("Yolcu").setValue(id1);
                db.child("Cayirova").child("Yolcu").setValue(id2);
                db.child("Darica").child("Yolcu").setValue(id3);
                db.child("Derince").child("Yolcu").setValue(id4);
                db.child("Dilovasi").child("Yolcu").setValue(id5);
                db.child("Gebze").child("Yolcu").setValue(id6);
                db.child("Golcuk").child("Yolcu").setValue(id7);
                db.child("Kandira").child("Yolcu").setValue(id8);
                db.child("Karamursel").child("Yolcu").setValue(id9);
                db.child("Kartepe").child("Yolcu").setValue(id10);
                db.child("Korfez").child("Yolcu").setValue(id11);
                db.child("Izmit").child("Yolcu").setValue(id12);
            }
        });


    }




}