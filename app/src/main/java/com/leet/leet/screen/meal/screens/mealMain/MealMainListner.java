package com.leet.leet.screen.meal.screens.mealMain;

import com.leet.leet.common.Enums;

/**
 * Created by YasuhiraChiba on 2017/11/16.
 */

//This interface is for communicate MealFragment with MealMainFragment
public interface MealMainListner {

    void moveToAddCustomFragment();

    void moveToResultFragment(Enums.RestaurantName restaurantName);
}
