package com.example.one.http.api;

public interface NetCallBack<T> {
    void onSuccess(T t);
    void onFail(String err);
}
