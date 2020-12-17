package com.example.one.http.contract;

import com.example.one.http.api.NetCallBack;

import java.util.HashMap;

public interface ContractUtlis {
    public <T> void get(String url, NetCallBack<T> callBack);
    public <T> void post(String url,NetCallBack<T> callBack);
    public <T> void post(String url, HashMap<String,String> map, NetCallBack<T> callBack);
}
