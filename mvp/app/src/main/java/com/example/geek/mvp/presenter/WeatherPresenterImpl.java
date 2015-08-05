package com.example.geek.mvp.presenter;

import com.example.geek.mvp.model.WeatherModel;
import com.example.geek.mvp.model.entity.Weather;
import com.example.geek.mvp.model.impl.WeatherModelImpl;
import com.example.geek.mvp.presenter.listener.OnWeatherListener;
import com.example.geek.mvp.ui.view.WeatherView;
import com.luck.mvp.presenter.MvpBasePresenter;

/**
 * 管理View的生命周期
 * 管理数据请求的逻辑控制
 * Created by geek on 2015/7/29.
 */
public class WeatherPresenterImpl extends MvpBasePresenter<WeatherView> implements WeatherPresenter,OnWeatherListener{
    private WeatherModel weatherModel;
    public WeatherPresenterImpl() {
        weatherModel = new WeatherModelImpl();
    }

    @Override
    public void loadWeatherInfo(String cityNo) {
        getView().showLoading(false);
        weatherModel.loadWeatherData(cityNo,this);
    }

    @Override
    public void onSuccess(Weather entity) {
        getView().showContent();
        getView().setupData(entity);
    }

    @Override
    public void onFailure(Throwable throwable, String errorMsg) {
        getView().showError(throwable,errorMsg,false);
    }

    @Override
    public void onProgress(long bytesWritten, long totalSize) {

    }
}
