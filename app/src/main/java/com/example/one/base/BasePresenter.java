package com.example.one.base;

import com.example.one.baseApi.BaseView;

public class BasePresenter<V extends BaseView>{
    V view;
    public void onAtton(V view){
        this.view=view;
    }
}
