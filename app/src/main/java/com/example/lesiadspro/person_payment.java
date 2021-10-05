
package com.example.lesiadspro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.common.util.concurrent.RateLimiter;
import com.google.firebase.database.DatabaseReference;

public class person_payment extends AppCompatActivity {
    DatabaseReference dbRef;
    Button idbtnEdit1, personPayDel2;
    ImageButton rate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_payment);

        idbtnEdit1 = findViewById(R.id.personPayEdit);
        personPayDel2 = findViewById(R.id.personPayDel2);
    }

    public void next(View view){
        Intent intent = new Intent(person_payment.this, Editpayment.class);
        startActivity(intent);
    }

    public void next1(View view){
        Intent intent = new Intent(person_payment.this, person_payment.class);
        startActivity(intent);
    }
}