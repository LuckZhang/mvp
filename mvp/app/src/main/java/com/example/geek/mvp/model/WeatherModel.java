package com.example.geek.mvp.model;

import com.example.geek.mvp.presenter.listener.OnWeatherListener;
import com.luck.mvp.model.MvpModel;

/**
 * 说是模型，准确的说就是处理业务逻辑的Service，用来处理各种数据逻辑。
 * Created by geek on 2015/7/29.
 */
public interface WeatherModel extends MvpModel{
    /**
     * 处理加载天气信息的业务逻辑
     *
     * @param cityNO
     * @param onWeatherListener
     */
    public void loadWeatherData(String cityNO, OnWeatherListener onWeatherListener);

}
