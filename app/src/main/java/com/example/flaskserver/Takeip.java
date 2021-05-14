package com.example.flaskserver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Takeip extends AppCompatActivity {


    Button gobtn,showuserlist;


    private TextInputEditText textInputEditTextipaddress;
    String ip,mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_takeip);

        showuserlist = findViewById(R.id.showuserlist);
        showuserlist.setVisibility(View.INVISIBLE);
        textInputEditTextipaddress = findViewById(R.id.textInputEditTextipaddresstxt);

        gobtn = findViewById(R.id.gobtn);
        mode = getIntent().getExtras().getString("mode");
        if(mode.equals("Admin")){
            showuserlist.setVisibility(View.VISIBLE);
        }
        showuserlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Takeip.this,Userslist.class));
            }
        });

        gobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ip = textInputEditTextipaddress.getText().toString().trim();
                Intent iis = new Intent(Takeip.this,MainActivity.class);
                iis.putExtra("ipaddress",ip);
                startActivity(iis);
            }
        });
    }
}