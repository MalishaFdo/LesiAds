package com.example.lesiadspro;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private ShowFeedback activity;
    private List<NewModel> mlist;

    public MyAdapter(ShowFeedback activity, List<NewModel> mlist){
        this.activity = activity;
        this.mlist = mlist;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(activity).inflate(R.layout.item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(mlist.get(position).getName());
        holder.email.setText(mlist.get(position).getEmail());
        holder.feed.setText(mlist.get(position).getFeed());

    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name, email, feed;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);

            name = itemView.findViewById(R.id.name_text);
            email = itemView.findViewById(R.id.email_text);
            feed = itemView.findViewById(R.id.feed_text);
        }
    }
}
