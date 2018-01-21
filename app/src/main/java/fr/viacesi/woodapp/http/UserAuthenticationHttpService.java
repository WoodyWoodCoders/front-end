package fr.viacesi.woodapp.http;

import fr.viacesi.woodapp.constant.ApiConstants;
import fr.viacesi.woodapp.model.AuthenticationRequest;


import fr.viacesi.woodapp.model.Token;
import fr.viacesi.woodapp.model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserAuthenticationHttpService {

    @POST(ApiConstants.LOGIN_URL)
    Call<Token> login(@Body AuthenticationRequest user);
    @GET(ApiConstants.PROFILE_URL)
    Call<User> profile();
    //Call<Void> register(@Body RegisterRequest user);
}
