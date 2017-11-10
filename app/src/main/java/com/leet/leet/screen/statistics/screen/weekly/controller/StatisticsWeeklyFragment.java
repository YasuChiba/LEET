package com.leet.leet.screen.statistics.screen.weekly.controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leet.leet.screen.statistics.model.StatisticsModel;
import com.leet.leet.screen.statistics.screen.daily.controller.StatisticsDailyFragment;
import com.leet.leet.screen.statistics.screen.weekly.model.StatisticsWeeklyModel;
import com.leet.leet.screen.statistics.screen.weekly.view.StatisticsWeeklyView;
import com.leet.leet.screen.statistics.view.StatisticsView;

/**
 * Created by YasuhiraChiba on 2017/11/07.
 */

public class StatisticsWeeklyFragment extends Fragment {

    StatisticsWeeklyView mView;
    StatisticsWeeklyModel mModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mModel = new StatisticsWeeklyModel();
        mView = new StatisticsWeeklyView(inflater,container);


        return mView.getRootView();
    }
}
