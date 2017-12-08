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
 * This class is the controller of the mail main fragment
 * Created by YasuhiraChiba on 2017/11/16.
 */

public class MealMainFragment extends Fragment implements MealMainViewInterface.MealMainViewListner {

    MealMainView mView;
    MealMainListner mainListner; // listener that handles switching fragment once button is clicked


    /**
     * This method sets up the fragment that will be swtiched onto
     * @param listner
     */
    public void setupFragment(MealMainListner listner) {
        this.mainListner = listner;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        mView = new MealMainView(inflater, container, this);
        return mView.getRootView();
    }

    /**
     *  This method changes the shifting from meal main page to the result page
     */
    @Override
    /**
     * This Method of MealMainViewListner to switch from meal main to a specific dining hall
     *           menu.
     */
    public void mealToResult(Enums.RestaurantName restaurantName) {
        mainListner.moveToResultFragment(restaurantName);
    }

    /**
     * This method changes the shifting from meal main page to the custom meal page
     */
    @Override
    /**
     * Purpose - Transition from main meal page to custom menu
     */
    public void mealToCustom() { mainListner.moveToAddCustomFragment();}

}
