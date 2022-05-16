package com.example.yazlabproje;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class YoneticiActivity extends AppCompatActivity {

    private Button btnSubmit;
    private EditText txtEmail, txtPassword;

    private FirebaseAuth auth;

    public void init(){
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Admin");
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        auth = FirebaseAuth.getInstance();
        btnSubmit = (Button) findViewById(R.id.btnYLogin);
        txtEmail = (EditText) findViewById(R.id.txtUsername);
        txtPassword = (EditText) findViewById(R.id.txtPassword);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yonetici);
        init();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });
    }

    private void loginUser() {
        String email = txtEmail.getText().toString();
        String pass = txtPassword.getText().toString();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Email alanı boş olamaz!", Toast.LENGTH_LONG);
        } else if (TextUtils.isEmpty(pass)) {
            Toast.makeText(this, "Şifre alanı boş olamaz!", Toast.LENGTH_LONG);
        } else {
            auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (task.isSuccessful() && email != "ersin@ersin.com") {
                        Toast.makeText(YoneticiActivity.this, "Giriş Başarılı", Toast.LENGTH_LONG).show();
                        Intent mainIntent = new Intent(YoneticiActivity.this, YoneticiHomeActivity.class);
                        startActivity(mainIntent);
                        finish();

                    } else {
                        Toast.makeText(YoneticiActivity.this, "Giriş Başarısız Oldu!", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }


}