package com.leet.leet.screen.meal.mealBase.controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leet.leet.screen.meal.mealBase.view.MealBaseView;

/**
 * Created by YasuhiraChiba on 2017/11/16.
 */

public class MealBaseFragment extends Fragment {


    MealBaseView mView;

    @Override //what is this?
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        mView = new MealBaseView(inflater, container);


        return mView.getRootView();
    }

}
