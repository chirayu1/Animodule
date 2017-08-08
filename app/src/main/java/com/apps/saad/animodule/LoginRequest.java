package com.apps.saad.animodule;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Chirayu on 6/20/2017.
 */

public class LoginRequest extends StringRequest {
    // Specify the URL to the php file exact
    private static final String LOGIN_REQUEST_URL ="https://web.njit.edu/~cp262/android/login.php";
    //private static final String LOGIN_REQUEST_URL ="https://animodules.000webhostapp.com/login.php";
    private Map<String, String> params;


    public LoginRequest(String username, String password, Response.Listener<String> listener){
        super(Method.POST, LOGIN_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);
    }

    @Override
    public Map<String, String> getParams(){
        return params;
    }

}
