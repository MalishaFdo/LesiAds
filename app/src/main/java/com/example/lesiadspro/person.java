package com.example.lesiadspro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class person extends AppCompatActivity {

    Button idbtnEdit, idbtnDelete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);

        idbtnEdit = findViewById(R.id.idbtnEdit);
        idbtnDelete = findViewById(R.id.idbtnDelete);

    }

    public void next(View view){
        Intent intent = new Intent(person.this, EditNewsListActivity.class);
        startActivity(intent);
    }

    public void next1(View view){
        Intent intent = new Intent(person.this, AdminDashboardActivity.class);
        startActivity(intent);
    }
}