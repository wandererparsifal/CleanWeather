package com.parsifal.cleanweather.presentation.presenter.impl;

import com.parsifal.cleanweather.domain.executor.Executor;
import com.parsifal.cleanweather.domain.executor.MainThread;
import com.parsifal.cleanweather.presentation.presenter.base.AbstractPresenter;
import com.parsifal.cleanweather.presentation.presenter.base.BasePresenter;
import com.parsifal.cleanweather.presentation.ui.base.MainView;

/**
 * Created by yangming on 17-11-27.
 */
public class MainPresenterImpl extends AbstractPresenter implements BasePresenter {

    private MainView mView = null;

    public MainPresenterImpl(Executor executor, MainThread mainThread, MainView view) {
        super(executor, mainThread);
        mView = view;
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
