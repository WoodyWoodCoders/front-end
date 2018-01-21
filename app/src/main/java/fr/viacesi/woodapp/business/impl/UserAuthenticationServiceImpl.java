package fr.viacesi.woodapp.business.impl;

import fr.viacesi.woodapp.business.AbstractBusinessService;
import fr.viacesi.woodapp.business.UserAuthenticationService;
import fr.viacesi.woodapp.constant.ApiConstants;
import fr.viacesi.woodapp.http.UserAuthenticationHttpService;
import fr.viacesi.woodapp.http.callback.AppCallback;
import fr.viacesi.woodapp.http.interceptors.JWTInterceptor;
import fr.viacesi.woodapp.model.AuthenticationRequest;
import fr.viacesi.woodapp.model.Token;
import fr.viacesi.woodapp.model.User;
import okhttp3.OkHttpClient;
import retrofit2.converter.gson.GsonConverterFactory;


public class UserAuthenticationServiceImpl extends AbstractBusinessService implements UserAuthenticationService {

    private UserAuthenticationHttpService authService = retrofit.create(UserAuthenticationHttpService.class);

    @Override
    public void login(String login, String password, AppCallback<Token> cb) {
        authService.login(new AuthenticationRequest(login, password)).enqueue(wrapCallback(cb));
    }


    /*
    @Override
    public void register(String email, String username, String password, AppCallback<Void> cb) {
        authService.register(new RegisterRequest(email,username, password)).enqueue(wrapCallback(cb));
    }
    */
}
