package com.example.one.model;

import com.example.one.bean.Beans;
import com.example.one.contract.Contract;
import com.example.one.http.RetrofitUtlis;
import com.example.one.http.api.NetCallBack;

public class MainModel implements Contract.Model {
    @Override
    public void getBean(String url, NetCallBack<Beans> callBack) {
        RetrofitUtlis.getInstance().get(url,callBack);
    }
}
