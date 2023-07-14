package com.example.movieapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyApiCall {

    @GET("v3/494b5353-1825-477c-8893-66baec35ab6b")
    Call<JSONResponse> getMovies();

}
