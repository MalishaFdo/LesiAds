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

import com.google.firebase.auth.FirebaseAuth;

public class profile extends AppCompatActivity {



    Button editprofile;
    Button feedback;
    Button viewnews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);




        editprofile = findViewById(R.id.mEditProfileBtn);
        editprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent6 = new Intent(profile.this,EditProfile.class);
                startActivity(intent6);
            }
        });

        feedback = findViewById(R.id.mGiveFeedbackBtn);
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent7 = new Intent(profile.this,Givefeedback.class);
                startActivity(intent7);
            }
        });

        viewnews = findViewById(R.id.mViewNewsBtn);
        viewnews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent14 = new Intent(profile.this,sidebar.class);
                startActivity(intent14);
            }
        });
    }


    public void logout(View view) {
        FirebaseAuth.getInstance().signOut(); //logout
        startActivity(new Intent(getApplicationContext(),LoginActivity.class));
        finish();
    }
}