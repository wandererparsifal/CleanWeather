package com.parsifal.cleanweather.presentation.converter;

import com.parsifal.cleanweather.domain.bean.Weather;

/**
 * Created by yangming on 17-11-28.
 */
public class WeatherConverter {

    public static String converter(Weather weather) {
        StringBuilder builder = new StringBuilder();
        Weather.HeWeather5Bean heWeather5Bean = weather.getHeWeather5().get(0);
        builder.append(heWeather5Bean.getBasic().getCity());
        builder.append("天气 ");
        builder.append(heWeather5Bean.getDaily_forecast().get(0).getCond().getTxt_d());
        return builder.toString();
    }
}
