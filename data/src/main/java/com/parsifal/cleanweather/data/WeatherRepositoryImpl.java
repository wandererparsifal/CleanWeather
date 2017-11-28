package com.parsifal.cleanweather.data;

import android.content.Context;

import com.parsifal.cleanweather.domain.repository.WeatherRepository;

/**
 * Created by yangming on 17-11-27.
 */
public class WeatherRepositoryImpl implements WeatherRepository {

    private Context mContext;

    public WeatherRepositoryImpl(Context context) {
        mContext = context;
    }

    @Override
    public String getWeather(String cityID) {
        String weather;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (null == cityID) {
            weather = null;
        } else if ("001".equals(cityID)) {
            weather = "晴";
        } else {
            weather = "多云";
        }
        return weather;
    }
}
