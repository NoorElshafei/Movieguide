package com.example.elshafie.noorfinal;

/**
 * Created by Elshafie on 9/5/2017.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Locale;



public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder> {

    private List<Movie> movies;
    private OnItemClickListener onItemClickListener;

    public MoviesAdapter() {

    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public MoviesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutHolderView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.list_item_movie,
                parent,
                false);
        return new MoviesViewHolder(layoutHolderView);
    }

    @Override
    public void onBindViewHolder(MoviesViewHolder holder, int position) {
        holder.setContent(movies.get(position));
    }

    @Override
    public int getItemCount() {
        return movies != null ? movies.size() : 0;
    }

    class MoviesViewHolder extends RecyclerView.ViewHolder{

        LinearLayout mRootLayout;


        ImageView posterImageView;
        ImageView posterImageView2;


        public MoviesViewHolder(View itemView) {
            super(itemView);
            mRootLayout = (LinearLayout) itemView.findViewById(R.id.item_movie);


            posterImageView = (ImageView) itemView.findViewById(R.id.movie_poster_image_view);
        }

        public void setContent(final Movie movie) {
            Picasso.with(posterImageView.getContext()).load(movie.getImageUrl()).into(posterImageView);
            mRootLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClick(movie);
                    }
                }
            });
        }

    }

    public interface OnItemClickListener {
        void onItemClick(Movie movie);
    }
}

