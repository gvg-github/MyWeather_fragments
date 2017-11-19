package com.example.gvg.myweather_fragments;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class WeatherActivity extends AppCompatActivity {

    public static final String CITY_TEXT = "city_text";
    private String[] cityArray;
    private TextView textCity;
//    private TextView text;
//    private String[] weatherArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
//        textCity = (TextView) findViewById(R.id.activityCity_text);
//////        text = (TextView) findViewById(R.id.weather_text);
//        int id = getIntent().getIntExtra(CITY_TEXT, 0);
//        cityArray = getResources().getStringArray(R.array.city_array);
//        textCity.setText(cityArray[id]);

//        int id = getIntent().getIntExtra(CITY_TEXT, 0);
//        Bundle selectedId = new Bundle();
//        selectedId.putInt(CITY_TEXT, id);
        WeatherFragment weatherFragment = new WeatherFragment();
//        weatherFragment.setArguments(selectedId);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.weatherFragment_container, weatherFragment);
        transaction.commit();
//        int id = getIntent().getIntExtra(CITY_TEXT, 0);
//        weatherFragment.setCity(id);
    }

//    public void setCity(int id){
//        cityArray = getResources().getStringArray(R.array.city_array);
//        textCity.setText(cityArray[id]);
//
//        weatherArray = getResources().getStringArray(R.array.weather_array);
//        int idWeather = (int) (Math.random() * weatherArray.length);
//        text.setText(weatherArray[idWeather]);
//    }
}
