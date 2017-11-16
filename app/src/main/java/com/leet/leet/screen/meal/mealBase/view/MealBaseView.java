package com.leet.leet.screen.meal.mealBase.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leet.leet.R;

/**
 * Created by Jhern on 11/15/2017.
 */

public class MealBaseView implements MealBaseViewInterface{

        private View mRootView;

        public MealBaseView(LayoutInflater inflater, ViewGroup container) {
            mRootView = inflater.inflate(R.layout.view_meal_base, container, false);

        }

    @Override
    public View getRootView() {
        return mRootView;
    }
}
