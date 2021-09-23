package com.example.lesiadspro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class profile extends AppCompatActivity {

    Button editprofile;
    Button feedback;
    Button viewNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        editprofile = findViewById(R.id.button7);
        editprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent6 = new Intent(profile.this,EditProfile.class);
                startActivity(intent6);
            }
        });

        feedback = findViewById(R.id.button9);
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent7 = new Intent(profile.this,Givefeedback.class);
                startActivity(intent7);
            }
        });

        viewNews = findViewById(R.id.button4);
        viewNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(profile.this,ViewNewspaperDetailsActivity.class);
                startActivity(intent4);
            }
        });
    }
}