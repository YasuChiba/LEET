package com.leet.leet.screen.statistics.screen.daily.view;

import com.leet.leet.common.Enums;
import com.leet.leet.common.ViewBaseInterface;

/**
 * This interface initialize listener.
 * Created by YasuhiraChiba on 2017/11/05.
 */

public interface StatisticsDailyViewInterface extends ViewBaseInterface {

    interface StatisticsDailyViewListener{
        void elementTapped(Enums.MealTime time,int index);
    }

}
