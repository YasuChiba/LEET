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
 * Created by YasuhiraChiba on 2017/11/16.
 */

//This is base fragment for Meal
public class MealFragment extends Fragment implements MealMainListner,MealResultListener{

    MealView mView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mView = new MealView(inflater, container);

        //set initial fragment.
        MealMainFragment fragment = new MealMainFragment();
        fragment.setupFragment(this);
        mView.changeContent(getFragmentManager(),fragment,false);

        return mView.getRootView();
    }

    @Override
    public void moveToAddCustomFragment() {
        AddCustomMealFragment fragmentAddCustomMeal = new AddCustomMealFragment();
        mView.changeContent(getFragmentManager(), fragmentAddCustomMeal, true);
    }

    @Override
    public void moveToResultFragment(Enums.RestaurantName restaurantName) {
        ResultControllerFragment resultFragment = new ResultControllerFragment();
        resultFragment.setupFragment(restaurantName,this);
        mView.changeContent(getFragmentManager(),resultFragment,true);
    }

    @Override
    public void moveToDetailFragment(MenuEntity data) {
        DetailedMealFragment fragmentDetailedMeal = new DetailedMealFragment();
        fragmentDetailedMeal.setupFragment(data);
        mView.changeContent(getFragmentManager(),fragmentDetailedMeal, true);
    }
}
