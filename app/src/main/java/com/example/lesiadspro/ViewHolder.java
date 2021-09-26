package com.example.lesiadspro;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {

    TextView mName,mEmail,mFeedback;
    View mView;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        mView = itemView;

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mClickListner.onItemClick(view, getAdapterPosition());

            }
        });

        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mClickListner.onItemLongClick(view, getAdapterPosition());
                return true;
            }
        });

        mName = itemView.findViewById(R.id.rName);
        mEmail = itemView.findViewById(R.id.rEmail);
        mFeedback = itemView.findViewById(R.id.rFeedback);


    }

    private ViewHolder.ClickListner mClickListner;

    public interface ClickListner{
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);

    }
    public void setOnClickListner (ViewHolder.ClickListner clickListner){
        mClickListner = clickListner;

    }
}
