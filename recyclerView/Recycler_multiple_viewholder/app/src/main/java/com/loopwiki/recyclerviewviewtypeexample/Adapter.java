package com.loopwiki.recyclerviewviewtypeexample;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter {
    private static final int MOVIE_ITEM = 0;
    private static final int AD_ITEM = 1;
    List<ListItem> items;

    public void setItems(List<ListItem> items)
    {
        this.items = items;
    }


    @Override
    public int getItemViewType(int position) {
        return items.get(position) instanceof Movie ? MOVIE_ITEM : AD_ITEM;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == MOVIE_ITEM) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
            return new MovieHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ad_item, parent, false);
            return new AdHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ListItem listItem = items.get(position);
        if (holder instanceof MovieHolder) {
            MovieHolder movieHolder = (MovieHolder) holder;
            Movie movie = (Movie) listItem;
            movieHolder.textViewMovieName.setText(movie.getName());
            movieHolder.textViewMovieYear.setText(movie.getYear());
            Drawable drawable = movieHolder.itemView.getContext().getResources().getDrawable(movie.getImage());
            movieHolder.imageViewMovie.setImageDrawable(drawable);
        } else {
            AdHolder adHolder = (AdHolder) holder;
            Ad ad = (Ad) listItem;
            adHolder.textViewAdText.setText(ad.getText());
        }

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    private class MovieHolder extends RecyclerView.ViewHolder {
        ImageView imageViewMovie;
        TextView textViewMovieName;
        TextView textViewMovieYear;

        public MovieHolder(@NonNull View itemView) {
            super(itemView);
            imageViewMovie = itemView.findViewById(R.id.imageViewMovie);
            textViewMovieName = itemView.findViewById(R.id.textViewMovieName);
            textViewMovieYear = itemView.findViewById(R.id.textViewMovieYear);
        }
    }

    private class AdHolder extends RecyclerView.ViewHolder {
        TextView textViewAdText;

        public AdHolder(@NonNull View itemView) {
            super(itemView);
            textViewAdText = itemView.findViewById(R.id.textViewAdText);
        }
    }
}
