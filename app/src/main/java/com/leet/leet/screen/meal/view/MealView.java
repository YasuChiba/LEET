package com.leet.leet.screen.meal.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leet.leet.R;

/**
 * Created by Jhern on 11/15/2017.
 */

//This is base view for Meal. By changing the content of R.id.meal_base_container, move to other screen.
public class MealView implements MealViewInterface {

    private View mRootView;

    public MealView(LayoutInflater inflater, ViewGroup container) {
        mRootView = inflater.inflate(R.layout.view_meal, container, false);
    }

    @Override
    public View getRootView() {
        return mRootView;
    }

    //this method goot to be put in controller. but this method use "R.id.~" which is unique in view, so i put this here.
    public void changeContent(FragmentManager fragmentManager, Fragment fragment, boolean isAddToStack) {

        FragmentTransaction transaction = fragmentManager.beginTransaction().replace(R.id.meal_base_container, fragment);

        //if add to stack, back button works.
        if(isAddToStack) {
            transaction = transaction.addToBackStack(null);
        }
        transaction.commit();
    }
}
