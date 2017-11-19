package com.example.gvg.myweather_fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private List<ClassCity> cities;
    private WeatherListListener mainActivity;

    public MainFragment() {
        // Required empty public constructor
    }

    interface WeatherListListener{
        void onListItemClick(int id);
    }


    @Override
    public void onAttach(Context context) {
        mainActivity = (WeatherListListener) context;
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mainView = inflater.inflate(R.layout.fragment_main, container, false);

        FillCityList();

        RecyclerView rView = mainView.findViewById(R.id.recucler_view);
        LinearLayoutManager llManager = new LinearLayoutManager(getActivity());
        rView.setLayoutManager(llManager);
        rView.setAdapter(new MyDataAdapter());

        return mainView;
    }

    private void FillCityList() {
        cities = new ArrayList<>();
        String[]citiesArray = getResources().getStringArray(R.array.city_array);
        if (citiesArray.length != 0){
            for (int i = 0; i < citiesArray.length; i++) {
                ClassCity newCity = new ClassCity(citiesArray[i]);
                cities.add(newCity);
            }
        }
    }

    private void showWeatherScreen(int layoutPosition) {
        mainActivity.onListItemClick(layoutPosition);
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
            showWeatherScreen(this.getLayoutPosition());
//                Intent intent = new Intent(v.getContext(), WeatherActivity.class);
//                intent.putExtra(ARRAY_INDEX, getLayoutPosition());
//                intent.putExtra(CHECKBOX_PRESSURE, boxPressure.isChecked());
//                intent.putExtra(CHECKBOX_MOONPHASE, boxMoon.isChecked());
//                intent.putExtra(CHECKBOX_TOMORROW, boxTomorrow.isChecked());
//                intent.putExtra(CHECKBOX_WEEK, boxWeek.isChecked());
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
