package com.example.lesiadspro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    EditText mFirstName,mLastName,mUserName, mEmail,mPassword,mPhone;
    ProgressBar progressBar;
    FirebaseAuth fAuth;

    TextView signin;

    Button signup;

    TextView addphoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFirstName = findViewById(R.id.firstName);
        mLastName = findViewById(R.id.lastName);
        mUserName = findViewById(R.id.userName);
        mEmail = findViewById(R.id.Email);
        mPassword = findViewById(R.id.password);
        mPhone = findViewById(R.id.phone);

        fAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar);

        if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }

        signin = (TextView)findViewById(R.id.mSignInTxt);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent3);
            }
        });

        signup = findViewById(R.id.mSignUpBtn);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Email is required . ");
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    mPassword.setError("Password is needed . ");
                    return;
                }

                if(password.length()<6){
                    mPassword.setError("Password must be >= 6 characters");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                //register user in firebase

                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(RegisterActivity.this,"User Created", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),profile.class));

                        }else {
                            Toast.makeText(RegisterActivity.this,"Error !" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);

                        }
                    }
                });



            }
        });

        addphoto = (TextView)findViewById(R.id.mAddPhotoTxt);
        addphoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent10 = new Intent(RegisterActivity.this,AddPhoto.class);
                startActivity(intent10);
            }
        });

    }
}