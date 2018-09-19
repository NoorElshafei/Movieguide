package com.example.elshafie.noorfinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.Button;
import com.squareup.picasso.Picasso;
import android.view.View;

import java.util.Locale;

public class DetailsActivity extends AppCompatActivity {

    private TextView titleTextView;
    private TextView titleTextView1;
    private TextView titleTextView2;
    private TextView titleTextView3;
    private ImageView titleTextView4;
    private ImageView titleTextView5;
    private Movie movie;
    private Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        movie = (Movie) getIntent().getExtras().getSerializable("Movie");
        titleTextView = (TextView) findViewById(R.id.textView);
        titleTextView.setText(movie.getDate());

        titleTextView1 = (TextView) findViewById(R.id.textView2);
        titleTextView1.setText(String.format(Locale.getDefault(), "%.2f", movie.getRate()));

        titleTextView2 = (TextView) findViewById(R.id.textView3);
        titleTextView2.setText(String.format(Locale.getDefault(), "%d", movie.getNumOfVoters()));

        titleTextView3 = (TextView) findViewById(R.id.textView4);
        titleTextView3.setText(movie.getDescription());

        titleTextView4 = (ImageView) findViewById(R.id.imageView2);

        titleTextView5 = (ImageView) findViewById(R.id.imageView3);


        Picasso.with(titleTextView4.getContext()).load(movie.getBackDropUrl()).into(titleTextView4);
        Picasso.with(titleTextView5.getContext()).load(movie.getImageUrl()).into(titleTextView5);


        btn1= (Button) findViewById(R.id.button);

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View b) {
                btn1.setBackgroundColor(Color.YELLOW);
                btn1.setText("done");
                // You are explicitly assiging the OnClickListener for this button
                // Thus, you don't need to check if b is a button
            }

        };
        btn1.setOnClickListener(clickListener);


    }
}
