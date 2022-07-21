package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class BmiTipsActivity extends AppCompatActivity {

    ImageView mimg1, mimg2, mimg3, mimg4, mimg5;
    Button mbackbtn, mcalculatebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_tips);

        mimg1=findViewById(R.id.img1);
        mimg2=findViewById(R.id.img2);
        mimg3=findViewById(R.id.img3);
        mimg4=findViewById(R.id.img4);
        mimg5=findViewById(R.id.img5);

        mbackbtn=findViewById(R.id.backbtn);
        mcalculatebtn=findViewById(R.id.calculatebtn);

        mimg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BmiTipsActivity.this,bmiunderweight.class);
                startActivity(intent);
                finish();
            }
        });

        mimg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BmiTipsActivity.this,bminormal.class);
                startActivity(intent);
                finish();
            }
        });

        mimg3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BmiTipsActivity.this,bmioverweight.class);
                startActivity(intent);
                finish();
            }
        });

        mimg4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BmiTipsActivity.this,bmiobese.class);
                startActivity(intent);
                finish();
            }
        });

        mimg5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BmiTipsActivity.this,bmiextremely.class);
                startActivity(intent);
                finish();
            }
        });

        mbackbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BmiTipsActivity.this,ProfileActivity.class);
                startActivity(intent);
                finish();
            }
        });

        mcalculatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BmiTipsActivity.this,splash.class);
                startActivity(intent);
                finish();
            }
        });

    }
}