/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.sunshine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO (1) Create a field to store the weather display TextView
    TextView weatherDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);

        weatherDisplay = (TextView) findViewById(R.id.tv_weather_data);
        // TODO (2) Use findViewById to get a reference to the weather display TextView

        // TODO (3) Create an array of Strings that contain fake weather data
        String fakeData[]={"Monday 40 degrees","Tuesday -20 degrees","Wednesday -25 degrees","Thursday -20 degrees","Friday -25 degrees","Saturday -20 degrees","Sunday -25 degrees","Monday -20 degrees","Tuesday -25 degrees","Wednesday -20 degrees","Thursday -25 degrees"};
        // TODO (4) Append each String from the fake weather data array to the TextView
        for(int i=0;i<fakeData.length;i++){
            weatherDisplay.append(fakeData[i]+"\n\n\n");
        }
    }
}