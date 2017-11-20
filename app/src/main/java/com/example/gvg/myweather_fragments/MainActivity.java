package com.example.gvg.myweather_fragments;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements MainFragment.WeatherListListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainFragment mainFragment = new MainFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.main_fragment, mainFragment);
        transaction.commit();
    }

    @Override
    public void onListItemClick(int id, boolean[] checkBoxes) {

        Intent intent = new Intent(this, WeatherActivity.class);
        intent.putExtra(WeatherActivity.CITY_TEXT, id);
        intent.putExtra(WeatherActivity.CHECKBOX_STATUS, checkBoxes);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        Log.i(TAG, "onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.i(TAG, "onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
//        SharedPreferences.Editor editor = myPreferences.edit();
//        editor.putBoolean(CHECKBOX_PRESSURE, boxPressure.isChecked());
//        editor.putBoolean(CHECKBOX_MOONPHASE, boxMoon.isChecked());
//
//        editor.putBoolean(CHECKBOX_TOMORROW, boxTomorrow.isChecked());
//        editor.putBoolean(CHECKBOX_WEEK, boxWeek.isChecked());
//
//        editor.apply();
        Log.i(TAG, "onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i(TAG, "onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG, "onDestroy");
        super.onDestroy();
    }
}
