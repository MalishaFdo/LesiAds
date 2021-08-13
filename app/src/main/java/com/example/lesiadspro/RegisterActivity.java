package com.example.lesiadspro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    TextView signin;

    Button signup;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        signin = (TextView)findViewById(R.id.textView9);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent3);
            }
        });

        signup = findViewById(R.id.button3);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(RegisterActivity.this, profile.class);
                startActivity(intent4);
            }
        });
    }
}