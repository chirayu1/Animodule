package com.apps.saad.animodule;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by Chirayu on 6/19/2017.
 */

//Making a request to the register.php file on the server and get a response as a string that is why we extend StringRequest

public class RegisterRequest extends StringRequest {
    // Specify the URL to the php file exact
    private static final String REGISTER_REQUEST_URL ="https://web.njit.edu/~cp262/android/register.php";
    //private static final String REGISTER_REQUEST_URL ="https://animodules.000webhostapp.com/register.php";
    private Map<String, String> params;


    public RegisterRequest(String fname, String lname, String emailAddress, String username, String password, String confirmpass, Response.Listener<String> listener){
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("firstName", fname);
        params.put("lastName", lname);
        params.put("email", emailAddress);
        params.put("username", username);
        params.put("password", password);
        params.put("confirmpassword", confirmpass);
    }

    @Override
    public Map<String, String> getParams(){
        return params;
    }

}
