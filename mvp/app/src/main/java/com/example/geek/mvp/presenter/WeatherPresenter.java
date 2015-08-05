package com.example.geek.mvp.presenter;

import com.example.geek.mvp.ui.view.WeatherView;
import com.luck.mvp.presenter.MvpPresenter;

/**
 * Created by geek on 2015/7/29.
 */
public interface WeatherPresenter extends MvpPresenter<WeatherView>{
    public void loadWeatherInfo(String cityNo);
}
