package com.example.android.sunshine;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by baeza on 14.11.2017.
 */

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder> {

    private String[] mWeatherData;
    class ForecastAdapterViewHolder extends RecyclerView.ViewHolder{
        public final TextView mWeatherTextView;

        public ForecastAdapterViewHolder(View view){
            super(view);
            mWeatherTextView = (TextView) view.findViewById(R.id.tv_weather_data);
        }
    }

    @Override
    public ForecastAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
        Context context = viewGroup.getContext();
        View view= LayoutInflater.from(context).inflate(R.layout.forecast_list_item, viewGroup, false);
        ForecastAdapterViewHolder forecastAdapterViewHolder =new ForecastAdapterViewHolder(view);
        return  forecastAdapterViewHolder;
    }

    @Override
    public void onBindViewHolder(ForecastAdapterViewHolder holder, int position) {
        String weatherForThisDay= mWeatherData[position];
        holder.mWeatherTextView.setText(weatherForThisDay);
    }


    @Override
    public int getItemCount(){
        if(mWeatherData==null){
            return 0;
        }else{
         return mWeatherData.length;
        }
    }

    public void setWeatherData(String weatherData[]){
        mWeatherData=weatherData;
        notifyDataSetChanged();
    }

}
