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
    private String[] temperatureArray;
    private TextView textTemperature;
    private TextView textWind;
    private String[] windArray;

    public static final String CHECKBOX_TEXT = "checkbox_text";

    private StringBuilder additionalText;

    public WeatherFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View wView = inflater.inflate(R.layout.fragment_weather, container, false);

        textCity = (TextView) wView.findViewById(R.id.cityFragment_text);
        textTemperature = (TextView) wView.findViewById(R.id.temperature_text);
        textWind = (TextView) wView.findViewById(R.id.wind_text);
        text = (TextView) wView.findViewById(R.id.weather_text);

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
            temperatureArray = getResources().getStringArray(R.array.temperature_array);
            textTemperature.setText(temperatureArray[idWeather]);
            windArray = getResources().getStringArray(R.array.wind_array);
            textWind.setText(windArray[idWeather]);
            boolean[] checkBoxes = intent.getBooleanArrayExtra(WeatherActivity.CHECKBOX_STATUS);
            if (checkBoxes.length != 0) {
                additionalText = new StringBuilder();
                if (checkBoxes[0]) {
                    String[] pressureArray = getResources().getStringArray(R.array.pressure_array);
                    additionalText.append(pressureArray[idWeather]);

                }
                if (checkBoxes[1]) {
                    if (additionalText.length() > 0) {
                        additionalText.append(String.format("%n"));
                        String newText = ", moon - new";
                        additionalText.append(newText);
                    } else {
                        additionalText.append("Moon - new");
                    }

                }
                if (checkBoxes[2]) {
                    if (additionalText.length() > 0) {
                        additionalText.append(String.format("%n"));
                        String newText = ", the forecast for the day - " + text.getText();
                        additionalText.append(newText);
                    } else {
                        additionalText.append("The forecast for the day - " + text.getText());
                    }
                }
                if (checkBoxes[3]) {
                    if (additionalText.length() > 0) {
                        additionalText.append(String.format("%n"));
                        String newText = ", the forecast for the week - " + text.getText();
                        additionalText.append(newText);
                    } else {
                        additionalText.append("The forecast for the week - " + text.getText());
                    }
                }
            }
        }

        FragmentManager fragmentManager = getChildFragmentManager();
        AdditionalFragment additionalFragment = (AdditionalFragment) fragmentManager.findFragmentById(R.id.add_fragment);
        if (additionalFragment == null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            additionalFragment = new AdditionalFragment();
            fragmentTransaction.replace(R.id.add_fragment, additionalFragment);
            if (additionalText != null && additionalText.length() > 0) {
                additionalFragment.setAddText(additionalText.toString());
            }
            fragmentTransaction.commit();
        }
        return wView;
    }
}
