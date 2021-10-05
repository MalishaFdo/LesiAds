package com.example.lesiadspro;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CViewHolder extends RecyclerView.ViewHolder{

    TextView newspaperh,categoryh,dateh,statush;
    View view;

    public CViewHolder(@NonNull View itemView) {
        super(itemView);

        newspaperh = itemView.findViewById(R.id.newspaperi);
        categoryh = itemView.findViewById(R.id.categoryi);
        dateh = itemView.findViewById(R.id.datei);
        statush = itemView.findViewById(R.id.statusi);

        view = itemView;
    }
}
