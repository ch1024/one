package com.example.one;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.one.base.BaseActivity;
import com.example.one.bean.Beans;
import com.example.one.contract.Contract;
import com.example.one.http.api.BaseUrl;
import com.example.one.presenter.MainPresenter;

public class MainActivity extends BaseActivity<MainPresenter> implements Contract.View {

    @Override
    protected int setViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected MainPresenter getPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void initData() {
        presenter.getBean(BaseUrl.BAURL);
    }

    @Override
    public void onSSon(Beans beans) {
        Log.d("111",beans.toString());
    }
}