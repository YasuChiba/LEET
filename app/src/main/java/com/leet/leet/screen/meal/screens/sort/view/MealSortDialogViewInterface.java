package com.leet.leet.screen.meal.screens.sort.view;

import com.leet.leet.common.ViewBaseInterface;

/**
 * Created by YasuhiraChiba on 2017/11/29.
 */

public interface MealSortDialogViewInterface extends ViewBaseInterface {

    interface MealSortDialogViewListener{
        void priceSelected(int index);
        void calorieSelected(int index);
        void carbsSelected(int index);
        void totalFatSelected(int index);
        void satFatSelected(int index);
        void proteinSelected(int index);
        void sodiumSelected(int index);
        void cholesterolSelected(int index);
        void fiberSelected(int index);
        void sugarSelected(int index);
    }
}
