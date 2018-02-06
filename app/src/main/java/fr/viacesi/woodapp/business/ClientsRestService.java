package fr.viacesi.woodapp.business;

import java.util.List;

import fr.viacesi.woodapp.http.callback.AppCallback;
import fr.viacesi.woodapp.model.Client;

/**
 * Created by 1797531 on 03/02/2018.
 */

public interface ClientsRestService {
    void getClients(AppCallback<List<Client>> cb);

}
