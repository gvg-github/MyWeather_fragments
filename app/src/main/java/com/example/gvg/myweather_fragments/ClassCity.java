package com.example.gvg.myweather_fragments;

import android.content.Context;

/**
 * Created by GVG on 15.11.2017.
 */

public class ClassCity {
    private String[] cities;
    private String name;

    public ClassCity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
