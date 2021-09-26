package com.example.lesiadspro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class AdSubmission extends AppCompatActivity {

    EditText et;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_submission);

        et = findViewById(R.id.body_c);
        tv = findViewById(R.id.count_c);

        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String text1 = et.getText().toString();
                text1 = text1.replace("\n"," ");
                String[] textArray = text1.split(" ");
                tv.setText(textArray.length +"");
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}