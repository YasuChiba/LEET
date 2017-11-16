package com.leet.leet.screen.statistics.screen.daily.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leet.leet.R;

/**
 * Created by YasuhiraChiba on 2017/11/05.
 */

public class StatisticsDailyView implements StatisticsDailyViewInterface {
    private View mRootView;


    public StatisticsDailyView(LayoutInflater inflater, ViewGroup container) {

        mRootView = inflater.inflate(R.layout.view_statistics_daily, container, false);

        initialize();
    }

    private void initialize() {

    }


    @Override
    public View getRootView() {
        return mRootView;
    }
}
