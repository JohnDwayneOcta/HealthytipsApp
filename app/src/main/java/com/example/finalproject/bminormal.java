package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class bminormal extends AppCompatActivity {

    Button mbackbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bminormal);

        mbackbtn=findViewById(R.id.backbtn);

        mbackbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(bminormal.this,BmiTipsActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}