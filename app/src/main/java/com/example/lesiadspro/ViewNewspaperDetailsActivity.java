package com.example.lesiadspro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ViewNewspaperDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_newspaper_details);
    }
    public void next(View view){
        Intent intent = new Intent(this,NewspaperHistoryActivity.class);
        startActivity(intent);
    }

}