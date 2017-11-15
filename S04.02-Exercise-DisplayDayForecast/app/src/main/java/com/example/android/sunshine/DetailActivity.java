package com.example.android.sunshine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private static final String FORECAST_SHARE_HASHTAG = " #SunshineApp";
    TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        tvDisplay = (TextView) findViewById(R.id.tv_display);

        // TODO (2) Display the weather forecast that was passed from MainActivity
        Intent intentReceived=getIntent();
        if(intentReceived.hasExtra(Intent.EXTRA_TEXT)){
            String textToShow = intentReceived.getStringExtra(Intent.EXTRA_TEXT);
            tvDisplay.setText(textToShow);
        }
    }
}