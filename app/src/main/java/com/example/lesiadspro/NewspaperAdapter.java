package com.example.lesiadspro;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.FirebaseDatabase;

// FirebaseRecyclerAdapter is a class provided by
// FirebaseUI. it provides functions to bind, adapt and show
// database contents in a Recycler View
class NewspaperAdpter extends FirebaseRecyclerAdapter<AddNews, NewspaperAdpter.newsViewholder> {

    public NewspaperAdpter(
            @NonNull FirebaseRecyclerOptions<AddNews> options) {
        super(options);
    }

    // Function to bind the view in Card view(here
    // "person.xml") iwth data in
    // model class(here "person.class")


    @Override
    protected void
    onBindViewHolder(@NonNull newsViewholder holder,
                     int position, @NonNull AddNews model) {


        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        Log.d("abc",user.toString());
        if (user != null) {
            Log.d("qwer","User found null");
            String uid = FirebaseAuth.getInstance().getUid();
            for (UserInfo profile : user.getProviderData()) {
                String providerId = profile.getProviderId();

                // Add firstname from model class (here
                // "person.class")to appropriate view in Card
                // view (here "person.xml")
                holder.inputName_1.setText(model.getNewsName());

                // Add lastname from model class (here
                // "person.class")to appropriate view in Card
                // view (here "person.xml")
                holder.inputDate_1.setText(model.getDate());

                // Add age from model class (here
                // "person.class")to appropriate view in Card
                // view (here "person.xml")
                holder.inputArticles_1.setText((model.getArticleName()));

            }
        }else{
            Log.d("qwe","User was null");
        }
    }

    // Function to tell the class about the Card view (here
    // "person.xml")in
    // which the data will be shown
    @NonNull
    @Override
    public newsViewholder
    onCreateViewHolder(@NonNull ViewGroup AddNews,
                       int viewType) {
        View view = LayoutInflater.from(AddNews.getContext()).inflate(R.layout.activity_person, AddNews, false);
        return new NewspaperAdpter.newsViewholder(view);
    }

    // Sub Class to create references of the views in Card
    // view (here "person.xml")
    class newsViewholder
            extends RecyclerView.ViewHolder {
        TextView inputName_1, inputDate_1, inputArticles_1;

        public newsViewholder(@NonNull View itemView) {
            super(itemView);

            inputName_1 = itemView.findViewById(R.id.inputName_1);
            inputDate_1 = itemView.findViewById(R.id.inputDate_1);
            inputArticles_1 = itemView.findViewById(R.id.inputArticles_1);
        }
    }
}
