package com.apps.saad.animodule;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class setting extends AppCompatActivity {
    SharedPreferences shared;
    SharedPreferences.Editor editor;
    TextView Usernameinfo;
    TextView changePassword;
    TextView emailAddress;
    TextView fullName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        Usernameinfo = (TextView)findViewById(R.id.Usernameinfo);
        changePassword = (TextView)findViewById(R.id.changePassword);
        emailAddress = (TextView)findViewById(R.id.useremail);
        fullName = (TextView)findViewById(R.id.firstlastname);

        shared = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        editor = shared.edit();
        editor.apply();

        String username = shared.getString("username", "");
        //String password = shared.getString("password", "");
        String email = shared.getString("email", "");
        String fName = shared.getString("firstName", "");
        String lName = shared.getString("lastName", "");

        Usernameinfo.setText(username);
        fullName.setText(fName + " " + lName);

        changePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(setting.this,changePassword.class);
                startActivity(myIntent);
            }
        });

        emailAddress.setText(email);
    }
}
