package com.example.lesiadspro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class RateApp extends AppCompatActivity {

    RatingBar ratingBar;
    Button Pay_RateButtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_app);

        ratingBar  = findViewById(R.id.ratingBar2);
        Pay_RateButtn = findViewById(R.id.Pay_RateButtn);

        Pay_RateButtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = String.valueOf(ratingBar.getRating());
                Toast.makeText(getApplicationContext(), s+"Star",Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(RateApp.this,profile.class);
                startActivity(intent);
            }
        });
    }

}