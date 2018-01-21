package fr.viacesi.woodapp.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
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
    public static TextView tvReponse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tvReponse = (TextView) findViewById(R.id.tvReponse);

        ServiceFactory.getUserRestService().profile(new AppCallback<User>() {
            @Override
            public void onSuccess(User obj, int code) {
                Log.i(TAG,"code : " + code);
                Log.i(TAG,"Nom : " + obj.getUser().getNom());
                tvReponse.setTextColor(Color.BLACK);
                tvReponse.setText(obj.getUser().getNom());
                //Log.i(TAG,"token : " + ApiConstants.TOKEN_SESSION);
            }

            @Override
            public void onFail(Throwable t) {
                Log.e(TAG, "Error !", t);
            }
        });
    }
}
