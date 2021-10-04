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
        setContentView(R.layout.activity_view_payment_main);

        String uid = FirebaseAuth.getInstance().getUid();
        databaseReference1 = FirebaseDatabase.getInstance().getReference().child("Payment").child(uid);

        //Log.d("abc",user.toString());
        //Log.d("abc",databaseReference1.toString());

        recyclerView = findViewById(R.id.recycler1);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Payment> options = new FirebaseRecyclerOptions.Builder<Payment>().setQuery(databaseReference1, Payment.class).build();

        adapter1 = new PaymentAdapter(options);

        recyclerView.setAdapter(adapter1);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter1.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter1.stopListening();
    }
}
//bbb