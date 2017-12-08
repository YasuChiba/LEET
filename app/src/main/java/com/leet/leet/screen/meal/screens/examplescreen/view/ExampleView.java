package com.leet.leet.screen.meal.screens.examplescreen.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leet.leet.R;

/**
 * Created by YasuhiraChiba on 2017/11/16.
 *
 * THIS CLASS IS NOT USED, WAS USED AS AN EXAMPLE.
 */

public class ExampleView implements ExampleViewInterface {


    private View mRootView;

    public ExampleView(LayoutInflater inflater, ViewGroup container) {
        mRootView = inflater.inflate(R.layout.view_meal_example, container, false);
    }


    @Override
    public View getRootView() {
        return mRootView;
    }
}
