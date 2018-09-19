package com.example.elshafie.noorfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.widget.GridView;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView moviesRecyclerView;

    private MoviesAdapter moviesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        moviesRecyclerView = (RecyclerView) findViewById(R.id.movies_recycler_view);

        moviesRecyclerView.setItemAnimator(new DefaultItemAnimator());
        moviesRecyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this,3));
        moviesAdapter = new MoviesAdapter();
        moviesAdapter.setOnItemClickListener(new MoviesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Movie movie) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("Movie", movie);
                startActivity(intent);
            }
        });
        moviesRecyclerView.setAdapter(moviesAdapter);



        MoviesGetterTask moviesGetterTask = new MoviesGetterTask() {
            @Override
            protected void onPostExecute(List<Movie> movies) {
                moviesAdapter.setMovies(movies);
            }
        };
        moviesGetterTask.execute();

    }
}
