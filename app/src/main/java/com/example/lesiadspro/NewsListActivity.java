package com.example.lesiadspro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.common.net.InternetDomainName;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class NewsListActivity extends AppCompatActivity {
    EditText inputName, inputDate, inputArticles;
    Button btnSubmit, btnUpload;
    AddNews adNews;
    DatabaseReference dbRef;

    //private Uri filePath;

    //private final int PICK_IMAGE_REQUEST = 22;

    FirebaseStorage storage;
    StorageReference storageReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);

        inputName = findViewById(R.id.inputName);
        inputDate = findViewById(R.id.inputDate);
        inputArticles = findViewById(R.id.inputArticles);

        btnSubmit = findViewById(R.id.butSubmit);
        //btnUpload = findViewById(R.id.butUpload);

        adNews = new AddNews();

        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();

        //Log.d("xxxx",storage.toString());

        /*btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectImage();
            }
        });*/

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InsertData();


            }

        });

    }

        /*public void selectImage(){

            // Defining Implicit Intent to mobile gallery
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent,"Select Image from here..."),PICK_IMAGE_REQUEST);
        }*/

        public void ClearControls(){
            inputName.setText("");
            inputDate.setText("");
            inputArticles.setText("");
        }

        public void InsertData(){
            String uid = FirebaseAuth.getInstance().getUid();
            dbRef = FirebaseDatabase.getInstance().getReference().child("News").child(uid);
            try {
                if (TextUtils.isEmpty(inputName.getText().toString()))
                    Toast.makeText(getApplicationContext(),"Please Input the Newspaper Name", Toast.LENGTH_SHORT).show();
                else if (TextUtils.isEmpty(inputDate.getText().toString()))
                    Toast.makeText(getApplicationContext(),"Please Enter the Date", Toast.LENGTH_SHORT).show();
                else if (TextUtils.isEmpty(inputArticles.getText().toString()))
                    Toast.makeText(getApplicationContext(),"Please Enter the Article Name", Toast.LENGTH_SHORT).show();
                else {
                    adNews.setNewsName(inputName.getText().toString());
                    adNews.setDate(Integer.parseInt(inputDate.getText().toString()));
                    adNews.setArticleName(inputArticles.getText().toString());


                    DatabaseReference newref = dbRef.push();
                    newref.setValue(adNews);

                    Toast.makeText(getApplicationContext(), "Data Saved Successfully", Toast.LENGTH_SHORT).show();
                    ClearControls();

                    Intent intent1 = new Intent(NewsListActivity.this,person.class);
                    startActivity(intent1);


                }
            }
            catch (NumberFormatException e) {
                Toast.makeText(getApplicationContext(), "Invalid Publishing Date", Toast.LENGTH_SHORT).show();
            }
        }


        /*private void uploadImage(){
            if (filePath != null) {

            // Defining the child of storageReference
            StorageReference ref = storageReference.child("News").child("images/"+UUID.randomUUID().toString());

                // adding listeners on upload
            // or failure of image
            ref.putFile(filePath).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {

                                @Override
                                public void onSuccess(
                                        UploadTask.TaskSnapshot taskSnapshot) {

                                    Toast.makeText(NewsListActivity.this,"Image Uploaded!!",Toast.LENGTH_SHORT).show();
                                    Intent intent1 = new Intent(NewsListActivity.this,ConfirmationActivity.class);
                                    startActivity(intent1);

                                }
                            }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                            // Error, Image not uploaded

                            Toast.makeText(NewsListActivity.this,"Failed " + e.getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }).addOnProgressListener(
                            new OnProgressListener<UploadTask.TaskSnapshot>() {

                                // Progress Listener for loading
                                // percentage on the dialog box
                                @Override
                                public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                                    double progress= (100.0* taskSnapshot.getBytesTransferred()/ taskSnapshot.getTotalByteCount());

                                }
                            });
        }
    }*/
}


