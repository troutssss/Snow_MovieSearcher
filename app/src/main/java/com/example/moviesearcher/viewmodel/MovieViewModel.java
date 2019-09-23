package com.example.moviesearcher.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.moviesearcher.model.Movie;

public class MovieViewModel extends ViewModel {
    public MutableLiveData<Movie> movieList;

    public MutableLiveData<Movie> getMovieList(){
        if(movieList == null){
            movieList = new MutableLiveData<Movie>();
        }

        return movieList;
    }
}
