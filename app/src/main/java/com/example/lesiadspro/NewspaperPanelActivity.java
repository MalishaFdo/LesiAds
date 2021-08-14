package com.example.lesiadspro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class NewspaperPanelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newspaper_panel);
    }
    public void next(View view){
        Intent intent = new Intent(this,ViewNewspaperDetailsActivity.class);
        startActivity(intent);
    }
    public void next1(View view){
        Intent intent = new Intent(this,ViewNewspaperDetailsActivity.class);
        startActivity(intent);
    }
    public void next2(View view){
        Intent intent = new Intent(this,ViewNewspaperDetailsActivity.class);
        startActivity(intent);
    }
    public void next3(View view){
        Intent intent = new Intent(this,ViewNewspaperDetailsActivity.class);
        startActivity(intent);
    }
    public void next4(View view){
        Intent intent = new Intent(this,ViewNewspaperDetailsActivity.class);
        startActivity(intent);
    }
    public void next5(View view){
        Intent intent = new Intent(this,ViewNewspaperDetailsActivity.class);
        startActivity(intent);
    }
}