package com.example.gvg.myweather_fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private List<ClassCity> cities;
    private WeatherListListener mainActivity;
    private CheckBox pressureBox;
    private CheckBox moonBox;
    private CheckBox dayBox;
    private CheckBox weekBox;

    public MainFragment() {
        // Required empty public constructor
    }

    interface WeatherListListener {
        void onListItemClick(int id, boolean[] checkBoxes);
    }

    @Override
    public void onAttach(Context context) {
        mainActivity = (WeatherListListener) context;
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View mainView = inflater.inflate(R.layout.fragment_main, container, false);

        pressureBox = mainView.findViewById(R.id.checkbox_pressure);
        moonBox = mainView.findViewById(R.id.checkbox_moon);
        dayBox = mainView.findViewById(R.id.checkbox_day);
        weekBox = mainView.findViewById(R.id.checkbox_week);

        FillCityList();

        RecyclerView rView = mainView.findViewById(R.id.recucler_view);
        LinearLayoutManager llManager = new LinearLayoutManager(getActivity());
        rView.setLayoutManager(llManager);
        rView.setAdapter(new MyDataAdapter());

        return mainView;
    }

    private void FillCityList() {
        cities = new ArrayList<>();
        String[] citiesArray = getResources().getStringArray(R.array.city_array);
        if (citiesArray.length != 0) {
            for (int i = 0; i < citiesArray.length; i++) {
                ClassCity newCity = new ClassCity(citiesArray[i]);
                cities.add(newCity);
            }
        }
    }

    private void showWeatherScreen(int layoutPosition, boolean[] checkBoxes) {
        mainActivity.onListItemClick(layoutPosition, checkBoxes);
    }

    private class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        final TextView nameView;

        public MyViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.city_list, parent, false));
            itemView.setOnClickListener(this);
            nameView = itemView.findViewById(R.id.city_element);
        }

        void bind(int position) {
            String category = cities.get(position).getName();
            nameView.setText(category);
        }

        @Override
        public void onClick(View v) {
            boolean[] checkBoxes = new boolean[]{pressureBox.isChecked(), moonBox.isChecked(), dayBox.isChecked(), weekBox.isChecked()};
            showWeatherScreen(this.getLayoutPosition(), checkBoxes);
//                Intent intent = new Intent(v.getContext(), WeatherActivity.class);
//                startActivityForResult(intent, RETURN_NUMBER);
        }
    }

    private class MyDataAdapter extends RecyclerView.Adapter<MyViewHolder> {

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            return new MyViewHolder(inflater, parent);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.bind(position);
        }

        @Override
        public int getItemCount() {
            return cities.size();
        }
    }
}
