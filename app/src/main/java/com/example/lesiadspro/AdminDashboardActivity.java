package com.example.lesiadspro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AdminDashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);
    }
    public void next(View view){
        Intent intent = new Intent(this,NewsListActivity.class);
        startActivity(intent);
    }
    public void next1(View view){
        Intent intent = new Intent(this,NewspaperHistoryActivity.class);
        startActivity(intent);
    }
}