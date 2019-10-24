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

public class MainActivity extends AppCompatActivity implements MovieDataAdapter.MovieDataAdaptorListener {

    private ActivityMainBinding binding;
    private MovieViewModel model;
    private MovieDataAdapter movieDataAdapter;
    public String movieTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setActivity(this);
        binding.setMovieTitle(movieTitle);

        //bind RecyclerView
        RecyclerView recyclerView = binding.rvMovieList;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        model = ViewModelProviders.of(this).get(MovieViewModel.class);
        movieDataAdapter = new MovieDataAdapter(this);
        recyclerView.setAdapter(movieDataAdapter);

        model.getAllMovie().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {
                movieDataAdapter.setMovieList((ArrayList<Movie>) movies);
            }
        });

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

    public void onSearchButtonClicked(View v){
        Toast.makeText(this, "searchTitle : "+movieTitle, Toast.LENGTH_SHORT).show();
        model.searchMovieList(movieTitle);
    }

    @Override
    public void onItemClicked(Movie movie) {
        Toast.makeText(this, "title : "+movie.getTitle() + ",link : "+movie.getLink(), Toast.LENGTH_SHORT).show();
    }
}
