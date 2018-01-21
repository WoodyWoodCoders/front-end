package fr.viacesi.woodapp.business;

import fr.viacesi.woodapp.constant.ApiConstants;
import fr.viacesi.woodapp.http.callback.AppCallback;
import fr.viacesi.woodapp.http.interceptors.JWTInterceptor;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class AbstractRestBusinessService {

    protected static OkHttpClient client;
    protected static Retrofit retrofit;

    static {
        client = new OkHttpClient.Builder()
                .addInterceptor(new JWTInterceptor())
                .build();
        //client.interceptors().add();

        retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.REST_API_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public AbstractRestBusinessService() {

    }

    protected <T> Callback<T> wrapCallback(final AppCallback<T> appCallback) {
        return new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                appCallback.onSuccess(response.body(), response.code());
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                appCallback.onFail(t);
            }
        };
    }

}
