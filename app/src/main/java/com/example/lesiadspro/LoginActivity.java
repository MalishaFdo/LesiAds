package com.example.lesiadspro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    TextView registertxt;
    Button loginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        registertxt = (TextView)findViewById(R.id.mRegisterTxt);
        registertxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent1);
            }
        });

        loginbtn = findViewById(R.id.mLoginBtn);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent13 = new Intent(LoginActivity.this,profile.class);
                startActivity(intent13);
            }
        });

    }
}