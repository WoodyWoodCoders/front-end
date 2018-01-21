package fr.viacesi.woodapp.http.interceptors;

import fr.viacesi.woodapp.constant.ApiConstants;

import java.io.IOException;

import fr.viacesi.woodapp.utils.SharedPreferencesUtils;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class JWTInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        String token = SharedPreferencesUtils.getString("token");
        if(token != ""){
            request = request.newBuilder()
                    .addHeader(ApiConstants.AUTHORIZATION_HEADER, "Bearer " + token )
                    .build();
        }
        return chain.proceed(request);

    }
}
