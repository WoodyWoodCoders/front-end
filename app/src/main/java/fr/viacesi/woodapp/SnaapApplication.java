package fr.viacesi.woodapp;

/**
 * Created by Numalama on 19/01/2018.
 */


import android.app.Application;
import android.content.Context;

public class SnaapApplication extends Application {

    public static Context APP_CTX;

    @Override
    public void onCreate() {
        super.onCreate();
        APP_CTX = this.getApplicationContext();
    }
}