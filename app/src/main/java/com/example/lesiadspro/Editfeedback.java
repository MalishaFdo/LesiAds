package com.example.lesiadspro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
    private String uName, uEmail, uFeed, uId;


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

        //Add data bundle for update
        //Save data with save button

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            mSaveBtn.setText("Update");
            uName = bundle.getString("uName");
            uId = bundle.getString("uId");
            uEmail = bundle.getString("uEmail");
            uFeed = bundle.getString("uFeed");

            mName.setText(uName);
            mEmail.setText(uEmail);
            mFeed.setText(uFeed);
        }else{
            mSaveBtn.setText("Save");
        }

        //Show inserted data
        mShowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Editfeedback.this,ShowFeedback.class));
            }
        });

        //Save data
        mSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mName.getText().toString();
                String email = mEmail.getText().toString();
                String feed = mFeed.getText().toString();

                //Validation process
                if(TextUtils.isEmpty(name)){
                    mName.setError("Your name please..");
                    return;
                }

                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Email is required . ");
                    return;
                }

                if (TextUtils.isEmpty(feed)){
                    mFeed.setError("Give your feedback..");
                    return;
                }


                Bundle bundle1 = getIntent().getExtras();
                if (bundle1!= null){
                        String id = uId;
                        updateToFireStore(id, name, email, feed);
                }else {
                    String id = UUID.randomUUID().toString();
                    savetoFireStore(id,name,email,feed);
                }
            }
        });

    }

    //update data to firestore-firebase
    private void updateToFireStore(String id, String name, String email, String feed) {
        db.collection("Comments").document(id).update("name",name,"email",email,"feed",feed)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(Editfeedback.this, "Data Updated", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(Editfeedback.this, "Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Editfeedback.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    //Insert data to firestore

    private void savetoFireStore(String id, String name, String email, String feed) {
        if (!name.isEmpty() && !email.isEmpty() && !feed.isEmpty()){
            HashMap<String, Object> map = new HashMap<>();
            map.put("id",id);
            map.put("name", name);
            map.put("email", email);
            map.put("feed", feed);

            //Call the collection path
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
