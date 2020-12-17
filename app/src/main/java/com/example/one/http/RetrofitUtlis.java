package com.example.one.http;

import com.example.one.http.api.ApiService;
import com.example.one.http.api.BaseUrl;
import com.example.one.http.api.NetCallBack;
import com.example.one.http.contract.ContractUtlis;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class RetrofitUtlis implements ContractUtlis {
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

    @Override
    public <T> void get(String url, NetCallBack<T> callBack) {
        apiService.get(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) { }
                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {
                        try {
                            String json = responseBody.string();
                            Gson gson = new Gson();
                            Type[] genericInterfaces = callBack.getClass().getGenericInterfaces();
                            Type[] arguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                            T fromJson = gson.fromJson(json, arguments[0]);
                            callBack.onSuccess(fromJson);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() { }
                });
    }

    @Override
    public <T> void post(String url, NetCallBack<T> callBack) {
        apiService.post(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) { }
                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {
                        try {
                            String json = responseBody.string();
                            Gson gson = new Gson();
                            Type[] genericInterfaces = callBack.getClass().getGenericInterfaces();
                            Type[] arguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                            T fromJson = gson.fromJson(json, arguments[0]);
                            callBack.onSuccess(fromJson);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() { }
                });
    }

    @Override
    public <T> void post(String url, HashMap<String, String> map, NetCallBack<T> callBack) {
        apiService.post(url,map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) { }
                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {
                        try {
                            String json = responseBody.string();
                            Gson gson = new Gson();
                            Type[] genericInterfaces = callBack.getClass().getGenericInterfaces();
                            Type[] arguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                            T fromJson = gson.fromJson(json, arguments[0]);
                            callBack.onSuccess(fromJson);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() { }
                });
    }
}
