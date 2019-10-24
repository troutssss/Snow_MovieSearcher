package com.example.moviesearcher;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.example.moviesearcher.Util.RetrofitAPI;
import com.example.moviesearcher.Util.RetrofitClient;
import com.example.moviesearcher.db.MovieRoomDatabase;
import com.example.moviesearcher.db.dao.MovieDao;
import com.example.moviesearcher.db.model.Movie;
import com.example.moviesearcher.db.model.SearchMovie;
import com.google.gson.Gson;

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
    private Application application;
    private CustomCallback callback;

    public MovieRepository(Application application, CustomCallback callback){
        this.application = application;
        this.callback = callback;
        MovieRoomDatabase db = MovieRoomDatabase.geMovieDatabase(application);
        movieDao = db.movieDao();
        //mutable vs livedata
        // mutableLiveData = movieDao.getAllMovies();
    }

    public MutableLiveData<List<Movie>> getMutableLiveData(){
        return mutableLiveData;
    }


    //from naver api
    public void searchMovieList(String movieName){
        final RetrofitAPI retrofit = RetrofitClient.getRetrofitService();

        Call<SearchMovie> call = retrofit.getSearchMovie(movieName);
        call.enqueue(new Callback<SearchMovie>() {
            @Override
            public void onResponse(Call<SearchMovie> call, Response<SearchMovie> response) {
//                Log.v("RETROFIT Header", response.headers().toString());
//                Log.v("RETROFIT Response", response.raw().toString());
                if(response.code() == 200){
                    //성공
                    Log.v("API success", "response.body : "+ new Gson().toJson(response.body()));
                    SearchMovie searchMovie = response.body();
                    movieList = (ArrayList<Movie>)searchMovie.getItems();
                    Log.v("API success", "movieList(items) : "+ new Gson().toJson(movieList));
                    callback.callbackMethod(movieList);
                    //mutableLiveData.setValue(movieList);
                }
                else{
                    Toast.makeText(application, "API fail code : "+response.code() , Toast.LENGTH_SHORT).show();
                    Log.v("API fail code: ", "HTTPcode : " + response.code() +  ", headers: "+response.headers().toString());
                    Log.v("API fail response.raw:", response.raw().toString());

                }
            }

            @Override
            public void onFailure(Call<SearchMovie> call, Throwable t) {
                Toast.makeText(application, "Search is failed : "+ call, Toast.LENGTH_SHORT).show();
            }
        });

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
