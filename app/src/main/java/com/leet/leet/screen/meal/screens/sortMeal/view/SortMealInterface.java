package com.leet.leet.screen.meal.screens.sortMeal.view;

import com.leet.leet.common.ViewBaseInterface;

/**
 * Created by k3vn19 on 11/19/2017.
 */

public interface SortMealInterface extends ViewBaseInterface{

    interface SortMealListener{
        void sort();
    }

    void setListener(SortMealListener listener);
}
