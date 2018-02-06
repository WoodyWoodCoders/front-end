package fr.viacesi.woodapp.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

import fr.viacesi.woodapp.R;
import fr.viacesi.woodapp.activity.adapteur.ClientListArrayAdapter;
import fr.viacesi.woodapp.business.ServiceFactory;
import fr.viacesi.woodapp.http.callback.AppCallback;
import fr.viacesi.woodapp.model.Client;
import fr.viacesi.woodapp.model.User;


/**
 * Created by 1797531 on 03/02/2018.
 */

public class ClientActivity extends Activity {
    private static final String TAG = "ClientActivity";
    private ClientListArrayAdapter clientListAdapter;
    protected ListView list;
    private List<Client> clientList = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);


        list = (ListView) findViewById(R.id.results_listview);


        getClients();
        registerClickCallBack();
    }
    public void getClients(){
        ServiceFactory.getClientsRestService().getClients(new AppCallback<List<Client>>() {
            @Override
            public void onSuccess(List<Client> obj, int code) {
                Log.i(TAG,"code : " + code);

                clientList = obj;



                if(code == 200){
                    for(int i = 0; i < obj.size();i++){
                        Log.i(TAG,"client name : " +  obj.get(i).getNom());
                    }
                    /*
                    clientListAdapter.notifyDataSetChanged();
                    */
                    populateListView();
                }




                //Log.i(TAG,"Nom : " + obj.get);
                //tvHome.setTextColor(Color.BLACK);
                //tvHome.setText(obj.getUser().getNom());
                //Log.i(TAG,"token : " + ApiConstants.TOKEN_SESSION);
            }

            @Override
            public void onFail(Throwable t) {
                Log.e(TAG, "Error !", t);
            }
        });
    }

    public void populateListView(){
        clientListAdapter = new ClientListArrayAdapter(
                ClientActivity.this,
                clientList
        );


        list.setAdapter(clientListAdapter);
    }
    public void registerClickCallBack(){
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> paret, View viewClicked, int position, long id) {
                Client client = (Client)paret.getAdapter().getItem(position);
                //Client client = (Client) list.getSelectedItem();
                Toast.makeText(ClientActivity.this, client.getNom(), Toast.LENGTH_LONG).show();

                getIntent().putExtra("client", client.getNom());
                getIntent().putExtra("client_id", client.getId());
                setResult(RESULT_OK, getIntent());
                finish();
            }
        });
    }
}
