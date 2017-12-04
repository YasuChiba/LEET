package com.leet.leet.screen.statistics.controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leet.leet.R;
import com.leet.leet.screen.account.model.AccountModel;
import com.leet.leet.screen.account.view.AccountView;
import com.leet.leet.screen.statistics.model.StatisticsModel;
import com.leet.leet.screen.statistics.screen.daily.controller.StatisticsDailyFragment;
import com.leet.leet.screen.statistics.screen.weekly.controller.StatisticsWeeklyFragment;
import com.leet.leet.screen.statistics.view.StatisticsView;
import com.leet.leet.screen.statistics.view.StatisticsViewInterface;

/**
 * Created by YasuhiraChiba on 2017/11/05.
 */


public class StatisticsFragment extends Fragment implements StatisticsViewInterface.StatisticsViewListener {

    public enum StatisticsContent {
        Daily,
        Weekly;
    }

    StatisticsView mView;
    StatisticsModel mModel;

    StatisticsDailyFragment dailyFragment;
    StatisticsWeeklyFragment weeklyFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mModel = new StatisticsModel();
        mView = new StatisticsView(inflater,container,this);

        dailyFragment = new StatisticsDailyFragment();
        weeklyFragment = new StatisticsWeeklyFragment();
        mView.setContent(getChildFragmentManager(),weeklyFragment);
        setHasOptionsMenu(true);
        return mView.getRootView();
    }


    @Override
    public void contentChange(StatisticsContent content) {
        Log.d("","content changing     " + content.name());
        switch(content) {
            case Daily:
                mView.setContent(getChildFragmentManager(),dailyFragment);
                break;
            case Weekly:
                mView.setContent(getChildFragmentManager(),weeklyFragment);
                break;
        }
    }
}
