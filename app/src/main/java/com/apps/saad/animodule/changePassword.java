package com.apps.saad.animodule;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class changePassword extends AppCompatActivity {

    EditText currentPassword;
    EditText newPassword;
    Button updatePassword;
    SharedPreferences shared;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        currentPassword = (EditText)findViewById(R.id.currentPassword);
        newPassword = (EditText)findViewById(R.id.newPassword);
        updatePassword = (Button)findViewById(R.id.updatePassword);

        shared = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        editor = shared.edit();
        editor.apply();

        final String password = shared.getString("password", "");

        updatePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String cPassword = currentPassword.getText().toString().trim();
                final String nPassword = newPassword.getText().toString().trim();

                if(cPassword.isEmpty() || nPassword.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Fill in the blanks!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(!(cPassword.equals(password))){
                    Toast.makeText(getApplicationContext(), "Current Password does not match!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(cPassword.equals(password)){
                    Toast.makeText(getApplicationContext(), "Password updated!", Toast.LENGTH_SHORT).show();
                    Intent myIntent = new Intent(changePassword.this, SubMainActivity.class);
                    startActivity(myIntent);
                }

                if(!nPassword.matches("\\S+"))
                {
                    Toast.makeText(getApplicationContext(), "Password cannot contain whitespaces!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(nPassword.length() < 8)
                {
                    Toast.makeText(getApplicationContext(), "Password too short! Must be at least 8 characters!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(!passValidator(nPassword))
                {
                    Toast.makeText(getApplicationContext(), "Password must contain at least one lowercase letter and at least one number!", Toast.LENGTH_LONG).show();
                    return;
                }

//                Response.Listener<String> responseListener = new Response.Listener<String>() {
//
//                    @Override
//                    public void onResponse(String response) {
//                        try {
//                            JSONObject jsonResponse = new JSONObject(response);
//                            boolean success = jsonResponse.getBoolean("success");
//
//                            if (success) {
//                                // Go to the SubMainActivity page
//                                Intent intent = new Intent(changePassword.this, SubMainActivity.class);
//                                startActivity(intent);
//                                // Show toast message of successfully updating new password
//                                Toast myToast = Toast.makeText(getApplicationContext(), "Password successfully updated!", Toast.LENGTH_SHORT);
//                                myToast.show();
//
//                                finish();
//                            } else {
//                                AlertDialog.Builder builder = new AlertDialog.Builder(changePassword.this);
//                                builder.setMessage("Something is wrong! Please try again!")
//                                        .setNegativeButton("Retry", null)
//                                        .create()
//                                        .show();
//                            }
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                };
//
//
//                ChangeRequest changeRequest = new ChangeRequest(nPassword, responseListener);
//                RequestQueue queue = Volley.newRequestQueue(changePassword.this);
//                queue.add(changeRequest);
            }
        });

    }

    public boolean passValidator(String password)
    {
        Pattern pattern;
        Matcher matcher;
        final String PASS_PATTERN = "^(?=.*[0-9])(?=.*[a-z]).{8,}$";
        pattern = Pattern.compile(PASS_PATTERN);
        matcher = pattern.matcher(password);
        return matcher.matches();
    }
}