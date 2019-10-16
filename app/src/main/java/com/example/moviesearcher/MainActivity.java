package com.example.moviesearcher;

import android.os.Bundle;

<<<<<<< HEAD
import com.example.moviesearcher.Util.MovieDataService;
=======
import com.example.moviesearcher.adaptor.MovieDataAdapter;
>>>>>>> 97201182f06a401f5fd0c0e420db681a12ca5312
import com.example.moviesearcher.databinding.ActivityMainBinding;
import com.example.moviesearcher.db.model.Movie;
import com.example.moviesearcher.viewmodel.MovieViewModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

<<<<<<< HEAD
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
=======
import java.util.ArrayList;
import java.util.List;
>>>>>>> 97201182f06a401f5fd0c0e420db681a12ca5312

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MovieViewModel model;
<<<<<<< HEAD
    private Retrofit retrofit;
    private MovieDataService movieDataService;
    private Call<SearchMovie> searchMovie;
=======
    private MovieDataAdapter movieDataAdapter;

>>>>>>> 97201182f06a401f5fd0c0e420db681a12ca5312

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

<<<<<<< HEAD
=======
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setActivity(this);

        //bind RecyclerView
        RecyclerView recyclerView = binding.rvMovieList;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

>>>>>>> 97201182f06a401f5fd0c0e420db681a12ca5312
        model = ViewModelProviders.of(this).get(MovieViewModel.class);
        movieDataAdapter = new MovieDataAdapter();
        recyclerView.setAdapter(movieDataAdapter);

        String searchMovie = binding.etMovieName.getText().toString();
        Toast.makeText(this, "Search Btn Clicked", Toast.LENGTH_SHORT).show();

        model.getAllMovie("asd").observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {
                movieDataAdapter.setMovieList((ArrayList<Movie>) movies);
            }
        });

<<<<<<< HEAD
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setActivity(this);
        binding.setMovieModel(model);
=======
//        final Observer<List<Movie>> movieObserver = new Observer<List<Movie>>() {
//            @Override
//            public void onChanged(Movie movie) {
//                //UI update!
//            }
//        };
>>>>>>> 97201182f06a401f5fd0c0e420db681a12ca5312

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

<<<<<<< HEAD
=======

>>>>>>> 97201182f06a401f5fd0c0e420db681a12ca5312
    private void searchMoive(){

    }

    public void onSearchButtonClicked(View v){
        Toast.makeText(this, "Search Btn Clicked", Toast.LENGTH_SHORT).show();
<<<<<<< HEAD
        //searchMovie = movieDataService.getMovies();
        //searchMovie.enqueue();
    }
=======
>>>>>>> 97201182f06a401f5fd0c0e420db681a12ca5312


<<<<<<< HEAD
        @Override
        public void onFailure(Call<SearchMovie> call, Throwable t) {

        }
    };
=======
    }

>>>>>>> 97201182f06a401f5fd0c0e420db681a12ca5312
}
