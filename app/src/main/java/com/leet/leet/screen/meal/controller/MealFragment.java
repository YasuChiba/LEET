package com.leet.leet.screen.meal.controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leet.leet.common.Enums;
import com.leet.leet.screen.meal.screens.ResultView.MealResultListener;
import com.leet.leet.screen.meal.screens.ResultView.controller.ResultControllerFragment;
import com.leet.leet.screen.meal.screens.addCustomMeal.controller.AddCustomMealFragment;
import com.leet.leet.screen.meal.screens.detailedMeal.controller.DetailedMealFragment;
import com.leet.leet.screen.meal.screens.detailedMeal.view.DetailedMealInterface;
import com.leet.leet.screen.meal.screens.mealMain.MealMainListner;
import com.leet.leet.screen.meal.screens.mealMain.controller.MealMainFragment;
import com.leet.leet.screen.meal.view.MealView;
import com.leet.leet.utils.database.entities.menu.MenuEntity;

/**
 * This is the base fragment for the meal page
 * Created by YasuhiraChiba on 2017/11/16.
 */

public class MealFragment extends Fragment implements MealMainListner,MealResultListener{

    MealView mView;
    MealMainFragment mealMainFragment;
    AddCustomMealFragment fragmentAddCustomMeal;
    ResultControllerFragment resultFragment;
    DetailedMealFragment fragmentDetailedMeal;

    //This flag is true when this screen is shown
    private boolean isScreenShow = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mView = new MealView(inflater, container);

        //set initial fragment.
        mealMainFragment = new MealMainFragment();
        mealMainFragment.setupFragment(this);
        mView.changeContent(getFragmentManager(),mealMainFragment,false);

        return mView.getRootView();
    }

    /**
     *  This method handles the shifting of fragment to the add custome meal fragment
     */
    @Override
    public void moveToAddCustomFragment(){
        fragmentAddCustomMeal = new AddCustomMealFragment();
        mView.changeContent(getFragmentManager(), fragmentAddCustomMeal, true);
    }

    /**
     * This method handles the shifting of fragment to the result page from the meal main page
     *
     */
    @Override
    public void moveToResultFragment(Enums.RestaurantName restaurantName) {
        resultFragment = new ResultControllerFragment();
        resultFragment.setupFragment(restaurantName,this);
        resultFragment.isScreenShow(true);
        mView.changeContent(getFragmentManager(),resultFragment,true);
    }

    /**
     * This method handles the shifting of fragment to the detailed fragment
     *
     */
    @Override
    public void moveToDetailFragment(MenuEntity data) {
        fragmentDetailedMeal = new DetailedMealFragment();
        fragmentDetailedMeal.setupFragment(data);
        mView.changeContent(getFragmentManager(),fragmentDetailedMeal, true);
    }

    /**
     * This method handles whether this screen is going to be displayed or not
     *
     */
    public void isScreenShow(boolean isScreenShow) {
        this.isScreenShow = isScreenShow;
        if(resultFragment != null) {
            resultFragment.isScreenShow(isScreenShow);
        }
    }
}
