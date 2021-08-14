package com.example.lesiadspro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class payCheckout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_checkout);
    }
    public void next(View view){
        Intent intent = new Intent(this,Addpayment.class);
        startActivity(intent);
    }
    public void next1(View view){
        Intent intent = new Intent(this,Editpayment.class);
        startActivity(intent);
    }
}
