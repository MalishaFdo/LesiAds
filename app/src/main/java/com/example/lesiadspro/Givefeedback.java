package com.example.lesiadspro;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Givefeedback extends AppCompatActivity {

    Button submit;
    Button update;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_givefeedback);


        submit = findViewById(R.id.mSubmitBtn);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent8 = new Intent(Givefeedback.this,profile.class);
                startActivity(intent8);
            }
        });

        update = findViewById(R.id.mUpdateBtn);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent9 = new Intent(Givefeedback.this,Editfeedback.class);
                startActivity(intent9);
            }
        });
    }

}