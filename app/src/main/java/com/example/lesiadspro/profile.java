package com.example.lesiadspro;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class profile extends AppCompatActivity {

    TextView firstname,lastname,email,username;
    FirebaseAuth fAuth;
    FirebaseFirestore fstore;
    String userID;
    FirebaseUser user;


    Button editprofile;
    Button feedback;
    Button viewnews;
    Button changepassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        firstname = findViewById(R.id.firstName);
        lastname = findViewById(R.id.lastName);
        email = findViewById(R.id.Email);
        username = findViewById(R.id.userName);
        changepassword = findViewById(R.id.changepasswordBtn);

        fAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();

        userID = fAuth.getCurrentUser().getUid();
        user = fAuth.getCurrentUser();

        DocumentReference documentReference = fstore.collection("users").document(userID);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {

                if (value.exists()){
                    firstname.setText(value.getString("fname"));
                    lastname.setText(value.getString("lname"));
                    email.setText(value.getString("email"));
                    username.setText(value.getString("username"));
                }else{
                    Log.d("tag","onEvent: Document does not exist");
                }



            }
        });

        changepassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final EditText resetPassword = new EditText(view.getContext());
                final AlertDialog.Builder passwordresetdialog = new AlertDialog.Builder(view.getContext());
                passwordresetdialog.setTitle("Reset Password ?");
                passwordresetdialog.setMessage("Enter new password (>6 characters long)");
                passwordresetdialog.setView(resetPassword);

                passwordresetdialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //extract email and send the reset link
                        String newPassword = resetPassword.getText().toString();
                        user.updatePassword(newPassword).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(profile.this,"Password reset successfully.", Toast.LENGTH_SHORT).show();

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(profile.this,"Password reset failed", Toast.LENGTH_SHORT).show();

                            }
                        });

                    }
                });

                passwordresetdialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //close the dialog

                    }
                });

                passwordresetdialog.create().show();
            }
        });




        editprofile = findViewById(R.id.mEditProfileBtn);
        editprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent6 = new Intent(profile.this,EditProfile.class);
                startActivity(intent6);
            }
        });

        feedback = findViewById(R.id.mGiveFeedbackBtn);
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent7 = new Intent(profile.this,Givefeedback.class);
                startActivity(intent7);
            }
        });

        viewnews = findViewById(R.id.mViewNewsBtn);
        viewnews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent14 = new Intent(profile.this,sidebar.class);
                startActivity(intent14);
            }
        });
    }


    public void logout(View view) {
        FirebaseAuth.getInstance().signOut(); //logout
        startActivity(new Intent(getApplicationContext(),LoginActivity.class));
        finish();
    }
}