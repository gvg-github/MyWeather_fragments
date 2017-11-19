package com.example.gvg.myweather_fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class WeatherFragment extends Fragment {


    private String[] cityArray;
    private TextView textCity;
    private TextView text;
    private String[] weatherArray;

    public WeatherFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View wView = inflater.inflate(R.layout.fragment_weather, container, false);

        textCity = (TextView) wView.findViewById(R.id.cityFragment_text);
        text =  (TextView) wView.findViewById(R.id.weather_text);

        Button button = (Button) wView.findViewById(R.id.button_sendMessage);
////        button.setOnClickListener(new WeatherActivity.MyOnClickListener());

        Intent intent = getActivity().getIntent();
        if (intent.getExtras() != null) {
            int id = intent.getIntExtra(WeatherActivity.CITY_TEXT, 0);
            cityArray = getResources().getStringArray(R.array.city_array);
            textCity.setText(cityArray[id]);
            weatherArray = getResources().getStringArray(R.array.weather_array);
            int idWeather = (int) (Math.random() * weatherArray.length);
            text.setText(weatherArray[idWeather]);
        }
////            cityArray = getResources().getStringArray(R.array.city_array);
////            textCity.setText(cityArray[id]);
////
////            weatherArray = getResources().getStringArray(R.array.weather_array);
////            int idWeather = (int) (Math.random() * weatherArray.length);
////            text.setText(weatherArray[idWeather]);
////        }

        FragmentManager fragmentManager = getChildFragmentManager();
        AdditionalFragment additionalFragment = (AdditionalFragment) fragmentManager.findFragmentById(R.id.add_fragment);
        if (additionalFragment == null){
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            additionalFragment = new AdditionalFragment();
            fragmentTransaction.replace(R.id.add_fragment, additionalFragment);
            fragmentTransaction.commit();
        }

        return wView;
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
