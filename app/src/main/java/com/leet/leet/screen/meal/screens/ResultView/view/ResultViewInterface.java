package com.leet.leet.screen.meal.screens.ResultView.view;

import com.leet.leet.common.Enums;
import com.leet.leet.common.ViewBaseInterface;

public interface ResultViewInterface extends ViewBaseInterface {

    // So ResultView and ResultControllerFragment can communicate
    interface MealResultViewListener {
        void listTap(int i);
        void mealTimeSelected(Enums.MealTime time);
    }

    //connect ResultView list's header and ResultView
    interface MealResultHeaderListener {
        void mealTimeSelected(Enums.MealTime time);
    }
}