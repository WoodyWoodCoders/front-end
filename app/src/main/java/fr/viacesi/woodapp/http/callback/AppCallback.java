package fr.viacesi.woodapp.http.callback;

import fr.viacesi.woodapp.model.Token;

public interface AppCallback<T> {
    void onSuccess(T obj, int code);
    void onFail(Throwable t);
}
