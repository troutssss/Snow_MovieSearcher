package com.example.moviesearcher;

import android.os.Bundle;

import com.example.moviesearcher.adaptor.MovieDataAdapter;
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

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MovieViewModel model;
    private MovieDataAdapter movieDataAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setActivity(this);

        //bind RecyclerView
        RecyclerView recyclerView = binding.rvMovieList;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

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

//        final Observer<List<Movie>> movieObserver = new Observer<List<Movie>>() {
//            @Override
//            public void onChanged(Movie movie) {
//                //UI update!
//            }
//        };

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


    private void searchMoive(){

    }

    public void onSearchButtonClicked(View v){
        Toast.makeText(this, "Search Btn Clicked", Toast.LENGTH_SHORT).show();


    }

}