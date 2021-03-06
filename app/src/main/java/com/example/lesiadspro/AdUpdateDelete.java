package com.example.lesiadspro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AdUpdateDelete extends AppCompatActivity {

    EditText Vbody, Vname, Vdate, Vcategory;
    TextView Vcount;
    Advertisement adobj;

    DatabaseReference dbRef;
    String key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_update_delete);

        Vbody = findViewById(R.id.c_e_body);
        Vname = findViewById(R.id.c_e_newspaper);
        Vdate = findViewById(R.id.c_e_date);
        Vcategory = findViewById(R.id.c_e_category);
        Vcount = findViewById(R.id.c_e_count);

        adobj = new Advertisement();
        key = getIntent().getStringExtra("key");

        String uid = FirebaseAuth.getInstance().getUid();
        dbRef = FirebaseDatabase.getInstance().getReference().child("Advertisements").child(uid);


        dbRef.child(key).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@androidx.annotation.NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChildren()) {
                    Vname.setText(dataSnapshot.child("newspaper").getValue().toString());
                    Vdate.setText(dataSnapshot.child("pdate").getValue().toString());
                    Vcategory.setText(dataSnapshot.child("category").getValue().toString());
                    Vbody.setText(dataSnapshot.child("body").getValue().toString());
                    Vcount.setText(dataSnapshot.child("wordcount").getValue().toString());
                } else
                    Toast.makeText(getApplicationContext(), "No Source to Display", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        Vbody.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String text1 = Vbody.getText().toString();
                text1 = text1.replace("\n", " ");
                String[] textArray = text1.split(" ");
                Vcount.setText(textArray.length + "");
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}

    // Update advertisement
//    public void UpdateData(View view) {
//        String uid = FirebaseAuth.getInstance().getUid();
//        dbRef = FirebaseDatabase.getInstance().getReference().child("Advertisements").child(uid);
//        dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                if (dataSnapshot.hasChild("Advertisement 1")) {
//                    try {
//                        adobj.setNewspaper(Vname.getText().toString().trim());
//                        adobj.setPdate(Vdate.getText().toString().trim());
//                        adobj.setCategory(Vcategory.getText().toString().trim());
//                        adobj.setBody(Vbody.getText().toString().trim());
//                        adobj.setWordcount(Integer.parseInt(Vcount.getText().toString().trim()));
//                        adobj.setStatus("Pending");
//
//                        dbRef = FirebaseDatabase.getInstance().getReference().child("Advertisements").child("Advertisement 1");
//                        dbRef.setValue(adobj);
//
//                        Toast.makeText(getApplicationContext(), "Data updated successfully !!!", Toast.LENGTH_SHORT).show();
//                    }
//                    catch (NumberFormatException e) {
//                        Toast.makeText(getApplicationContext(), "Invalid count !!!", Toast.LENGTH_SHORT).show();
//                    }
//                }
//                else
//                    Toast.makeText(getApplicationContext(), "No source updated !!!", Toast.LENGTH_SHORT).show();
//            }
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) { }
//        });
//    }
    // Delete Advertisement
//    public void DeleteData(View view) {
//        String uid = FirebaseAuth.getInstance().getUid();
//        dbRef = FirebaseDatabase.getInstance().getReference().child("Advertisements").child(uid);
//        dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                if (dataSnapshot.hasChild("Advertisement 1")) {
//                    dbRef = FirebaseDatabase.getInstance().getReference().child("Advertisements").child("Advertisement 1");
//                    dbRef.removeValue();
//                    Toast.makeText(getApplicationContext(), "Data deleted successfully !!!", Toast.LENGTH_SHORT).show();
//                }
//                else
//                    Toast.makeText(getApplicationContext(), "No source deleted !!!", Toast.LENGTH_SHORT).show();
//            }
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) { }
//        });
//    }

