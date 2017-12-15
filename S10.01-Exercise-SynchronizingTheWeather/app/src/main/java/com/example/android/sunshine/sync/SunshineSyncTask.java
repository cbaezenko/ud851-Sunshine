package com.example.android.sunshine.sync;

//  TODO (1) Create a class called SunshineSyncTask
//  TODO (2) Within SunshineSyncTask, create a synchronized public static void method called syncWeather
//      TODO (3) Within syncWeather, fetch new weather data
//      TODO (4) If we have valid results, delete the old data and insert the new

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;

import com.example.android.sunshine.data.WeatherContract;
import com.example.android.sunshine.utilities.NetworkUtils;
import com.example.android.sunshine.utilities.OpenWeatherJsonUtils;

import java.net.URL;

public class SunshineSyncTask{

    /* Performs the network request for updated weather, parses the JSON from that request, and
     * inserts the new weather information into our ContentProvider. Will notify the user that new
      * weather had been loaded if the user hasn't been notified of the weather within the last day
      * AND they haven't disabled notifications in the preferences screen*/

    public static void syncWeather(Context context){

        try{

            /*
        * The getUrl method will return the URL that we need to get the forecast JSON for the
        * weather. It will decide whether to create a URL based off of latitude and longitude or
        * off of a simple location as a String*/
        URL weatherRequestUrl = NetworkUtils.getUrl(context);

        /* Uses the URL to retrieve the JSON*/
        String jsonWeatherResponse = NetworkUtils.getResponseFromHttpUrl(weatherRequestUrl);

            ContentValues[] weatherValues = OpenWeatherJsonUtils.getWeatherContentValuesFromJson(context, jsonWeatherResponse);
/**
 * In cases where our JSON contained an error code, getWeatherContentFromJson
 * would have returned null. We need to check for those cases here to prevent any
 * NullPointerExceptions being thrown. We also have no reason to insert fresh data if there isn't any
 * to insert.
 */

            if (weatherValues != null && weatherValues.length != 0){
                ContentResolver sunshineContentResolver = context.getContentResolver();
        //Delete old weather data because we don't need to keep multiple days' data
                sunshineContentResolver.delete(WeatherContract.WeatherEntry.CONTENT_URI,
                        null,
                        null);

                sunshineContentResolver.bulkInsert(
                        WeatherContract.WeatherEntry.CONTENT_URI,
                        weatherValues);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}