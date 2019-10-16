package com.example.moviesearcher.Util;

<<<<<<< HEAD
=======
import com.example.moviesearcher.R;

>>>>>>> 97201182f06a401f5fd0c0e420db681a12ca5312
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit;
    private static final String BASE_URL = "https://openapi.naver.com/v1/search/movie.json";

<<<<<<< HEAD
    public MovieDataService initRetrofit(){
=======
    public static RetrofitAPI getRetorofitService(){
>>>>>>> 97201182f06a401f5fd0c0e420db681a12ca5312
        if(retrofit == null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
<<<<<<< HEAD
        }

        return retrofit.create(MovieDataService.class);
=======

        }

        return retrofit.create(RetrofitAPI.class);
>>>>>>> 97201182f06a401f5fd0c0e420db681a12ca5312
    }
}
