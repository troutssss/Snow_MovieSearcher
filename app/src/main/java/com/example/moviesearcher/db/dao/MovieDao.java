package com.example.moviesearcher.db.dao;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.moviesearcher.db.model.Movie;

import java.util.List;

@Dao
public interface MovieDao {
    @Insert
    void insert(Movie movie);

    @Query("DELETE FROM movie")
    void deleteAll();

    @Query("SELECT * from movie")
    LiveData<List<Movie>> getAllMovies();
}
