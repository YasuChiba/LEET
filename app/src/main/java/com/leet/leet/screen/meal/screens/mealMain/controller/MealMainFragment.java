package com.leet.leet.screen.meal.screens.mealMain.controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leet.leet.common.Enums;
import com.leet.leet.screen.meal.screens.mealMain.MealMainListner;
import com.leet.leet.screen.meal.screens.mealMain.view.MealMainView;
import com.leet.leet.screen.meal.screens.mealMain.view.MealMainViewInterface;

/**
 * Created by YasuhiraChiba on 2017/11/16.
 */

public class MealMainFragment extends Fragment implements MealMainViewInterface.MealMainViewListner {

    MealMainView mView;
    MealMainListner mainListner; //once button is clicked, move to another fragment


    //Since Fragment cannot implement constructor with our original arguments, we should create this kind of method
    public void setupFragment(MealMainListner listner) {
        this.mainListner = listner;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        mView = new MealMainView(inflater, container, this);
        return mView.getRootView();
    }

    @Override
    /**
     * Purpose - Method of MealMainViewListner to switch from meal main to a specific dining hall
     *           menu.
     */
    public void mealToResult(Enums.RestaurantName restaurantName) {
       // mainListner.moveToDetaileFragment();
        mainListner.moveToResultFragment(restaurantName);
    }

    @Override
    /**
     * Purpose - Transition from main meal page to custom menu
     */
    public void mealToCustom() { mainListner.moveToAddCustomFragment();}

}
