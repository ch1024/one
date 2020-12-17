package com.example.one.base;

import com.example.one.baseApi.BaseView;

public abstract class BasePresenter<V extends BaseView>{
    protected V view;
    public void onAtton(V view){
        this.view=view;
    }
}
