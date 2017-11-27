package com.parsifal.cleanweather.domain.interactor.impl;

import com.parsifal.cleanweather.domain.executor.Executor;
import com.parsifal.cleanweather.domain.executor.MainThread;
import com.parsifal.cleanweather.domain.interactor.base.AbstractInteractor;
import com.parsifal.cleanweather.domain.interactor.base.GetWeatherInteractor;
import com.parsifal.cleanweather.domain.repository.WeatherRepository;

/**
 * Created by yangming on 17-11-27.
 */
public class GetWeatherInteractorImpl extends AbstractInteractor implements GetWeatherInteractor {

    private WeatherRepository mRepository = null;

    private GetWeatherInteractor.Callback mCallback = null;

    public GetWeatherInteractorImpl(Executor threadExecutor, MainThread mainThread,
                                    WeatherRepository repository, Callback callback) {
        super(threadExecutor, mainThread);
        this.mRepository = repository;
        this.mCallback = callback;
    }

    @Override
    public void run() {

    }
}
