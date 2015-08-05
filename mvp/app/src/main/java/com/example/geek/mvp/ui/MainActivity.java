package com.example.geek.mvp.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.geek.mvp.R;
import com.example.geek.mvp.model.entity.Weather;
import com.example.geek.mvp.presenter.WeatherPresenter;
import com.example.geek.mvp.presenter.WeatherPresenterImpl;
import com.example.geek.mvp.ui.view.WeatherView;
import com.luck.mvp.ui.activity.MvpActivity;

public class MainActivity extends MvpActivity<WeatherView,WeatherPresenter> implements WeatherView, View.OnClickListener {
    private ProgressBar progressBar;
    private TextView tvWeatherInfo;
    private Button butGetWeather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        tvWeatherInfo = (TextView) findViewById(R.id.tv_weather_info);
        butGetWeather = (Button) findViewById(R.id.but_get_weather);

        butGetWeather.setOnClickListener(this);
    }

    @NonNull
    @Override
    public WeatherPresenter createPresenter() {
        return new WeatherPresenterImpl();
    }

    @Override
    public void loadData(boolean pullToRefresh) {

    }

    @Override
    public void showLoading(boolean pullToRefresh) {
        progressBar.setVisibility(View.VISIBLE);
        tvWeatherInfo.setVisibility(View.GONE);
    }

    @Override
    public void showContent() {
        progressBar.setVisibility(View.GONE);
        tvWeatherInfo.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError(Throwable throwable, String errorMsg, boolean pullToRefresh) {
        Toast.makeText(this,"获取数据失败",Toast.LENGTH_LONG).show();
    }

    @Override
    public void setupData(Weather entity) {
        tvWeatherInfo.setText(entity.getWeatherinfo().toString());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but_get_weather:
                presenter.loadWeatherInfo("北京");
                break;
        }
    }


}
