package com.apps.saad.animodule;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Chirayu on 7/7/2017.
 */

public class ForgotRequest extends StringRequest {
    // Specify the URL to the php file exact
    private static final String FORGOT_REQUEST_URL ="https://web.njit.edu/~cp262/android/reset.php";
    //private static final String FORGOT_REQUEST_URL = "https://animodules.000webhostapp.com/reset.php";
    private Map<String, String> params;


    public ForgotRequest(String email, Response.Listener<String> listener){
        super(Method.POST, FORGOT_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("email", email);
    }

    @Override
    public Map<String, String> getParams(){
        return params;
    }

}
