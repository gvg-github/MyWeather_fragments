package com.example.gvg.myweather_fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AdditionalFragment extends Fragment {


    public AdditionalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View addView = inflater.inflate(R.layout.fragment_additional, container, false);
        TextView addText = addView.findViewById(R.id.additional_text);
        return addView;
    }

}
