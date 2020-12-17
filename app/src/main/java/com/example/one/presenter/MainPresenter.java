package com.example.one.presenter;

import com.example.one.base.BasePresenter;
import com.example.one.baseApi.BaseView;
import com.example.one.bean.Beans;
import com.example.one.contract.Contract;
import com.example.one.http.api.NetCallBack;
import com.example.one.model.MainModel;

public class MainPresenter<V extends Contract.View> extends BasePresenter<V> implements Contract.Presenter,BaseView {

    private Contract.Model model;

    public MainPresenter() {
        model = new MainModel();
    }

    @Override
    public void getBean(String url) {
       model.getBean(url, new NetCallBack<Beans>() {
           @Override
           public void onSuccess(Beans beans) {
               view.onSSon(beans);
           }

           @Override
           public void onFail(String err) {

           }
       });
    }
}
