package com.example.lesiadspro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
import java.util.UUID;

public class Editfeedback extends AppCompatActivity {

    private EditText mName,mEmail,mFeed;
    private Button mSaveBtn, mShowBtn;

    private FirebaseFirestore db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editfeedback);

        mName = findViewById(R.id.editTextTextPersonName5);
        mEmail = findViewById(R.id.editTextTextEmailAddress2);
        mFeed = findViewById(R.id.editTextTextMultiLine);

        mSaveBtn = findViewById(R.id.mSaveEditBtn);
        mShowBtn = findViewById(R.id.mShowBtn);

        db = FirebaseFirestore.getInstance();

        mShowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Editfeedback.this,ShowFeedback.class));
            }
        });

        mSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mName.getText().toString();
                String email = mEmail.getText().toString();
                String feed = mFeed.getText().toString();
                String id = UUID.randomUUID().toString();

                savetoFireStore(id,name,email,feed);
            }
        });

    }

    private void savetoFireStore(String id, String name, String email, String feed) {
        if (!name.isEmpty() && !email.isEmpty() && !feed.isEmpty()){
            HashMap<String, Object> map = new HashMap<>();
            map.put("id",id);
            map.put("name", name);
            map.put("email", email);
            map.put("feed", feed);

            db.collection("Comments").document(id).set(map)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(Editfeedback.this, "Data saved..", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(Editfeedback.this, "Failed..", Toast.LENGTH_SHORT).show();

                }
            });

        }else{
            Toast.makeText(this, "Empty fields..", Toast.LENGTH_SHORT).show();
        }
    }
}
