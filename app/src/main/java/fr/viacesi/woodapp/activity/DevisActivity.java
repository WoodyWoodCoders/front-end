package fr.viacesi.woodapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

import fr.viacesi.woodapp.R;
import fr.viacesi.woodapp.business.ServiceFactory;
import fr.viacesi.woodapp.http.callback.AppCallback;
import fr.viacesi.woodapp.model.Devis;
import fr.viacesi.woodapp.model.Token;
import fr.viacesi.woodapp.model.User;
import fr.viacesi.woodapp.utils.CryptageUtils;
import fr.viacesi.woodapp.utils.SharedPreferencesUtils;

/**
 * Created by 1797531 on 03/02/2018.
 */

public class DevisActivity extends Activity {
    private static final int MY_ACTIVITY_CODE = 0;
    private static final String TAG = "DevisActivity";
    public static TextView tvDevis;
    private Button bDevis;
    private Button bClient;
    private EditText etDevisName, etDevisReference, etDevisStatus;
    private Devis devis = new Devis();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devis);
        tvDevis = (TextView) findViewById(R.id.tvDevis);
        bDevis = (Button) findViewById(R.id.bDevis);
        bClient = (Button) findViewById(R.id.bClient);
        etDevisName = (EditText) findViewById(R.id.etDevisName);
        etDevisReference = (EditText) findViewById(R.id.etDevisReference);
        etDevisStatus = (EditText) findViewById(R.id.etDevisStatus);


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDateandTime = sdf.format(new Date());
        devis.setDateCrea(currentDateandTime);
        Log.i(TAG,"currentDateandTime : " + devis.getDateCrea());

        etDevisName.addTextChangedListener(new TextWatcher() {



            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!etDevisName.getText().toString().equals("")) {
                    devis.setNom(etDevisName.getText().toString());
                } else {

                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        etDevisReference.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!etDevisReference.getText().toString().equals("")) {
                    devis.setReference(etDevisReference.getText().toString());
                } else {

                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }


        });

        etDevisStatus.addTextChangedListener(new TextWatcher() {



            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!etDevisStatus.getText().toString().equals("")) {
                    devis.setStatus(Integer.parseInt(etDevisStatus.getText().toString()));
                } else {

                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }



    public void sendDevis(View View) {


        ServiceFactory.sendDevisRestService().sendDevis(devis, new AppCallback<Devis>() {
            @Override
            public void onSuccess(Devis obj, int code) {
                Log.i(TAG,"code : " + code);
                if(code == 200){

                    Log.i(TAG,"Devis name : " + obj.getNom());
                    Toast.makeText(DevisActivity.this,"Devis creation Success", Toast.LENGTH_SHORT).show();
                    //startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                    //goHome = true;
                }else{
                    Toast.makeText(DevisActivity.this,"Devis creation has Failed", Toast.LENGTH_SHORT).show();
                }
                //goHome = false;

            }

            @Override
            public void onFail(Throwable t) {
                Log.e(TAG, "Error !", t);
                // goHome = false;
            }
        });
    }

    public void getClient(View View){
        Intent intent = new Intent(this, ClientActivity.class);
        startActivityForResult(intent, MY_ACTIVITY_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    Intent data) {
        try {
            String nom_client = data.getStringExtra("client");
            int id_client = data.getIntExtra("client_id", -1);
            super.onActivityResult(requestCode, resultCode, data);
            switch (requestCode) {
                case MY_ACTIVITY_CODE:
                    switch (resultCode) {
                        case RESULT_CANCELED:
                            Toast.makeText(DevisActivity.this, "Ajout annulé", Toast.LENGTH_SHORT).show();
                            break;
                        case RESULT_OK:
                            bClient.setText(nom_client);
                            devis.setClient(id_client);
                            Log.i(TAG,"id_client : " + id_client);
                            Toast.makeText(DevisActivity.this, "Nouvel client selectionné  ", Toast.LENGTH_SHORT).show();
                            bDevis.setEnabled(true);

                            break;
                    }

                    break;

            }
        } catch (Exception ex) {
            Toast.makeText(DevisActivity.this, ex.toString(),
                    Toast.LENGTH_SHORT).show();
        }
    }
}