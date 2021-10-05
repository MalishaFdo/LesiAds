package com.example.lesiadspro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AdReview extends AppCompatActivity {

    EditText Vbody,Vname,Vdate,Vcategory;
    TextView Vcount;
    Advertisement adobj;

    DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_review);
    }
    // Read Advertisement
//    public void ViewData(View view){
//        dbRef = FirebaseDatabase.getInstance().getReference().child("Advertisements").child("Advertisement 1");
//        dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                if(dataSnapshot.hasChildren()){
//                    Vname.setText(dataSnapshot.child("newspaper").getValue().toString());
//                    Vdate.setText(dataSnapshot.child("pdate").getValue().toString());
//                    Vcategory.setText(dataSnapshot.child("category").getValue().toString());
//                    Vbody.setText(dataSnapshot.child("body").getValue().toString());
//                    Vcount.setText(dataSnapshot.child("wordcount").getValue().toString());
//                }
//                else
//                    Toast.makeText(getApplicationContext(),"No Advertisement to Display", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//    }
}