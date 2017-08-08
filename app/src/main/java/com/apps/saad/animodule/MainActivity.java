package com.apps.saad.animodule;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    Button loginButton;
    Button signupButton;
    SharedPreferences shared;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = (Button) findViewById(R.id.button);
        signupButton = (Button) findViewById(R.id.button2);

        shared = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        editor = shared.edit();
        editor.apply();

        String username = shared.getString("username", "");
        String password = shared.getString("password", "");

        if(!(username.equals("") && password.equals(""))){
            Intent intent = new Intent(MainActivity.this, SubMainActivity.class);
            startActivity(intent);

            finish();
        }


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("buttons", "login button clicked");
                Intent intent = new Intent(MainActivity.this, loginActivity.class);

                startActivity(intent);
            }
        });

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("buttons", "signup button clicked");
                Intent myIntent = new Intent(MainActivity.this, registerActivity.class);

                startActivity(myIntent);

            }
        });
    }
}