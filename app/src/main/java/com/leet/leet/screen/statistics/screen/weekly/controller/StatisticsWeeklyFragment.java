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
import com.leet.leet.utils.DateHelper;
import com.leet.leet.utils.database.FirebaseDBCallaback;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by YasuhiraChiba on 2017/11/07.
 */

public class StatisticsWeeklyFragment extends Fragment {

    StatisticsWeeklyView mView;
    StatisticsWeeklyModel mModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mModel = new StatisticsWeeklyModel();
        mView = new StatisticsWeeklyView(inflater,container);
        mModel.getStatisticsData(DateHelper.getPastDate(5),
                DateHelper.getCurrentDate(),
                new FirebaseDBCallaback<Boolean>() {

                    @Override
                    public void getData(Boolean success) {
                        mView.setDataToGraph(mModel.getWeekList(),mModel.getPriceList());
                    }
        });

        return mView.getRootView();
    }
}
