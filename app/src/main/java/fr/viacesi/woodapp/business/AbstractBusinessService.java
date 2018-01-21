package fr.viacesi.woodapp.business;

import android.util.Log;

import org.json.JSONObject;

import fr.viacesi.woodapp.constant.ApiConstants;
import fr.viacesi.woodapp.http.callback.AppCallback;


import fr.viacesi.woodapp.model.Token;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.ContentValues.TAG;

public abstract class AbstractBusinessService {

    protected static OkHttpClient client;
    protected static Retrofit retrofit;

    static {
        client = new OkHttpClient();
        //client.interceptors().add();

        retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.API_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public AbstractBusinessService() {

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
