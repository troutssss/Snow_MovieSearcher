package com.example.moviesearcher.Util;

import com.example.moviesearcher.db.model.SearchMovie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitAPI {
    @Headers({
            "X-Naver-Client-Id:sqOgulja5DVH34EJmeL7",
            "X-Naver-Client-Secret:vMzFd2QCXt",
            "Host: openapi.naver.com",
            "User-Agent: curl/7.49.1"
    })
    @GET("search/movie.json")
    Call<SearchMovie> getSearchMovie(
            @Query("query") String movieName);

}
