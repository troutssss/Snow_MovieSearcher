package com.example.moviesearcher.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.moviesearcher.db.dao.MovieDao;
import com.example.moviesearcher.db.model.Movie;

@Database(entities = {Movie.class}, version = 1, exportSchema = false)
public abstract class MovieRoomDatabase extends RoomDatabase {
    public abstract MovieDao movieDao();
    private static MovieRoomDatabase INSTANCE;

    public static MovieRoomDatabase geMovieDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (MovieRoomDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MovieRoomDatabase.class, "movie_database")
                            .fallbackToDestructiveMigration()
                            .build();

                }
            }
        }

        return INSTANCE;
    }
}
