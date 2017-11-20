package com.example.gvg.myweather_fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AdditionalFragment extends Fragment {

    private String addText;

    public void setAddText(String addText) {
        this.addText = addText;
    }

    public AdditionalFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View addView = inflater.inflate(R.layout.fragment_additional, container, false);
        TextView addTextField = addView.findViewById(R.id.additional_text);
        if (addText != null) {
            addTextField.setText(addText);
        }
        return addView;
    }

}
