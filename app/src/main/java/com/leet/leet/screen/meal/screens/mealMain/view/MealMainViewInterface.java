package com.leet.leet.screen.meal.screens.mealMain.view;

import com.leet.leet.common.Enums;
import com.leet.leet.common.ViewBaseInterface;

/**
 * Created by YasuhiraChiba on 2017/11/16.
 *
 * Purpose - To connect controller and view of mealMain.
 */

//For MealMainView
public interface MealMainViewInterface extends ViewBaseInterface {

    //For communnicate MealmainView and MealMainFragment
    interface MealMainViewListner {
        void mealToResult(Enums.RestaurantName restaurantName);
        void mealToCustom();
    }
}
