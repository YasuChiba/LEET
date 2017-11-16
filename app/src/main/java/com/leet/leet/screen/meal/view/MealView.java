package com.leet.leet.screen.meal.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leet.leet.R;

/**
 * Created by Jhern on 11/15/2017.
 */

public class MealView implements MealViewInterface {

        private View mRootView;

        public MealView(LayoutInflater inflater, ViewGroup container) {
            mRootView = inflater.inflate(R.layout.view_meal, container, false);

        }

    @Override
    public View getRootView() {
        return mRootView;
    }
}
