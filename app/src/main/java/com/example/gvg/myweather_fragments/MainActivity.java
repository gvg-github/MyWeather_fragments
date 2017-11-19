package com.example.gvg.myweather_fragments;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainFragment.WeatherListListener {

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
    public void onListItemClick(int id) {

        Intent intent = new Intent(this, WeatherActivity.class);
        intent.putExtra(WeatherActivity.CITY_TEXT, id);
        startActivity(intent);

//        View fragmentContainer = findViewById(R.id.fragment_container);
//        if (fragmentContainer != null) {
//            DetailFragment detailFragment = new DetailFragment();
//            detailFragment.setCity(id);
//            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//            transaction.replace(R.id.fragment_container, detailFragment);
//            transaction.addToBackStack(null);
//            transaction.commit();
//        } else {
//            Intent intent = new Intent(this, WeatherActivity.class);
//            intent.putExtra(WeatherActivity.CITY_TEXT, id);
//            startActivity(intent);
//        }
    }
}
