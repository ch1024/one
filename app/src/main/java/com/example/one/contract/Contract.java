package com.example.one.contract;

import com.example.one.baseApi.BaseView;
import com.example.one.bean.Beans;

public interface Contract {
    interface View extends BaseView{
        void onSSon(Beans beans);
    }
    interface Presenter{
        void getBean(String url);
    }
    interface Model{
        void getBean(String url);
    }
}
