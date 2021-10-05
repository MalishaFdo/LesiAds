package com.example.lesiadspro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ViewNewspaperDetailsActivity_2 extends AppCompatActivity {

    public Button btnViewNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_newspaper_details2);

        btnViewNews = findViewById(R.id.but_ok3);
        btnViewNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewNewspaperDetailsActivity_2.this, NewspaperPanelActivity.class);
                startActivity(intent);
            }


        });
    }
}