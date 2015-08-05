package com.example.geek.mvp.model.entity;

import com.luck.mvp.model.entity.MvpEntity;

/**
 * Created by geek on 2015/7/29.
 */
public class Weather extends MvpEntity{
    private WeatherInfo weatherinfo;

    public WeatherInfo getWeatherinfo() {
        return weatherinfo;
    }

    public void setWeatherinfo(WeatherInfo weatherinfo) {
        this.weatherinfo = weatherinfo;
    }
}
