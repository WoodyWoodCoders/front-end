package fr.viacesi.woodapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import fr.viacesi.woodapp.R;
import fr.viacesi.woodapp.business.ServiceFactory;
import fr.viacesi.woodapp.http.callback.AppCallback;
import fr.viacesi.woodapp.model.User;

/**
 * Created by Numalama on 19/01/2018.
 */

public class HomeActivity extends Activity {
    private static final String TAG = "HomeActivity";
    //Decalaration de variable
    Button bDevis;
    public static TextView tvHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bDevis = (Button) findViewById(R.id.bDevis);
        tvHome = (TextView) findViewById(R.id.tvHome);

        ServiceFactory.getUserRestService().profile(new AppCallback<User>() {
            @Override
            public void onSuccess(User obj, int code) {
                Log.i(TAG,"code : " + code);
                Log.i(TAG,"Nom : " + obj.getUser().getNom());
                tvHome.setTextColor(Color.BLACK);
                tvHome.setText(obj.getUser().getNom());
                //Log.i(TAG,"token : " + ApiConstants.TOKEN_SESSION);
            }

            @Override
            public void onFail(Throwable t) {
                Log.e(TAG, "Error !", t);
            }
        });
    }
    public void openDevis(View View) {
        startActivity(new Intent(this, DevisActivity.class));
    }

}
