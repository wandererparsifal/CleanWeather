package com.parsifal.cleanweather.domain.interactor.callback;

/**
 * Created by yangming on 17-11-27.
 */
public interface GetWeatherCallback {

    void onWeatherGet(String weather);

    void onWeatherError(String error);
}
