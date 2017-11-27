package com.parsifal.cleanweather.domain.repository;

/**
 * Created by dmilicic on 12/13/15.
 */
public interface WeatherRepository {

    String getWeather(String cityID);
}
