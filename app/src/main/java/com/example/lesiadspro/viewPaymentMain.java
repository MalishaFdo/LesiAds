package com.example.lesiadspro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;


import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class viewPaymentMain extends AppCompatActivity {

    private RecyclerView recyclerView;
    PaymentAdapter adapter1; // Create Object of the Adapter class
    DatabaseReference databaseReference1; // Create object of the


    // Firebase Realtime Database

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_main);


        //Log.d("abc",user.toString());
        // Create a instance of the database and get
        // its reference
        String uid = FirebaseAuth.getInstance().getUid();
        databaseReference1 = FirebaseDatabase.getInstance().getReference().child("Payment");
        Log.d("abc",databaseReference1.toString());

        recyclerView = findViewById(R.id.recycler1);

        // To display the Recycler view linearly
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // It is a class provide by the FirebaseUI to make a
        // query in the database to fetch appropriate data
        FirebaseRecyclerOptions<Addpayment> options = new FirebaseRecyclerOptions.Builder<Addpayment>().setQuery(databaseReference1, Addpayment.class).build();
        // Connecting object of required Adapter class to
        // the Adapter class itself
        adapter1 = new PaymentAdapter(options);
        // Connecting Adapter class with the Recycler view*/
        recyclerView.setAdapter(adapter1);
    }

    // Function to tell the app to start getting
    // data from database on starting of the activity
    @Override
    protected void onStart() {
        super.onStart();
        adapter1.startListening();
    }

    // Function to tell the app to stop getting
    // data from database on stopping of the activity
    @Override
    protected void onStop() {
        super.onStop();
        adapter1.stopListening();
    }
}