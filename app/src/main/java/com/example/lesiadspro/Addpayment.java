package com.example.lesiadspro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class Addpayment extends AppCompatActivity {

    EditText p_name, p_email, crdName, crdNumber, cvv, expireDate;
    Button pay_AddButtn;
    Payment payObj;
    DatabaseReference dbRef;

    FirebaseStorage storage;
    StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addpayment);

        p_name = findViewById(R.id.pay_name);
        p_email = findViewById(R.id.pay_email);
        crdName = findViewById(R.id.pay_cardname);
        crdNumber = findViewById(R.id.pay_cardNumber);
        cvv = findViewById(R.id.pay_cvv2);
        expireDate = findViewById(R.id.pay_ExpDate);
        pay_AddButtn = findViewById(R.id.pay_AddButtn);

        payObj = new Payment();

        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();

        pay_AddButtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SaveData();
            }
        });
   }

    public void ClearControls() {
        p_name.setText("");
        p_email.setText("");
        crdName.setText("");
        crdNumber.setText("");
        cvv.setText("");
        expireDate.setText("");
    }


    //save data in database
    public void SaveData() {
        String uid = FirebaseAuth.getInstance().getUid();
        dbRef = FirebaseDatabase.getInstance().getReference().child("Payment").child(uid);

        try {
            if (TextUtils.isEmpty(p_name.getText().toString()))
                Toast.makeText(getApplicationContext(), "Please Enter a Name ", Toast.LENGTH_SHORT).show();
            else if (TextUtils.isEmpty(p_email.getText().toString()))
                Toast.makeText(getApplicationContext(), "Please Enter an email", Toast.LENGTH_SHORT).show();
            else if (TextUtils.isEmpty(crdName.getText().toString()))
                Toast.makeText(getApplicationContext(), "Please Enter an Card Name", Toast.LENGTH_SHORT).show();
            else if (TextUtils.isEmpty(crdNumber.getText().toString()))
                Toast.makeText(getApplicationContext(), "Please Enter an Card Number", Toast.LENGTH_SHORT).show();
            else if (TextUtils.isEmpty(cvv.getText().toString()))
                Toast.makeText(getApplicationContext(), "Please Enter an CVV ", Toast.LENGTH_SHORT).show();
            else if (TextUtils.isEmpty(expireDate.getText().toString()))
                Toast.makeText(getApplicationContext(), "Please Enter an Card Expiry Date ", Toast.LENGTH_SHORT).show();
            else {
                //Take inputs from the users and assigning them to this instance (pay) of the Payment...
                payObj.setP_name(p_name.getText().toString().trim());
                payObj.setP_email(p_email.getText().toString().trim());
                payObj.setCrdName(crdName.getText().toString().trim());
                payObj.setCrdNumber(Integer.parseInt(crdNumber.getText().toString().trim()));
                payObj.setCvv(Integer.parseInt(cvv.getText().toString().trim()));
                payObj.setExpireDate(expireDate.getText().toString().trim());

                Log.d("xyz",payObj.getCrdNumber().toString());
                Log.d("xyza",payObj.getCvv().toString());
                Log.d("xyzab",payObj.getExpireDate().toString());

                //Insert in to the database
                dbRef.push();
                dbRef.setValue(payObj);

                //Feedback to the user via toast
                Toast.makeText(getApplicationContext(), "Data saved successfully !!!", Toast.LENGTH_SHORT).show();
                ClearControls();

                Intent intent = new Intent(Addpayment.this,payCheckout.class);
                startActivity(intent);

            }
        }
        catch (NumberFormatException e) {
            Toast.makeText(getApplicationContext(), "Invalid Card Number !!!", Toast.LENGTH_SHORT).show();
        }
    }
}
