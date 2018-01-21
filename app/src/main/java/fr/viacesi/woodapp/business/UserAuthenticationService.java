package fr.viacesi.woodapp.business;

import fr.viacesi.woodapp.http.callback.AppCallback;
import fr.viacesi.woodapp.model.Token;
import fr.viacesi.woodapp.model.User;

public interface UserAuthenticationService {
    void login(String login, String password, AppCallback<Token> cb);
    //void register(String email, String username, String password, AppCallback<Void> cb);

}
