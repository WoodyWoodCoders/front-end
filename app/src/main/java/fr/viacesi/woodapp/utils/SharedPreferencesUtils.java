package fr.viacesi.woodapp.utils;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import fr.viacesi.woodapp.SnaapApplication;

/**
 * Created by Numalama on 19/01/2018.
 */

public class SharedPreferencesUtils {

    public static void putString(String key, String val) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(SnaapApplication.APP_CTX);
        SharedPreferences.Editor editor = prefs.edit();
        editor = editor.putString(key, val);
        editor.apply();
    }

    public static String getString(String key) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(SnaapApplication.APP_CTX);
        return prefs.getString(key, null);
    }
}
