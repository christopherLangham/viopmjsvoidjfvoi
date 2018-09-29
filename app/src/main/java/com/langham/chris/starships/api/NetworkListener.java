package com.langham.chris.starships.api;

public interface NetworkListener<T> {
    void onSuccess(T t);

    void onFailure(Throwable error);
}
