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

class PaymentAdapter extends FirebaseRecyclerAdapter<Payment, PaymentAdapter.payViewholder> {

    public PaymentAdapter(
            @NonNull FirebaseRecyclerOptions<Payment> options) {
        super(options);
    }


    @Override
    protected void
    onBindViewHolder(@NonNull payViewholder holder,
                     int position, @NonNull Payment model) {


        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        Log.d("abc",user.toString());

        if (user != null) {
            Log.d("qwer","User found null");

            String uid = FirebaseAuth.getInstance().getUid();
           for (UserInfo profile : user.getProviderData()) {
              String providerId = profile.getProviderId();


                holder.p_name.setText(model.getP_name());
                holder.p_email.setText(model.getP_email());
                holder.crdName.setText((model.getCrdName()));
                holder.crdNumber.setText((model.getCrdNumber()));
                holder.cvv.setText((model.getCvv()));
                holder.expireDate.setText((model.getExpireDate()));

            }
        }else{
            Log.d("qwe","User was null");
        }
    }

    @NonNull
    @Override
    public payViewholder
    onCreateViewHolder(@NonNull ViewGroup Payment,
                       int viewType) {
        View view = LayoutInflater.from(Payment.getContext()).inflate(R.layout.activity_person_payment, Payment, false);
        return new PaymentAdapter.payViewholder(view);
    }

     class payViewholder
            extends RecyclerView.ViewHolder {
        TextView p_name, p_email, crdName, crdNumber, cvv, expireDate;

        public payViewholder(@NonNull View payView) {
            super(payView);

            p_name = payView.findViewById(R.id.inputName_1);
            p_email = payView.findViewById(R.id.inputDate_1);
            crdName = payView.findViewById(R.id.inputArticles_1);
            crdNumber = payView.findViewById(R.id.inputArticles_);
            cvv = payView.findViewById(R.id.inputArticles_2);
            expireDate = payView.findViewById(R.id.inputArticles_3);
        }
    }
}