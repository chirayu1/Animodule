package com.apps.saad.animodule;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import static java.lang.Boolean.getBoolean;

public class loginActivity extends AppCompatActivity {

    Button loginButton;
    EditText name;
    EditText pass;
    TextView forgotPass;
    SharedPreferences shared;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        name = (EditText) findViewById(R.id.editText);
        pass = (EditText) findViewById(R.id.editText2);
        loginButton = (Button) findViewById(R.id.button);
        forgotPass = (TextView) findViewById(R.id.textView2);

        shared = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        editor = shared.edit();
        editor.apply();

        String username = shared.getString("username", "");
        String password = shared.getString("password", "");

        if(!(username.equals("") && password.equals(""))){
            Intent intent = new Intent(loginActivity.this, SubMainActivity.class);
            startActivity(intent);

            finish();
        }
        final MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.elephant_audio);
        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                final String username = name.getText().toString().trim();  // user inputs username
                final String password = pass.getText().toString().trim();  // user inputs password

                if(username.isEmpty() || password.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Fill in the blanks!", Toast.LENGTH_SHORT).show();
                    return;
                }

                Response.Listener<String> responseListener = new Response.Listener<String>() {      // Response listener
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonResponse = new JSONObject(response);         // receive the call back from php file json
                            boolean success = jsonResponse.getBoolean("success");       // assign boolean to the "success" in php


                            if(success){                                                // if success is true

                                String username = jsonResponse.getString("username");      // retrieve php file response["username"]
                                String firstName = jsonResponse.getString("firstName");   // retrieve php file response["firstName"]
                                String lastName = jsonResponse.getString("lastName");
                                String email = jsonResponse.getString("email");
                                String password = jsonResponse.getString("password");
                                String confirmPass = jsonResponse.getString("password_confirm");

                                SharedPreferences shared = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = shared.edit();
                                editor.putString("username", username);
                                editor.putString("firstName", firstName);
                                editor.putString("lastName", lastName);
                                editor.putString("email", email);
                                editor.putString("password", password);
                                editor.putString("confirmPass", confirmPass);
                                editor.apply();

                                mp.start();

                                Intent intent = new Intent(loginActivity.this, SubMainActivity.class);

                                startActivity(intent);
                                //loginActivity.this.startActivity(intent);

                                finish();

                            }else {         // Else login failed, retry
                                Toast myToast = Toast.makeText(getApplicationContext(), "Login Failed!", Toast.LENGTH_SHORT);
                                myToast.show();
                                /*AlertDialog.Builder builder = new AlertDialog.Builder(loginActivity.this);
                                builder.setMessage("Login Failed!")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();*/
                            }
                        } catch (JSONException e) {         // catch error
                            e.printStackTrace();
                        }
                    }
                };

                LoginRequest loginRequest = new LoginRequest(username, password, responseListener);
                RequestQueue queue = Volley.newRequestQueue(loginActivity.this);
                queue.add(loginRequest);
            }
        });

        forgotPass.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(loginActivity.this, ForgotPassword.class);
                startActivity(intent);

                finish();
            }
        });
    }
}