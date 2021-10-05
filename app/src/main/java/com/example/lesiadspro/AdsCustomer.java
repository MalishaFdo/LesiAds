package com.example.lesiadspro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdsCustomer extends AppCompatActivity {

    DatabaseReference dbRef;
    private FirebaseRecyclerOptions<Advertisement> options;
    private FirebaseRecyclerAdapter<Advertisement,CViewHolder> adapter;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ads_customer);

        recyclerView=findViewById(R.id.rv_cus);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        String uid = FirebaseAuth.getInstance().getUid();
        dbRef = FirebaseDatabase.getInstance().getReference().child("Advertisements").child(uid);

        options = new FirebaseRecyclerOptions.Builder<Advertisement>().setQuery(dbRef,Advertisement.class).build();
        adapter = new FirebaseRecyclerAdapter<Advertisement, CViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull CViewHolder holder, int position, @NonNull Advertisement ad) {

                final String key = getRef(position).getKey();
                holder.view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getApplicationContext(),AdUpdateDelete.class);
                        intent.putExtra("key",key);
                        startActivity(intent);
                    }
                });

                holder.newspaperh.setText(ad.getNewspaper());
                holder.categoryh.setText(ad.getCategory());
                holder.dateh.setText(ad.getPdate());
                holder.statush.setText(ad.getStatus());
            }

            @NonNull
            @Override
            public CViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemc,parent,false);

                return new CViewHolder(v);
            }
        };

        adapter.startListening();
        recyclerView.setAdapter(adapter);

    }
}