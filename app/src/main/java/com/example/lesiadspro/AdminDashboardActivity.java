package com.example.lesiadspro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminDashboardActivity extends AppCompatActivity {
    Button button17;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        button17 = findViewById(R.id.button17);
        button17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminDashboardActivity.this, AdminpayHistory.class);
                startActivity(intent);
            }
        });
    }
    public void next(View view){
        Intent intent = new Intent(this,NewsListActivity.class);
        startActivity(intent);
    }
    public void next1(View view){
        Intent intent = new Intent(this,NewsListActivity.class);
        startActivity(intent);
    }
}