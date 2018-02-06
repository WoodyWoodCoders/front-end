package fr.viacesi.woodapp.business;

import fr.viacesi.woodapp.http.callback.AppCallback;
import fr.viacesi.woodapp.model.Client;
import fr.viacesi.woodapp.model.Token;
import fr.viacesi.woodapp.model.User;

public interface UserRestService {
    void profile(AppCallback<User> cb);

}
