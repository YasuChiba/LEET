package com.leet.leet.screen.meal.screens.confirmAdd.view;

import com.leet.leet.common.ViewBaseInterface;

/**
 * Created by k3vn19 on 12/3/2017.
 */

public interface ConfirmAddDialogViewInterface extends ViewBaseInterface {

    interface ConfirmAddDialogViewListener{
        void mealTimeSelected(int index); //Implemented in Fragment
    }
}
