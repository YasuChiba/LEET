package com.leet.leet.screen.meal.screens.addCustomMeal.view;


import com.leet.leet.common.ViewBaseInterface;

/**
 * Created by k3vn19 on 11/15/2017.
 */

public interface CustomMealInterface extends ViewBaseInterface {
    interface CustomMealListener{
        void addMealClick();
    }

    void setListener(CustomMealListener listener);
}
