package com.parsifal.cleanweather.data;

import android.content.Context;
import android.util.Log;

import com.parsifal.cleanweather.data.bean.Weather;
import com.parsifal.cleanweather.domain.repository.WeatherRepository;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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

        Interceptor commonParams = new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request originRequest = chain.request();
                Request request;
                HttpUrl httpUrl = originRequest.url().newBuilder()
                        .addQueryParameter("key", "3c3fbcb0cbb54ff4a3df670144b08e9b")
                        .build();
                request = originRequest.newBuilder().url(httpUrl).build();
                return chain.proceed(request);
            }
        };

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(commonParams)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://free-api.heweather.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        IGetRequest getRequest = retrofit.create(IGetRequest.class);
        Call<Weather> call = getRequest.getWeather(cityID);
        call.enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {
                Log.d("test", "response " + response.toString());
                Log.d("test", "string " + response.body().toString());
            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {
                Log.e("test", "onFailure");
            }
        });

        return weather;
    }
}
