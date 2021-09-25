package com.example.lesiadspro;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class EditProfile extends AppCompatActivity {

    public static final String TAG = "TAG";
    EditText profilefirstname, profilelastname, profileusername, profileemail, profilephone;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;

    TextView editphoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        Intent data = getIntent();
        String firstname = data.getStringExtra("firstname");
        String lastname = data.getStringExtra("lastname");
        String username = data.getStringExtra("username");
        String email = data.getStringExtra("email");
        String phone = data.getStringExtra("phone");

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        profilefirstname = findViewById(R.id.editTextTextPersonName2);
        profilelastname = findViewById(R.id.editTextTextPersonName3);
        profileusername = findViewById(R.id.editTextTextPersonName4);
        profileemail = findViewById(R.id.editTextTextEmailAddress);
        profilephone = findViewById(R.id.editTextTextPassword2);


        profilefirstname.setText(firstname);
        profilelastname.setText(lastname);
        profileusername.setText(username);
        profileemail.setText(email);
        profilephone.setText(phone);


        Log.d(TAG,"onCreate: " + firstname + " " + lastname + " " + username + " " + email + " " + phone);

        editphoto = (TextView)findViewById(R.id.mEditPhotoTxt);
        editphoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent12 = new Intent(EditProfile.this,AddPhoto.class);
                startActivity(intent12);
            }
        });


    }
}