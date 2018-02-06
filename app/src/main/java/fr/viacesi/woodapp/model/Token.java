package fr.viacesi.woodapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

/**
 * Created by Numalama on 18/01/2018.
 */

public class Token {

    private String token;

    public Token(){

    }

    public Token(String token){
        this.token = token;
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
