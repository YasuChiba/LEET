package com.leet.leet.screen.meal.controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leet.leet.R;
import com.leet.leet.screen.meal.screens.mealMain.controller.MealMainFragment;
import com.leet.leet.screen.meal.view.MealView;

/**
 * Created by YasuhiraChiba on 2017/11/16.
 */

//This is base fragment for Meal

public class MealFragment extends Fragment {


    MealView mView;

    @Override //what is this?
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mView = new MealView(inflater, container);

        MealMainFragment fragment = new MealMainFragment();
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.meal_base_container, fragment)
                .commit();

        return mView.getRootView();
    }

}
