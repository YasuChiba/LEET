package com.leet.leet.screen.meal.screens.mealMain;

import com.leet.leet.common.Enums;

/**
 * This class allows the communication between MealFragment and MealMainFragment
 * Created by YasuhiraChiba on 2017/11/16.
 *
 * Purpose - to switch from mealMain to other pages.
 */

public interface MealMainListner {

    void moveToAddCustomFragment();

    void moveToResultFragment(Enums.RestaurantName restaurantName);
}
