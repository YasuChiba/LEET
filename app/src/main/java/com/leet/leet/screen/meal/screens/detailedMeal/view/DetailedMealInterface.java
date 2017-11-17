package com.leet.leet.screen.meal.screens.detailedMeal.view;

import com.leet.leet.common.ViewBaseInterface;

/**
 * Created by k3vn19 on 11/16/2017.
 */

public interface DetailedMealInterface extends ViewBaseInterface {

    interface DetailedMealListener{
        void addMealClick();
    }

    void setListener(DetailedMealListener listener);

}


