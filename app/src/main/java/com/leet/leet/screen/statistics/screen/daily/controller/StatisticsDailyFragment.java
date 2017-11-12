package com.leet.leet.screen.statistics.screen.daily.controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leet.leet.screen.statistics.model.StatisticsModel;
import com.leet.leet.screen.statistics.screen.daily.model.StatisticsDailyModel;
import com.leet.leet.screen.statistics.screen.daily.view.StatisticsDailyView;
import com.leet.leet.screen.statistics.screen.daily.view.StatisticsDailyViewInterface;
import com.leet.leet.screen.statistics.view.StatisticsView;

/**
 * Created by YasuhiraChiba on 2017/11/05.
 */

public class StatisticsDailyFragment extends Fragment {

    StatisticsDailyView mView;
    StatisticsDailyModel mModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mModel = new StatisticsDailyModel();
        mView = new StatisticsDailyView(inflater,container);

        Log.d("","ONCREATEVIEW NOWWW");
    //    mModel.setDataTest();
        mModel.getDateTest();

        return mView.getRootView();
    }


}
