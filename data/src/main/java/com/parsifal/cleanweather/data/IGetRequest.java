package com.parsifal.cleanweather.data;

import com.parsifal.cleanweather.data.bean.Weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by yangming on 17-11-3.
 */
public interface IGetRequest {

    @GET("v5/weather/")
    Call<Weather> getWeather(@Query("city") String cityID);
}
