package com.example.movieapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Movie;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView responseCode;
    RecyclerView recyclerView;
    List<MovieModel> movieList;
    MyApiCall myApiCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        responseCode = findViewById(R.id.txtResponse);
        recyclerView = findViewById(R.id.recyclerView);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://run.mocky.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        myApiCall = retrofit.create(MyApiCall.class);


        getMovies();
    }

    private void getMovies() {

        Call<JSONResponse> call = myApiCall.getMovies();
        call.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {
                if (!response.isSuccessful()){
                    responseCode.setText("Code: " + response.code());
                    return;
                }

                JSONResponse jsonResponse = response.body();
                responseCode.setText("Code: " + response.code());
                movieList = new ArrayList<>(Arrays.asList(jsonResponse.getMoviesArray()));

                PutDataIntoRecyclerView(movieList);
            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {

            }
        });

    }

    private void PutDataIntoRecyclerView(List<MovieModel> movieList) {
        MyAdapter myAdapter = new MyAdapter(this, movieList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);
    }
}

