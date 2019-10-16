package com.example.moviesearcher;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.MutableLiveData;

import com.example.moviesearcher.Util.RetrofitAPI;
import com.example.moviesearcher.Util.RetrofitClient;
import com.example.moviesearcher.db.MovieRoomDatabase;
import com.example.moviesearcher.db.dao.MovieDao;
import com.example.moviesearcher.db.model.Movie;
import com.example.moviesearcher.db.model.SearchMovie;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {
    private static final String TAG = "MovieRepository";
    private ArrayList<Movie> movieList = new ArrayList<>();
    private MutableLiveData<List<Movie>> mutableLiveData = new MutableLiveData<>();
    private MovieDao movieDao;

    public MovieRepository(Application application){
        MovieRoomDatabase db = MovieRoomDatabase.geMovieDatabase(application);
        movieDao = db.movieDao();
        //mutable vs livedata
        // mutableLiveData = movieDao.getAllMovies();
    }

    //from naver api
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

    public void insert(Movie movie){
        new insertAsyncTask(movieDao).execute(movie);
    }

    private static class insertAsyncTask extends AsyncTask<Movie, Void, Void>{
        private MovieDao asyncTaskDao;

        insertAsyncTask(MovieDao dao){
            asyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Movie... movies) {
            asyncTaskDao.insert(movies[0]);
            return null;
        }
    }
}
