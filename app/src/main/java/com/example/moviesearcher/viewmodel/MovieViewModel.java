package com.example.moviesearcher.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.moviesearcher.MovieRepository;
import com.example.moviesearcher.db.model.Movie;

import java.util.List;

public class MovieViewModel extends AndroidViewModel {
    public MutableLiveData<Movie> movieList;
    private MovieRepository movieRepository;

    public MovieViewModel(Application application){
        super(application);
        movieRepository = new MovieRepository(application);
        //movieList = movieRepository.getMutableLiveData();
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
