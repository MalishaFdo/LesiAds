package com.example.lesiadspro;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private final ShowFeedback activity;
    private final List<NewModel> mlist;
    private final FirebaseFirestore db = FirebaseFirestore.getInstance();

    public MyAdapter(ShowFeedback activity, List<NewModel> mlist){
        this.activity = activity;
        this.mlist = mlist;
    }

    //Concatenation
    public void updateData(int position){
        NewModel item = mlist.get(position);
        Bundle bundle = new Bundle();
        bundle.putString("uId", item.getId());
        bundle.putString("uName", item.getName());
        bundle.putString("uEmail", item.getEmail());
        bundle.putString("uFeed", item.getFeed());

        Intent intent = new Intent(activity,Editfeedback.class);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    //Adding collection path
    public void deleteData(int position){
        NewModel item = mlist.get(position);
        db.collection("Comments").document(item.getId()).delete()
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            notifyRemoved(position);
                            Toast.makeText(activity, "Data deleted", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(activity, "Error"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    //Notification
    private void notifyRemoved(int position){
        mlist.remove(position);
        notifyRemoved(position);
        activity.showData();
    }

    //Add viewholder
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
