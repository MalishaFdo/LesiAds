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
class PaymentAdapter extends FirebaseRecyclerAdapter<Addpayment, PaymentAdapter.payViewholder> {

    public PaymentAdapter(
            @NonNull FirebaseRecyclerOptions<Addpayment> options) {
        super(options);
    }

    // Function to bind the view in Card view(here
    // "person.xml") wth data in
    // model class(here "person.class")


    @Override
    protected void
    onBindViewHolder(@NonNull payViewholder holder,
                     int position, @NonNull Addpayment model) {


        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        Log.d("abc",user.toString());

        if (user != null) {
            Log.d("qwer","User found null");

            String uid = FirebaseAuth.getInstance().getUid();
//            for (UserInfo profile : user.getProviderData()) {
//                String providerId = profile.getProviderId();
            for (UserInfo profile : user.getProviderData()) {
                String providerId = profile.getProviderId();

                // Add firstname from model class (here
                // "person_payment.class")to appropriate view in Card
                // view (here "person_payment.xml")
                holder.payText1.setText(model.payObj.getP_name());

                // Add lastname from model class (here
                // "person_payment.class")to appropriate view in Card
                // view (here "person_payment.xml")
                holder.payText2.setText(model.payObj.getP_email());

                // Add age from model class (here
                // "person_payment.class")to appropriate view in Card
                // view (here "person_payment.xml")
                holder.payText3.setText((model.payObj.getCrdName()));
                holder.payText4.setText((model.payObj.getCrdNumber()));
                holder.payText5.setText((model.payObj.getCvv()));
                holder.payText6.setText((model.payObj.getExpireDate()));

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
    public payViewholder
    onCreateViewHolder(@NonNull ViewGroup Addpayment,
                       int viewType) {
        View view = LayoutInflater.from(Addpayment.getContext()).inflate(R.layout.activity_person, Addpayment, false);
        return new payViewholder(view);
    }

    // Sub Class to create references of the views in Card
    // view (here "person.xml")
    static class payViewholder
            extends RecyclerView.ViewHolder {
        TextView payText1, payText2, payText3, payText4, payText5, payText6;

        public payViewholder(@NonNull View payView) {
            super(payView);

            payText1 = payView.findViewById(R.id.payText1);
            payText2 = payView.findViewById(R.id.payText2);
            payText3 = payView.findViewById(R.id.payText3);
            payText4 = payView.findViewById(R.id.payText4);
            payText5 = payView.findViewById(R.id.payText5);
            payText6 = payView.findViewById(R.id.payText6);
        }
    }
}
