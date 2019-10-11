package com.example.moviesearcher;

import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.example.moviesearcher.Util.RetrofitAPI;
import com.example.moviesearcher.Util.RetrofitClient;
import com.example.moviesearcher.model.Movie;
import com.example.moviesearcher.model.SearchMovie;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {
    private static final String TAG = "MovieRepository";
    private ArrayList<Movie> movieList = new ArrayList<>();
    private MutableLiveData<List<Movie>> mutableLiveData = new MutableLiveData<>();

    public MovieRepository(){}

    public MutableLiveData<List<Movie>> getMutableLiveData(String movieName){
        final RetrofitAPI retrofit = RetrofitClient.getRetorofitService();


        Call<SearchMovie> call = retrofit.getSearchMovie(movieName);
        call.enqueue(new Callback<SearchMovie>() {
            @Override
            public void onResponse(Call<SearchMovie> call, Response<SearchMovie> response) {
                if(response.code() == 200){
                    //성공
                    SearchMovie searchMovie = response.body();
                    movieList = (ArrayList<Movie>)searchMovie.getItems();
                    mutableLiveData.setValue(movieList);
                }
                else{
                    //Toast.makeText(MovieRepository.this, "다시 검색해주세요!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SearchMovie> call, Throwable t) {

            }
        });

        return mutableLiveData;
    }

}
