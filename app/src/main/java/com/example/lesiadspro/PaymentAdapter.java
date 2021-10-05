package com.example.lesiadspro;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;
import java.util.Map;

class PaymentAdapter extends FirebaseRecyclerAdapter<Payment, PaymentAdapter.payViewholder> {

    public PaymentAdapter(
            @NonNull FirebaseRecyclerOptions<Payment> options) {
        super(options);
    }


    @Override
    protected void
    onBindViewHolder(@NonNull payViewholder holder,
                     @SuppressLint("RecyclerView") final int position, @NonNull Payment model) {


        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        Log.d("abc", user.toString());

        if (user != null) {
            Log.d("qwer", "User found null");

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
        } else {
            Log.d("qwe", "User was null");
        }

        //-----------------------EDIT---------------------------------------

        holder.personPayEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final DialogPlus dialogPlus = DialogPlus.newDialog(v.getContext())
                        .setContentHolder(new ViewHolder(R.layout.activity_editpayment))
                        .setExpanded(true, 1400)
                        .create();

                //dialogPlus.show();

                View view = dialogPlus.getHolderView();

                EditText p_name = view.findViewById(R.id.name3);
                EditText p_email = view.findViewById(R.id.email2);
                EditText crdName  = view.findViewById(R.id.cardname3);
                EditText crdNumber  = view.findViewById(R.id.number2);
                EditText cvv  = view.findViewById(R.id.number3);
                EditText expireDate  = view.findViewById(R.id.cvv2);


                Button btnUpdate = view.findViewById(R.id.Pay_EditButtn);

                p_name.setText(model.getP_name());
                p_email.setText(model.getP_email());
                crdName.setText(model.getCrdName());
                crdNumber.setText(model.getCrdNumber());
                cvv.setText(model.getCvv());
                expireDate.setText(model.getExpireDate());

                dialogPlus.show();

                btnUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Map<String, Object> map = new HashMap<>();
                        map.put("p_name",  p_name.getText().toString());
                        map.put("p_email",p_email.getText().toString());
                        map.put("crdName", crdName.getText().toString());
                        map.put("crdNumber", crdNumber.getText().toString());
                        map.put("cvv", cvv.getText().toString());
                        map.put("expireDate", expireDate.getText().toString());

//.child(getRef(position).getKey())
                        //DatabaseReference newref;
                        String uid = FirebaseAuth.getInstance().getUid();
                        Log.d("abcc", getRef(position).getKey());
                        Log.d("map", map.toString());

                        FirebaseDatabase.getInstance().getReference().child("Payment")
                                .child(uid).child(getRef(position).getKey()).updateChildren(map)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(holder.p_name.getContext(), "Data Updated Successfully.", Toast.LENGTH_SHORT).show();
                                        dialogPlus.dismiss();


                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(holder.p_name.getContext(), "Error While Updating.", Toast.LENGTH_SHORT).show();
                                        dialogPlus.dismiss();

                                    }
                                });


                    }
                });


            }
        });

        //-----------------------DELETE---------------------------------------

        holder.personPayDel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.p_name.getContext());
                builder.setTitle("Are You Sure ?");
                builder.setMessage("Deleted data can't be Undo.");

                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String uid = FirebaseAuth.getInstance().getUid();
                        FirebaseDatabase.getInstance().getReference().child("Payment")
                                .child(uid).child(getRef(position).getKey()).removeValue();


                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(holder.p_name.getContext(), "Cancelled", Toast.LENGTH_SHORT).show();

                    }
                });
                builder.show();

            }
        });

    }


    @NonNull
    @Override
    public payViewholder
    onCreateViewHolder(@NonNull ViewGroup Payment,
                       int viewType) {
        View view = LayoutInflater.from(Payment.getContext()).inflate(R.layout.activity_person_payment, Payment, false);
        return new PaymentAdapter.payViewholder(view);
    }

    class payViewholder extends RecyclerView.ViewHolder {
        TextView p_name, p_email, crdName, crdNumber, cvv, expireDate;
        Button personPayEdit, personPayDel2;

        public payViewholder(@NonNull View payView) {
            super(payView);

            p_name = payView.findViewById(R.id.inputName_1);
            p_email = payView.findViewById(R.id.inputDate_1);
            crdName = payView.findViewById(R.id.inputArticles_1);
            crdNumber = payView.findViewById(R.id.inputArticles_);
            cvv = payView.findViewById(R.id.inputArticles_2);
            expireDate = payView.findViewById(R.id.inputArticles_3);

            personPayEdit = (Button) payView.findViewById(R.id.personPayEdit);
            personPayDel2 = (Button) payView.findViewById(R.id.personPayDel2);
        }
    }
}
