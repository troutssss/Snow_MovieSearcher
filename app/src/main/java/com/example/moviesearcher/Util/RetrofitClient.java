package com.example.moviesearcher.Util;

import com.example.moviesearcher.R;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit;
    private static final String BASE_URL = "https://openapi.naver.com/v1/search/movie.json";

    public static RetrofitAPI getRetorofitService(){
        if(retrofit == null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }

        return retrofit.create(RetrofitAPI.class);
    }
}