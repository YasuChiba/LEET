package com.leet.leet.screen.statistics.screen.daily.controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.leet.leet.R;
import com.leet.leet.common.Enums;
import com.leet.leet.screen.statistics.model.StatisticsModel;
import com.leet.leet.screen.statistics.screen.daily.StatisticsDailyInterface;
import com.leet.leet.screen.statistics.screen.daily.model.StatisticsDailyModel;
import com.leet.leet.screen.statistics.screen.daily.view.StatisticsDailyView;
import com.leet.leet.screen.statistics.screen.daily.view.StatisticsDailyViewInterface;
import com.leet.leet.screen.statistics.view.StatisticsView;
import com.leet.leet.utils.database.FirebaseDBCallaback;
import com.leet.leet.utils.database.entities.menu.MenuEntity;

import org.joda.time.LocalDate;

import java.util.ArrayList;

/**
 * Created by YasuhiraChiba on 2017/11/05.
 */

public class StatisticsDailyFragment extends Fragment implements StatisticsDailyViewInterface.StatisticsDailyViewListener {

    StatisticsDailyView mView;
    StatisticsDailyModel mModel;
    private StatisticsDailyInterface mListener;

    public void setupFragment(LocalDate date,StatisticsDailyInterface listener) {
        this.mListener = listener;
        mModel = new StatisticsDailyModel();
        mModel.setDate(date);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = new StatisticsDailyView(inflater,container,this);

        mModel.getUserGoal(new FirebaseDBCallaback<Boolean>() {
            @Override
            public void getData(Boolean data) {
                mModel.getStatisticsData(new FirebaseDBCallaback<Boolean>() {
                    @Override
                    public void getData(Boolean success) {
                        mView.setDataToGraph(mModel.getPrice(),
                                mModel.getCalorie(),
                                mModel.getCarbs(),
                                mModel.getFat(),
                                mModel.getProtein(),
                                mModel.getUserGoalEntity()
                                             );

                        mView.setDataToRow(mModel.getBreakfastList(),
                                            mModel.getLunchList(),
                                            mModel.getDinnerList()
                                            );
                    }
                });
            }


        });


        return mView.getRootView();

    }

    @Override
    public void elementTapped(Enums.MealTime time, int index) {
        Log.d("","");
        MenuEntity menu;
        if(time == Enums.MealTime.Breakfast) {
            menu = mModel.getBreakfastList().get(index);
        } else if(time == Enums.MealTime.Lunch) {
            menu = mModel.getLunchList().get(index);
        } else {
            menu = mModel.getDinnerList().get(index);
        }
        mListener.moveToDetailView(menu);
    }
}

