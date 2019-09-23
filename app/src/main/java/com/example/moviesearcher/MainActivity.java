package com.example.moviesearcher;

import android.os.Bundle;

import com.example.moviesearcher.Util.RetrofitAPI;
import com.example.moviesearcher.databinding.ActivityMainBinding;
import com.example.moviesearcher.model.Movie;
import com.example.moviesearcher.model.SearchMovie;
import com.example.moviesearcher.viewmodel.MovieViewModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private MovieViewModel model;
    private Retrofit retrofit;
    private RetrofitAPI retrofitAPI;
    private Call<SearchMovie> searchMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setActivity(this);

        model = ViewModelProviders.of(this).get(MovieViewModel.class);

        final Observer<Movie> movieObserver = new Observer<Movie>() {
            @Override
            public void onChanged(Movie movie) {
                //UI update!
            }
        };

        model.getMovieList().observe(this, movieObserver);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void initRetrofit(){
        retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.baseUrl))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofitAPI = retrofit.create(RetrofitAPI.class);
    }

    private void searchMoive(){

    }

    public void onSearchButtonClicked(View v){
        Toast.makeText(this, "Search Btn Clicked", Toast.LENGTH_SHORT).show();
        searchMovie = retrofitAPI.getSearchMovie();
        searchMovie.enqueue();
    }

    private Callback<SearchMovie> retrofitCallback = new Callback<SearchMovie>() {
        @Override
        public void onResponse(Call<SearchMovie> call, Response<SearchMovie> response) {
            if(response.code() == 200){
                //성공
            }
            else{
                Toast.makeText(MainActivity.this, "다시 검색해주세요!", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onFailure(Call<SearchMovie> call, Throwable t) {

        }
    }
}
