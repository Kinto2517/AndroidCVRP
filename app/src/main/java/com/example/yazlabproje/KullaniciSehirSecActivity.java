package com.example.yazlabproje;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class KullaniciSehirSecActivity extends AppCompatActivity {


    private TextView sec;
    private Button btn;
    private RadioGroup rg;
    private RadioButton rbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kullanici_sehir_sec);
        btn = (Button) findViewById(R.id.buttonGor);
        sec = (TextView) findViewById(R.id.textViewSec);
        rg = (RadioGroup) findViewById(R.id.radioGroup);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int radioID = rg.getCheckedRadioButtonId();
                rbutton = findViewById(radioID);
                DatabaseReference db = FirebaseDatabase.getInstance("https://kintoandroid-default-rtdb.europe-west1.firebasedatabase.app/").getReference().child("Sehirler");
                db.child(rbutton.getText().toString()).addValueEventListener(new ValueEventListener() {
                    boolean is_added = false;
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String ma = snapshot.child("Yolcu").getValue().toString();
                        if(!is_added){
                            int a = Integer.parseInt(ma);
                            a += 1;
                            db.child(rbutton.getText().toString()).child("Yolcu").setValue(a);
                            is_added = true;
                            sec.setText("İsteğiniz Alınmıştır!");
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent mainIntent = new Intent(KullaniciSehirSecActivity.this, KullaniciHomeActivity.class);
                startActivity(mainIntent);
                finish();

            }
        });

    }



    private void readData(String sehir) {
        DatabaseReference db = FirebaseDatabase.getInstance("https://kintoandroid-default-rtdb.europe-west1.firebasedatabase.app/").getReference().child("Sehirler");
        db.child(sehir).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {

                if (task.isSuccessful()) {
                    DataSnapshot ds = task.getResult();
                    int yolcu = (int) ds.child("Yolcu").getValue();
                    sec.setText(yolcu);
                }
            }
        });

    }


}