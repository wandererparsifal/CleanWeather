package com.parsifal.cleanweather.presentation.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.parsifal.cleanweather.R;
import com.parsifal.cleanweather.data.WeatherRepositoryImpl;
import com.parsifal.cleanweather.domain.executor.impl.ThreadExecutor;
import com.parsifal.cleanweather.presentation.presenter.base.MainPresenter;
import com.parsifal.cleanweather.presentation.presenter.impl.MainPresenterImpl;
import com.parsifal.cleanweather.presentation.ui.MainThreadImpl;
import com.parsifal.cleanweather.presentation.ui.base.MainView;

public class MainActivity extends AppCompatActivity implements MainView {

    private MainPresenter mPresenter = null;

    private TextView mTextView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new MainPresenterImpl(ThreadExecutor.getInstance(),
                MainThreadImpl.getInstance(),
                this, new WeatherRepositoryImpl(this));

        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.text);
        mPresenter.getWeather("001");
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError(String message) {
        mTextView.setText(message);
    }

    @Override
    public void onWeatherGet(String weather) {
        mTextView.setText(weather);
    }
}
