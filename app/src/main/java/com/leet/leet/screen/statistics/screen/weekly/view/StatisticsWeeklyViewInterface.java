package com.leet.leet.screen.statistics.screen.weekly.view;

import com.leet.leet.common.Enums;
import com.leet.leet.common.ViewBaseInterface;

/**
 * Created by YasuhiraChiba on 2017/11/07.
 */

public interface StatisticsWeeklyViewInterface extends ViewBaseInterface {

    interface StatisticsWeeklyViewListner {
        void graphUpdateButtonTap(Enums.GraphElements type);
    }

    interface StatisticsWeeklyListViewHeaderListener {
        void buttonTap(Enums.GraphElements elem);
    }
}
