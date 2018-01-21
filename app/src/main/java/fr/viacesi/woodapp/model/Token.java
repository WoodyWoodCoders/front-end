package fr.viacesi.woodapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

/**
 * Created by Numalama on 18/01/2018.
 */

public class Token {

    private String data;

    public Token(){

    }

    public Token(String data){
        this.data = data;
    }


    public String getToken() {
        return data;
    }

    public void setToken(String data) {
        this.data = data;
    }
}
