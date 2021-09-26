package com.example.lesiadspro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class person_payment extends AppCompatActivity {

    Button personPayEdit, personPayDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_payment);

        personPayEdit = findViewById(R.id.personPayEdit);
        personPayDelete = findViewById(R.id.personPayDelete);
    }

    public void next(View view){
        Intent intent = new Intent(person_payment.this, Editpayment.class);
        startActivity(intent);
    }

    public void next1(View view){
        Intent intent = new Intent(person_payment.this, RateApp.class);
        startActivity(intent);
    }
}