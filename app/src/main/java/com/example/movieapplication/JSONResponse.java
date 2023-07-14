package com.example.movieapplication;


import com.google.gson.annotations.SerializedName;

public class JSONResponse {
    @SerializedName("cinemax")
    private MovieModel[] moviesArray;

    public MovieModel[] getMoviesArray() {
        return moviesArray;
    }

    public void setMoviesArray(MovieModel[] moviesArray) {
        this.moviesArray = moviesArray;
    }
}
