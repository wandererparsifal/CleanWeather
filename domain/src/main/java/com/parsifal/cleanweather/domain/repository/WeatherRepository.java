package com.parsifal.cleanweather.domain.repository;

import com.parsifal.cleanweather.domain.bean.Weather;

/**
 * Created by dmilicic on 12/13/15.
 */
public interface WeatherRepository {

    Weather getWeather(String cityID);
}
