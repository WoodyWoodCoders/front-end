package fr.viacesi.woodapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import fr.viacesi.woodapp.R;
import fr.viacesi.woodapp.business.ServiceFactory;
import fr.viacesi.woodapp.constant.ApiConstants;
import fr.viacesi.woodapp.http.callback.AppCallback;
import fr.viacesi.woodapp.model.Token;
import fr.viacesi.woodapp.utils.SharedPreferencesUtils;

public class LoginActivity extends Activity {

    private static final String TAG = "LoginActivity";
    //Decalaration de variable
    Button bLogin;
    EditText etUsername, etPassword;
    public static TextView tvReponse;
    //check etat des editTexte
    private boolean etatUsername = false;
    private boolean etatPassword = false;
    // go Home
    private boolean goHome = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        bLogin = (Button) findViewById(R.id.bLogin);
        tvReponse = (TextView) findViewById(R.id.tvReponse);

        etUsername.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!etUsername.getText().toString().equals("") && !etPassword.getText().toString().equals("")) {
                    etatUsername = true;
                } else {
                    etatUsername = false;
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        etPassword.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!etUsername.getText().toString().equals("") && !etPassword.getText().toString().equals("")) {
                    etatPassword = true;
                    bLogin.setEnabled(true);
                } else {
                    etatPassword = false;
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {
                // si editText username et editText password sont true alors btn est clickable
                if(etatUsername && etatPassword){
                    bLogin.setEnabled(true);
                }
            }


        });


    }


    public void sendLoginRequest(View View) {
        ServiceFactory.getUserAuthenticationService().login(etUsername.getText().toString(), etPassword.getText().toString(), new AppCallback<Token>() {
            @Override
            public void onSuccess(Token obj, int code) {
                Log.i(TAG,"code : " + code);
                if(code == 200){
                    SharedPreferencesUtils.putString("token",obj.getToken());
                    Log.i(TAG,"Token : " + SharedPreferencesUtils.getString("token"));
                    startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                    goHome = true;
                }
                goHome = false;

            }

            @Override
            public void onFail(Throwable t) {
                Log.e(TAG, "Error !", t);
                goHome = false;
            }
        });




    }
    }

