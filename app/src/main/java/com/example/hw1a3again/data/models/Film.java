package com.example.hw1a3again.data.models;

import com.google.gson.annotations.SerializedName;

public class Film {
    @SerializedName("id")
    private String id;

    @SerializedName("title")
    private String title;
    @SerializedName("original_title")
    private String originalTitle;
    @SerializedName("description")
    private String description;
    @SerializedName("director")
    private String director;
    @SerializedName("producer")
    private String producer;

    @SerializedName("movie_banner")
    private String movieBanner;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getDescription() {
        return description;
    }

    public String getDirector() {
        return director;
    }

    public String getProducer() {
        return producer;
    }

    public String getMovieBanner() {
        return movieBanner;
    }
}
