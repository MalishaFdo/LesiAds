package com.example.lesiadspro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NewspaperPanelActivity extends AppCompatActivity {
    Button but1, butSubmit6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newspaper_panel);

        butSubmit6 = findViewById(R.id.butSubmit6);
        butSubmit6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewspaperPanelActivity.this,AdSubmission.class);
                startActivity(intent);
            }
        });

        but1 = findViewById(R.id.but1);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewspaperPanelActivity.this,ViewNewspaperDetailsActivity_3.class);
                startActivity(intent);
            }
        });
    }
    public void next(View view){
        Intent intent = new Intent(this,ViewNewspaperDetailsActivity_3.class);
        startActivity(intent);
    }
    public void next1(View view){
        Intent intent = new Intent(this,ViewNewspaperDetailsActivity.class);
        startActivity(intent);
    }
    public void next2(View view){
        Intent intent = new Intent(this,ViewNewspaperDetailsActivity_1.class);
        startActivity(intent);
    }
    public void next3(View view){
        Intent intent = new Intent(this,ViewNewspaperDetailsActivity_2.class);
        startActivity(intent);
    }
   /* public void next4(View view){
        Intent intent = new Intent(this,ViewNewspaperDetailsActivity_3.class);
        startActivity(intent);
    }
    public void next5(View view){
        Intent intent = new Intent(this,ViewNewspaperDetailsActivity.class);
        startActivity(intent);
    }*/
}