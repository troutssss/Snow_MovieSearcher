package com.example.moviesearcher.adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviesearcher.R;
import com.example.moviesearcher.databinding.ItemMovieBinding;
import com.example.moviesearcher.db.model.Movie;

import java.util.ArrayList;

public class MovieDataAdapter extends RecyclerView.Adapter<MovieDataAdapter.MovieViewHolder> {

    private ArrayList<Movie> movieList;
    private MovieDataAdaptorListener listener;

    public MovieDataAdapter(MovieDataAdaptorListener listener){
        this.listener = listener;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemMovieBinding itemMovieBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.item_movie, parent, false);
        return new MovieViewHolder(itemMovieBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, final int position) {
        Movie currentMovie = movieList.get((position));
        holder.itemMovieBinding.setMovie(currentMovie);
        holder.itemMovieBinding.cvMovieItem.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(listener != null){
                    listener.onItemClicked(movieList.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if(movieList != null){
            return movieList.size();
        }
        else{
            return 0;
        }
    }

    public void setMovieList(ArrayList<Movie> movieList){
        this.movieList = movieList;
        notifyDataSetChanged();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder{
        private ItemMovieBinding itemMovieBinding;

        public MovieViewHolder(@NonNull ItemMovieBinding itemMovieBinding) {
            super(itemMovieBinding.getRoot());

            this.itemMovieBinding = itemMovieBinding;

        }
    }

    public interface MovieDataAdaptorListener{
        void onItemClicked(Movie movie);
    }
}

