package com.parsifal.cleanweather.presentation.presenter.impl;

import com.parsifal.cleanweather.domain.executor.Executor;
import com.parsifal.cleanweather.domain.executor.MainThread;
import com.parsifal.cleanweather.domain.interactor.base.BaseInteractor;
import com.parsifal.cleanweather.domain.interactor.callback.GetWeatherCallback;
import com.parsifal.cleanweather.domain.interactor.impl.GetWeatherInteractorImpl;
import com.parsifal.cleanweather.domain.repository.WeatherRepository;
import com.parsifal.cleanweather.presentation.presenter.base.AbstractPresenter;
import com.parsifal.cleanweather.presentation.presenter.base.MainPresenter;
import com.parsifal.cleanweather.presentation.ui.base.MainView;

/**
 * Created by yangming on 17-11-27.
 */
public class MainPresenterImpl extends AbstractPresenter implements MainPresenter, GetWeatherCallback {

    private MainView mView = null;

    private WeatherRepository mRepository = null;

    public MainPresenterImpl(Executor executor, MainThread mainThread,
                             MainView view, WeatherRepository repository) {
        super(executor, mainThread);
        this.mView = view;
        this.mRepository = repository;
    }

    @Override
    public void getWeather(String cityID) {
        BaseInteractor getWeatherInterpolator = new GetWeatherInteractorImpl(mExecutor,
                mMainThread, mRepository, cityID, this);
        getWeatherInterpolator.execute();
    }

    @Override
    public void onWeatherGet(String weather) {
        mView.onWeatherGet(weather);
    }

    @Override
    public void onWeatherError(String error) {
        mView.showError("Error : " + error);
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onError(String message) {

    }
}
