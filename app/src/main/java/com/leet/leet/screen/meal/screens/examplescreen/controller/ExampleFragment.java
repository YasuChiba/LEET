package com.leet.leet.screen.meal.screens.examplescreen.controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leet.leet.screen.meal.screens.examplescreen.view.ExampleView;
import com.leet.leet.screen.meal.screens.mealMain.controller.MealMainFragment;
import com.leet.leet.screen.meal.view.MealView;

/**
 * Created by YasuhiraChiba on 2017/11/16.
 */

public class ExampleFragment extends Fragment {

    ExampleView mView;

    @Override //what is this?
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mView = new ExampleView(inflater, container);

        return mView.getRootView();
    }
}
