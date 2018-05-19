package com.kirirushi.moneytracker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddItemActivity extends AppCompatActivity {

    private static final String TAG = "AddItemActivity";
    
    private EditText name;
    private EditText price;
    private Button addBtn;
    private boolean entered;
    private boolean entered2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additem);

        setTitle(R.string.add_item);

        entered = false;
        entered2 = false;


        name = findViewById(R.id.name);
        price = findViewById(R.id.price);
        addBtn = findViewById(R.id.add_btn);

        TextWatcher btnEnable = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(!TextUtils.isEmpty(s))
                    entered2=true;
                else
                    entered2=false;
                if(!TextUtils.isEmpty(s)&&entered) {
                    addBtn.setEnabled(true);
                    entered2 = true;
                }
                else
                    addBtn.setEnabled(false);

            }
        };

        TextWatcher btnEnable2 = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(!TextUtils.isEmpty(s))
                    entered=true;
                else
                    entered=false;
                if(!TextUtils.isEmpty(s)&&entered2) {
                    addBtn.setEnabled(true);
                    entered=true;
                }
                else
                    addBtn.setEnabled(false);
            }
        };
        name.addTextChangedListener(btnEnable);
        price.addTextChangedListener(btnEnable2);

        addBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String itemName = name.getText().toString();
                String itemPrice = price.getText().toString();
            }
        });
    }
}
