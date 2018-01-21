package fr.viacesi.woodapp.business.impl;

import fr.viacesi.woodapp.business.AbstractBusinessService;
import fr.viacesi.woodapp.business.AbstractRestBusinessService;
import fr.viacesi.woodapp.business.UserAuthenticationService;
import fr.viacesi.woodapp.business.UserRestService;
import fr.viacesi.woodapp.http.UserAuthenticationHttpService;
import fr.viacesi.woodapp.http.callback.AppCallback;
import fr.viacesi.woodapp.model.AuthenticationRequest;
import fr.viacesi.woodapp.model.Token;
import fr.viacesi.woodapp.model.User;


public class UserRestServiceImpl extends AbstractRestBusinessService implements UserRestService {

    private UserAuthenticationHttpService authService = retrofit.create(UserAuthenticationHttpService.class);

    @Override
    public void profile( AppCallback<User> cb) {
        authService.profile().enqueue(wrapCallback(cb));
    }



}
