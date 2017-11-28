package com.parsifal.cleanweather.domain.interactor.impl;

import com.parsifal.cleanweather.domain.bean.Weather;
import com.parsifal.cleanweather.domain.executor.Executor;
import com.parsifal.cleanweather.domain.executor.MainThread;
import com.parsifal.cleanweather.domain.interactor.base.AbstractInteractor;
import com.parsifal.cleanweather.domain.interactor.callback.GetWeatherCallback;
import com.parsifal.cleanweather.domain.repository.WeatherRepository;

/**
 * Created by yangming on 17-11-27.
 */
public class GetWeatherInteractorImpl extends AbstractInteractor {

    private WeatherRepository mRepository = null;

    private String mCityID = null;

    private GetWeatherCallback mCallback = null;

    public GetWeatherInteractorImpl(Executor threadExecutor, MainThread mainThread,
                                    WeatherRepository repository, String cityID, GetWeatherCallback callback) {
        super(threadExecutor, mainThread);
        this.mRepository = repository;
        this.mCityID = cityID;
        this.mCallback = callback;
    }

    @Override
    public void run() {
        final Weather weather = mRepository.getWeather(mCityID);
        if (null == weather) {
            // notify this on the main thread
            mMainThread.post(new Runnable() {
                @Override
                public void run() {
                    mCallback.onWeatherError("no result");
                }
            });
        } else {
            // send it on the main thread
            mMainThread.post(new Runnable() {
                @Override
                public void run() {
                    mCallback.onWeatherGet(weather.toString());
                }
            });
        }
    }
}
