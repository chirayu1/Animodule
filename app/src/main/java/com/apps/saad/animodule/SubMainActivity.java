package com.apps.saad.animodule;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;


//Create by Saad Anwar 7/1/2017
public class SubMainActivity extends AppCompatActivity {
    Button create,settings,logout;
    ImageButton alligator,butterfly,cougar,elephantcolored;
    ImageView mainImg,logo;
    SharedPreferences shared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_main);


        next();
        flipImages();

    }
    private void next(){
        create = (Button) findViewById(R.id.create_animodule);
        settings = (Button) findViewById(R.id.setting);
        shared = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        logout = (Button) findViewById(R.id.logout);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(SubMainActivity.this,ElephantDesignActivity.class);
                startActivity(myIntent);
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(SubMainActivity.this, setting.class);
                startActivity(myIntent);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor = shared.edit();
                editor.clear();
                editor.apply();
                Intent intent = new Intent(SubMainActivity.this, loginActivity.class);
                startActivity(intent);

                finish();
            }
        });

    }
    private void flipImages(){
        alligator = (ImageButton) findViewById(R.id.alligator);
        butterfly = (ImageButton) findViewById(R.id.butterfly);
        cougar = (ImageButton) findViewById(R.id.cougar);
        elephantcolored = (ImageButton) findViewById(R.id.elephantcolored);

        logo = (ImageView) findViewById(R.id.logo);

        Glide.with(this)
                .load(R.drawable.animodules_logo)
                .into(logo);
        Glide.with(this)
                .load(R.drawable.elephantcolored)
                .into(elephantcolored);
        Glide.with(this)
                .load(R.drawable.butterflycolored)
                .into(butterfly);
        Glide.with(this)
                .load(R.drawable.alligatorcolored)
                .into(alligator);
        Glide.with(this)
                .load(R.drawable.cougarcolored)
                .into(cougar);

        mainImg = (ImageView) findViewById(R.id.mainImage);

        Glide.with(this)
                .load(R.drawable.elephantcolored)
                .into(mainImg);

        alligator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Glide.with(getApplicationContext())
                        .load(R.drawable.alligatorcolored)
                        .into(mainImg);
                mainImg.setMaxWidth(100);

            }
        });


        butterfly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Glide.with(getApplicationContext())
                        .load(R.drawable.butterflycolored)
                        .into(mainImg);
            }
        });
        cougar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Glide.with(getApplicationContext())
                        .load(R.drawable.cougarcolored)
                        .into(mainImg);
            }
        });

        elephantcolored.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Glide.with(getApplicationContext())
                        .load(R.drawable.elephantcolored)
                        .into(mainImg);
            }
        });
    }

}
