package com.example.one.http;

import com.example.one.http.api.ApiService;
import com.example.one.http.api.BaseUrl;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class RetrofitUtlis {
    private static RetrofitUtlis instance;
    private ApiService apiService;

    private RetrofitUtlis() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);
    }
    public RetrofitUtlis getInstance(){
        if (instance==null){
            synchronized (RetrofitUtlis.class){
                if (instance==null){
                    instance=new RetrofitUtlis();
                }
            }
        }
        return instance;
    }

}
