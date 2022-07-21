package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.firebase.auth.FirebaseAuth;

public class insertbmiActivity extends AppCompatActivity {

    android.widget.Button mcalculatebmi;

    TextView mcurrenthieght, mcurrenthieghtft;
    TextView mcurrentage,mcurrentweight;
    ImageView mincrementage,mincrementweight,mdecrementage,mdecrementweight;
    SeekBar mseekbarforheight;
    LinearLayout mfemale,mmale;

    FirebaseAuth firebaseAuth;

    int intweight=74;
    int intage=24;

    String mintprogress="100";
    String mintprogress1="3.28084";
    String typeofuser="0";
    String weight2="74";
    String age2="25";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertbmi);


        mcalculatebmi=findViewById(R.id.calculatebmi);
        mcurrentage=findViewById(R.id.currentage);
        mcurrentweight=findViewById(R.id.currentweight);
        mcurrenthieght=findViewById(R.id.currentheight);
        mcurrenthieghtft=findViewById(R.id.currentheightft);
        mincrementage=findViewById(R.id.incrementage);
        mdecrementage=findViewById(R.id.decrementage);
        mincrementweight=findViewById(R.id.incrementweight);
        mdecrementweight=findViewById(R.id.decrementweight);
        mseekbarforheight  = (SeekBar) findViewById(R.id.seekbarforheight);
        mmale=findViewById(R.id.male);
        mfemale=findViewById(R.id.female);

        getSupportActionBar().setTitle("BMI Calculator");

        mmale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mmale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
                mfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotfocus));
                typeofuser="Male";

            }
        });

        mfemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mmale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotfocus));
                mfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
                typeofuser="Female";

            }
        });

        mseekbarforheight.setMax(300);
        mseekbarforheight.setMin(70);
        mseekbarforheight.setProgress(100);
        mseekbarforheight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int currentprogress, boolean fromUser) {
                mintprogress=String.valueOf(currentprogress);
                mcurrenthieght.setText(mintprogress);
                Double cm = Double.parseDouble(mcurrenthieght.getText().toString());
                Double foot = cm / 30.5;
                mcurrenthieghtft.setText(String.format(" %.1f", +foot));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mincrementage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intage=intage+1;
                age2=String.valueOf(intage);
                mcurrentage.setText(age2);

            }
        });

        mdecrementage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intage=intage-1;
                age2=String.valueOf(intage);
                mcurrentage.setText(age2);

            }
        });

        mincrementweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intweight=intweight+1;
                weight2=String.valueOf(intweight);
                mcurrentweight.setText(weight2);

            }
        });

        mdecrementweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intweight=intweight-1;
                weight2=String.valueOf(intweight);
                mcurrentweight.setText(weight2);

            }
        });



        mcalculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (typeofuser.equals("0"))
                {
                    Toast.makeText(insertbmiActivity.this, "Select your GENDER first!", Toast.LENGTH_LONG).show();
                } else if (mintprogress.equals("0")) {
                    Toast.makeText(insertbmiActivity.this, "Select your set your HEIGHT first!", Toast.LENGTH_LONG).show();
                } else if (intage == 0 || intage < 0) {
                    Toast.makeText(insertbmiActivity.this, "Age is incorrect!", Toast.LENGTH_LONG).show();
                } else if (intweight == 0 || intweight < 0) {
                    Toast.makeText(insertbmiActivity.this, "Weight is incorrect!", Toast.LENGTH_LONG).show();
                } else {

                    Intent intent = new Intent(insertbmiActivity.this, bmiactivity.class);
                    intent.putExtra("gender", typeofuser);
                    intent.putExtra("height", mintprogress);
                    intent.putExtra("weight", weight2);
                    intent.putExtra("age", age2);
                    startActivity(intent);

                }
            }
        });



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.logout:
                FirebaseAuth.getInstance().signOut();
                finish();
                startActivity(new Intent(insertbmiActivity.this,MainActivity.class));

            case R.id.back:
                finish();
                startActivity(new Intent(insertbmiActivity.this,ProfileActivity.class));
        }
        return super.onOptionsItemSelected(item);

    }

}