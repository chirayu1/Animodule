package com.apps.saad.animodule;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class ForgotPassword extends AppCompatActivity {

    Button sendButton;
    EditText emailAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        emailAddress = (EditText) findViewById(R.id.editText8);
        sendButton = (Button) findViewById(R.id.button4);

        sendButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                final String email = emailAddress.getText().toString();
                if(!(emailValidator(email))){
                    Toast.makeText(getApplicationContext(), "Email is not valid!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(email.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Fill in the blanks!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Response.Listener<String> responseListener = new Response.Listener<String>() {

                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonResponse = new JSONObject(response);
                                boolean success = jsonResponse.getBoolean("success");

                                if (success) {
                                    // Go to the login page
                                    Intent intent = new Intent(ForgotPassword.this, loginActivity.class);
                                    startActivity(intent);
                                    // Show toast message of successfully sending password to email
                                    Toast myToast = Toast.makeText(getApplicationContext(), "Sent Successfully!", Toast.LENGTH_SHORT);
                                    myToast.show();

                                    finish();
                                } else {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(ForgotPassword.this);
                                    builder.setMessage("Email does not exist!")
                                            .setNegativeButton("Retry", null)
                                            .create()
                                            .show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    };

                    ForgotRequest forgotRequest = new ForgotRequest(email, responseListener);
                    RequestQueue queue = Volley.newRequestQueue(ForgotPassword.this);
                    queue.add(forgotRequest);
                }
                    //Toast.makeText(getApplicationContext(), "Sent Successfully!", Toast.LENGTH_SHORT).show();
                    //Intent intent = new Intent(ForgotPassword.this, loginActivity.class);
                    //startActivity(intent);

                    //finish();
            }
        });
    }

    public boolean emailValidator(String emailAddress)
    {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(emailAddress);
        return matcher.matches();
    }
}
