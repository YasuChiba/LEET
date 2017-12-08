package com.leet.leet.screen.meal.screens.mealMain;

import com.leet.leet.common.Enums;

/**
 * This class allows the communication between MealFragment and MealMainFragment
 * Created by YasuhiraChiba on 2017/11/16.
 */

public interface MealMainListner {

    void moveToAddCustomFragment();

    void moveToResultFragment(Enums.RestaurantName restaurantName);
}
