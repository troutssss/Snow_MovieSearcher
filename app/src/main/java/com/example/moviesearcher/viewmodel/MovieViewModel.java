package com.example.moviesearcher.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.moviesearcher.MovieRepository;
import com.example.moviesearcher.model.Movie;

import java.util.List;

public class MovieViewModel extends ViewModel {
    public MutableLiveData<Movie> movieList;
    private MovieRepository movieRepository;

    public MovieViewModel(){
        movieRepository = new MovieRepository();
    }

    public LiveData<List<Movie>> getAllMovie(String movieName){
        return movieRepository.getMutableLiveData(movieName);
    }

//    public MutableLiveData<Movie> getMovieList(){
//        if(movieList == null){
//            movieList = new MutableLiveData<Movie>();
//        }
//
//        return movieList;
//    }
}
