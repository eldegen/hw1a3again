package com.example.hw1a3again;

import android.app.Application;

import com.example.hw1a3again.data.remote.FilmApi;
import com.example.hw1a3again.data.remote.RetrofitClient;

public class App extends Application {
    private RetrofitClient retrofitClient;
    public static FilmApi api;

    @Override
    public void onCreate() {
        super.onCreate();
        retrofitClient = new RetrofitClient();
        api = retrofitClient.provideFilmApi();
    }
}
