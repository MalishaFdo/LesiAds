package com.example.lesiadspro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Givefeedback extends AppCompatActivity {


    EditText mName, mEmail, mFeedback;

    ProgressDialog pd;

    FirebaseFirestore db;

    Button submit;
    Button update;
    Button goback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_givefeedback);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Add Feedback");

        mName = findViewById(R.id.editTextTextPersonName5);
        mEmail = findViewById(R.id.editTextTextEmailAddress2);
        mFeedback = findViewById(R.id.editTextTextMultiLine);

        pd = new ProgressDialog(this);

        db = FirebaseFirestore.getInstance();

        goback = findViewById(R.id.mBackButton);

        submit = findViewById(R.id.mSubmitBtn);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = mName.getText().toString().trim();
                String email = mEmail.getText().toString().trim();
                String feedback = mFeedback.getText().toString().trim();
                uploadData(name,email,feedback);
            }
            private void uploadData(String name, String email, String feedback) {
                pd.setTitle("Adding data to firestore");
                pd.show();
                String id = UUID.randomUUID().toString();

                Map<String,Object> doc = new HashMap<>();
                doc.put("id",id);
                doc.put("name",name);
                doc.put("email",email);
                doc.put("feedback",feedback);

                db.collection("Feedback").document(id).set(doc).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        pd.dismiss();
                        Toast.makeText(Givefeedback.this,"Feedback sent",Toast.LENGTH_SHORT).show();

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        pd.dismiss();
                        Toast.makeText(Givefeedback.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });

        update = findViewById(R.id.mUpdateBtn);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Givefeedback.this,ListActivity.class));
                finish();

            }
        });

        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Givefeedback.this,profile.class);
                startActivity(i);
            }
        });
    }

}