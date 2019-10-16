package com.example.moviesearcher.Util;

import com.example.moviesearcher.db.model.SearchMovie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MovieDataService {
    @GET("query/{movieName}")
    Call<SearchMovie> getMovies(@Path("movieName") String movieName);

}
