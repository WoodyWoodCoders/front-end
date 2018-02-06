package fr.viacesi.woodapp.business.impl;

import java.util.List;

import fr.viacesi.woodapp.business.AbstractBusinessService;
import fr.viacesi.woodapp.business.AbstractRestBusinessService;
import fr.viacesi.woodapp.business.ClientsRestService;
import fr.viacesi.woodapp.business.UserAuthenticationService;
import fr.viacesi.woodapp.business.UserRestService;
import fr.viacesi.woodapp.http.ClientsHttpService;
import fr.viacesi.woodapp.http.UserAuthenticationHttpService;
import fr.viacesi.woodapp.http.callback.AppCallback;
import fr.viacesi.woodapp.model.Client;
import fr.viacesi.woodapp.model.User;

/**
 * Created by 1797531 on 03/02/2018.
 */

public class ClientsRestServiceImpl extends AbstractRestBusinessService implements ClientsRestService {
    private ClientsHttpService clientService = retrofit.create(ClientsHttpService.class);

    @Override
    public void getClients( AppCallback<List<Client>> cb) {
        clientService.getClients().enqueue(wrapCallback(cb));
    }

}
