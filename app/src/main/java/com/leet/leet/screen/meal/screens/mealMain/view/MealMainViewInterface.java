package com.leet.leet.screen.meal.screens.mealMain.view;

import com.leet.leet.common.ViewBaseInterface;

/**
 * Created by YasuhiraChiba on 2017/11/16.
 */

//For MealMainView
public interface MealMainViewInterface extends ViewBaseInterface {

    //For communnicate MealmainView and MealMainFragment
    interface MealMainViewListner {
        void buttonTap();
    }
}
