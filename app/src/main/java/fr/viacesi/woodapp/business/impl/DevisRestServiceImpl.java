package fr.viacesi.woodapp.business.impl;

import java.util.List;

import fr.viacesi.woodapp.business.AbstractRestBusinessService;
import fr.viacesi.woodapp.business.ClientsRestService;
import fr.viacesi.woodapp.business.DevisRestService;
import fr.viacesi.woodapp.http.ClientsHttpService;
import fr.viacesi.woodapp.http.DevisHttpService;
import fr.viacesi.woodapp.http.callback.AppCallback;
import fr.viacesi.woodapp.model.Client;
import fr.viacesi.woodapp.model.Devis;
import fr.viacesi.woodapp.model.User;

/**
 * Created by 1797531 on 04/02/2018.
 */

public class DevisRestServiceImpl extends AbstractRestBusinessService implements DevisRestService {
    private DevisHttpService devisService = retrofit.create(DevisHttpService.class);

    /*
    @Override
    public void sendDevis( String dateCrea, String nom, String reference, int status, int client, AppCallback<Devis> cb) {
        devisService.sendDevis(new Devis(dateCrea,nom,reference,status,client)).enqueue(wrapCallback(cb));
    }
    */

    @Override
    public void sendDevis(Devis devis, AppCallback<Devis> cb) {
        devisService.sendDevis(devis).enqueue(wrapCallback(cb));
    }

}