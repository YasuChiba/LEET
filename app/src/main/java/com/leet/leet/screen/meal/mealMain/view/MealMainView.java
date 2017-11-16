package com.leet.leet.screen.meal.mealMain.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leet.leet.R;

/**
 * Created by YasuhiraChiba on 2017/11/16.
 */

public class MealMainView implements MealMainViewInterface{

    private View mRootView;

    public MealMainView(LayoutInflater inflater, ViewGroup container) {
        mRootView = inflater.inflate(R.layout.view_meal_main, container, false);
    }

    @Override
    public View getRootView() {
        return mRootView;
    }
}
