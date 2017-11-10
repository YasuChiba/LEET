package com.leet.leet.screen.statistics.screen.weekly.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leet.leet.R;

/**
 * Created by YasuhiraChiba on 2017/11/07.
 */

public class StatisticsWeeklyView implements StatisticsWeeklyViewInterface {

    private View mRootView;


    public StatisticsWeeklyView(LayoutInflater inflater, ViewGroup container) {

        mRootView = inflater.inflate(R.layout.view_statistics_weekly, container, false);

        initialize();
    }

    private void initialize() {

    }

    @Override
    public View getRootView() {
        return mRootView;
    }
}
