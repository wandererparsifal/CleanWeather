package com.parsifal.cleanweather.presentation.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.parsifal.cleanweather.R;
import com.parsifal.cleanweather.presentation.ui.base.MainView;

public class MainActivity extends AppCompatActivity implements MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError(String message) {

    }
}
