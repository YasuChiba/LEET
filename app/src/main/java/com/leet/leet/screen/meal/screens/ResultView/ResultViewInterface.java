package com.leet.leet.screen.meal.screens.ResultView;

import com.leet.leet.common.ViewBaseInterface;

public interface ResultViewInterface extends ViewBaseInterface {

    // So ResultView and ResultControllerFragment can communicate
    interface ResultListener {
        void buttonTap();
    }
}