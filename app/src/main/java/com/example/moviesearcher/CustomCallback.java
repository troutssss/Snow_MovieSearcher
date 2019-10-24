package com.example.moviesearcher;

import com.example.moviesearcher.db.model.Movie;

import java.util.ArrayList;

public interface CustomCallback {
    void callbackMethod(ArrayList<Movie> movieList);
}
