package com.example.moviesearcher.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.moviesearcher.CustomCallback;
import com.example.moviesearcher.MovieRepository;
import com.example.moviesearcher.db.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieViewModel extends AndroidViewModel implements CustomCallback {
    public MutableLiveData<Movie> movieList;
    private MovieRepository movieRepository;

    public MovieViewModel(Application application){
        super(application);
        movieRepository = new MovieRepository(application, this);
        //movieList = movieRepository.getMutableLiveData();
    }

    public LiveData<List<Movie>> getAllMovie(){
        return movieRepository.getMutableLiveData();
    }

    public void searchMovieList(String movieTitle){
        movieRepository.searchMovieList(movieTitle);
    }


    @Override
    public void callbackMethod(ArrayList<Movie> movieList) {
        movieRepository.getMutableLiveData().setValue(movieList);
    }
}
