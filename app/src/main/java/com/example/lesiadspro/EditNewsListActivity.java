package com.example.lesiadspro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

public class EditNewsListActivity extends AppCompatActivity {

   /* EditText inputName2, inputDate2, inputArticles2;
    Button butSubmit2;
    AddNews adNews;
    DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_news_list);

        inputName2 = findViewById(R.id.inputName2);
        inputDate2 = findViewById(R.id.inputDate2);
        inputArticles2 = findViewById(R.id.inputArticles2);

        butSubmit2 = findViewById(R.id.butSubmit2);
        butSubmit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditData();
            }
        });

        adNews = new AddNews();

        //storage = FirebaseStorage.getInstance();
        //storageReference = storage.getReference();
    }
    public void ClearControls(){
        inputName2.setText("");
        inputDate2.setText("");
        inputArticles2.setText("");
    }

    //Updating Details
    public void EditData(){
        DatabaseReference updRef = FirebaseDatabase.getInstance().getReference().child("News");
        updRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.hasChild("uid")){
                    try {
                        adNews.setNewsName(inputName2.getText().toString().trim());
                       // adNews.setDate(Integer.parseInt(inputDate2.getText().toString().trim()));
                        adNews.setDate(inputDate2.getText().toString().trim());
                        adNews.setArticleName(inputArticles2.getText().toString().trim());

                        dbRef = FirebaseDatabase.getInstance().getReference().child("News").child("uid");
                        dbRef.setValue(adNews);

                        //Toast message for data in to the database
                        Toast.makeText(getApplicationContext(), "Data Updated Successfully", Toast.LENGTH_SHORT).show();
                        ClearControls();
                    }
                    catch (NumberFormatException e) {
                        Toast.makeText(getApplicationContext(), "Invalid Date", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                    Toast.makeText(getApplicationContext(), "No Source to Update", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

   public  void  next(View view){
        Intent int1 = new Intent(EditNewsListActivity.this, person.class);
        startActivity(int1);
   }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_news_list);
    }
}