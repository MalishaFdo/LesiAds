package com.example.lesiadspro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ViewNewspaperDetailsActivity extends AppCompatActivity {

//Btttt
    public Button btnViewNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_newspaper_details);

        btnViewNews = findViewById(R.id.butSubmit5);
        btnViewNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewNewspaperDetailsActivity.this, ConfirmationActivity.class);
                startActivity(intent);
            }


        });

    }
}


