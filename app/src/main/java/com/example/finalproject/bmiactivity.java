package com.example.finalproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

@SuppressWarnings("deprecation")
public class bmiactivity extends AppCompatActivity {

    android.widget.Button mrecalulatebmi;

    TextView mbmidisplay,mbmicategory,mgender;
    Intent intent;
    ImageView mimageview;
    String mbmi;
    Button mtipsbtn;
    float intbmi;

    String height;
    String weight;
    float intheight,intweight;
    RelativeLayout mbackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiacticity);

        intent=getIntent();

        mbmidisplay=findViewById(R.id.bmidisplay);
        mbmicategory=findViewById(R.id.bmicategory);
        mgender=findViewById(R.id.genderdisplay);
        mbackground=findViewById(R.id.contentlayout);

        mimageview=findViewById(R.id.imageview);
        mrecalulatebmi=findViewById(R.id.recalculatebmi);

        height=intent.getStringExtra("height");
        weight=intent.getStringExtra("weight");

        intheight=Float.parseFloat(height);
        intweight=Float.parseFloat(weight);

        intheight=intheight/100;

        intbmi=intweight/(intheight*intheight);

        mbmi=Float.toString(intbmi);
        mtipsbtn=findViewById(R.id.tipsbtn);

        if (intbmi<18.4)
        {
            mbmicategory.setText("UNDERWEIGHT");
            mbackground.setBackgroundColor(Color.BLUE);
            mimageview.setImageResource(R.drawable.bmi_underweight);
        }
        else if (intbmi<25 && intbmi >18.4)
        {
            mbmicategory.setText("NORMAL");
            mbackground.setBackgroundColor(Color.GREEN);
            mimageview.setImageResource(R.drawable.bmi_normal);
        }
        else if (intbmi<30 && intbmi >25)
        {
            mbmicategory.setText("OVERWEIGHT");
            mbackground.setBackgroundColor(Color.YELLOW);
            mimageview.setImageResource(R.drawable.bmi_overweight);
        }
        else if (intbmi<39.9 && intbmi >30)
        {
            mbmicategory.setText("OBESE");
            mbackground.setBackgroundColor(Color.rgb(255, 165, 0));
            mimageview.setImageResource(R.drawable.bmi_obese);
        }
        else
        {
            mbmicategory.setText("EXTREMELY OBESE");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.bmi_extremely);
        }

        mgender.setText(intent.getStringExtra("gender"));
        mbmidisplay.setText(mbmi);


        mrecalulatebmi=findViewById(R.id.recalculatebmi);

        mrecalulatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(bmiactivity.this,insertbmiActivity.class);
                startActivity(intent);
                finish();
            }
        });

        mrecalulatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(bmiactivity.this,insertbmiActivity.class);
                startActivity(intent);
                finish();
            }
        });

        mtipsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(bmiactivity.this,BmiTipsActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}