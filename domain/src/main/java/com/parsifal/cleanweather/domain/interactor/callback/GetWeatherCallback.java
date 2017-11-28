package com.parsifal.cleanweather.domain.interactor.callback;

import com.parsifal.cleanweather.domain.bean.Weather;

/**
 * Created by yangming on 17-11-27.
 */
public interface GetWeatherCallback {

    void onWeatherGet(Weather weather);

    void onWeatherError(String error);
}
