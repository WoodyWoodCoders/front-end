package fr.viacesi.woodapp.business;

import java.util.List;

import fr.viacesi.woodapp.http.callback.AppCallback;
import fr.viacesi.woodapp.model.Client;
import fr.viacesi.woodapp.model.Devis;

/**
 * Created by 1797531 on 04/02/2018.
 */

public interface DevisRestService {
    //void sendDevis( String dateCrea, String nom, String reference, int status, int client, AppCallback<Devis> cb);
    void sendDevis( Devis devis, AppCallback<Devis> cb);
}
