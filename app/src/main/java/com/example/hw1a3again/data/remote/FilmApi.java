package com.example.hw1a3again.data.remote;

import com.example.hw1a3again.data.models.Film;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FilmApi {

    @GET("/films")
    Call<List<Film>> getFilms();
}
