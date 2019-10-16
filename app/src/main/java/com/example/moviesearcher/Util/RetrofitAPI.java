package com.example.moviesearcher.Util;

import com.example.moviesearcher.db.model.SearchMovie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitAPI {
    @GET("query/{movieName}")
    Call<SearchMovie> getSearchMovie(@Path("movieName") String movieName);

}