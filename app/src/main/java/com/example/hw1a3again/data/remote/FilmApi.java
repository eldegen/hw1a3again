package com.example.hw1a3again.data.remote;

import com.example.hw1a3again.data.models.Film;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FilmApi {

    @GET("/films")
    Call<List<Film>> getFilms();

    @GET("/films/{id}")
    Call<Film> getFilmById(@Path("id") String id);
}
