package com.apps.saad.animodule;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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


public class registerActivity extends AppCompatActivity {

    Button registerButton;
    EditText firstName;
    EditText lastName;
    EditText name;
    EditText passwd;
    EditText email;
    EditText confirmPassword;
    SharedPreferences shared;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerButton = (Button) findViewById(R.id.registerButton);
        firstName = (EditText) findViewById(R.id.editText3);
        lastName = (EditText) findViewById(R.id.editText4);
        email = (EditText) findViewById(R.id.editText9);
        name = (EditText) findViewById(R.id.editText5);
        passwd = (EditText) findViewById(R.id.editText6);
        confirmPassword = (EditText) findViewById(R.id.editText7);

        shared = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        editor = shared.edit();
        editor.apply();

        String username = shared.getString("username", "");
        String password = shared.getString("password", "");

        if(!(username.equals("") && password.equals(""))){
            Intent intent = new Intent(registerActivity.this, SubMainActivity.class);
            startActivity(intent);

            finish();
        }

        registerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String fname = firstName.getText().toString().trim();
                String lname = lastName.getText().toString().trim();
                String emailAddress = email.getText().toString().trim();
                String username = name.getText().toString().trim();
                String pass = passwd.getText().toString().trim();
                String confirmPass = confirmPassword.getText().toString().trim();

                if(fname.isEmpty() || lname.isEmpty() || emailAddress.isEmpty() || username.isEmpty() || pass.isEmpty() || confirmPass.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Fill in the blanks!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(!(emailValidator(emailAddress))){
                    Toast.makeText(getApplicationContext(), "Email is not valid!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(!username.matches("\\S+"))
                {
                    Toast.makeText(getApplicationContext(), "Username cannot contain whitespaces!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(username.length() <  6)
                {
                    Toast.makeText(getApplicationContext(), "Username too short! Must be at least 6 characters!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(userValidator(username))
                {
                    Toast.makeText(getApplicationContext(), "Username should not contain any special characters!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(!pass.matches("\\S+"))
                {
                    Toast.makeText(getApplicationContext(), "Password cannot contain whitespaces!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(pass.length() < 8)
                {
                    Toast.makeText(getApplicationContext(), "Password too short! Must be at least 8 characters!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(!passValidator(pass))
                {
                    Toast.makeText(getApplicationContext(), "Password must contain at least one lowercase letter and at least one number!", Toast.LENGTH_LONG).show();
                    return;
                }

                if(!(pass.equals(confirmPass))){
                    Toast.makeText(getApplicationContext(), "Password does not match!", Toast.LENGTH_SHORT).show();
                    return;
                }

                Response.Listener<String> responseListener = new Response.Listener<String>(){

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if(success){
                                // Go to the login page or dashboard page
                                Intent intent = new Intent(registerActivity.this, loginActivity.class);
                                startActivity(intent);
                                // Show toast message of registering successfully
                                Toast myToast = Toast.makeText(getApplicationContext(), "Successfully Registered!", Toast.LENGTH_SHORT);
                                myToast.show();

                                finish();
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(registerActivity.this);
                                builder.setMessage("Register Failed! Email or Username taken!")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                RegisterRequest registerRequest = new RegisterRequest(fname, lname, emailAddress, username, pass, confirmPass, responseListener);
                RequestQueue queue = Volley.newRequestQueue(registerActivity.this);
                queue.add(registerRequest);

                Log.d("buttons", "Sign up page clicked");
            }
        });
    }

    public boolean emailValidator(String email)
    {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
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

    public boolean userValidator(String username)
    {
        Pattern pattern;
        Matcher matcher;
        final String USER_PATTERN = "^(?=.*[!@#$%&*()_+=|<>?{}\\[\\]~-]).{6,}$";
        pattern = Pattern.compile(USER_PATTERN);
        matcher = pattern.matcher(username);
        return matcher.matches();
    }
}
