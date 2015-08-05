package com.example.geek.mvp.model.impl;

import android.text.TextUtils;

import com.example.geek.mvp.model.WeatherModel;
import com.example.geek.mvp.model.entity.Weather;
import com.example.geek.mvp.presenter.listener.OnWeatherListener;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import org.apache.http.Header;

/**
 * Created by geek on 2015/7/29.
 */
public class WeatherModelImpl implements WeatherModel {

    @Override
    public void loadWeatherData(String cityNO, final OnWeatherListener onWeatherListener) {
        AsyncHttpClient httpClient = new AsyncHttpClient();
        httpClient.get("http://www.weather.com.cn/adat/sk/101010100.html", new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                onWeatherListener.onFailure(throwable,responseString);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                if (!TextUtils.isEmpty(responseString)) {
                    Gson gson = new Gson();
                    Weather weather = gson.fromJson(responseString, Weather.class);
                    onWeatherListener.onSuccess(weather);
                }
            }

            @Override
            public void onProgress(long bytesWritten, long totalSize) {
                super.onProgress(bytesWritten, totalSize);
            }
        });
    }
}
