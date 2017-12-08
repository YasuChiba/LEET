package com.leet.leet.screen.statistics.controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leet.leet.R;
import com.leet.leet.screen.account.model.AccountModel;
import com.leet.leet.screen.account.view.AccountView;
import com.leet.leet.screen.meal.screens.detailedMeal.controller.DetailedMealFragment;
import com.leet.leet.screen.statistics.model.StatisticsModel;
import com.leet.leet.screen.statistics.screen.daily.StatisticsDailyDetailInterface;
import com.leet.leet.screen.statistics.screen.daily.StatisticsDailyInterface;
import com.leet.leet.screen.statistics.screen.daily.controller.StatisticsDailyFragment;
import com.leet.leet.screen.statistics.screen.weekly.StatisticsWeeklyInterface;
import com.leet.leet.screen.statistics.screen.weekly.controller.StatisticsWeeklyFragment;
import com.leet.leet.screen.statistics.view.StatisticsView;
import com.leet.leet.screen.statistics.view.StatisticsViewInterface;
import com.leet.leet.utils.database.entities.menu.MenuEntity;

import org.joda.time.LocalDate;

/**
 * Created by YasuhiraChiba on 2017/11/05.
 */


public class StatisticsFragment extends Fragment implements StatisticsViewInterface.StatisticsViewListener,
        StatisticsWeeklyInterface,StatisticsDailyInterface, StatisticsDailyDetailInterface{

    private StatisticsView mView;
    private StatisticsModel mModel;

    private StatisticsDailyFragment dailyFragment;
    private StatisticsWeeklyFragment weeklyFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mModel = new StatisticsModel();
        mView = new StatisticsView(inflater,container,this);
        setHasOptionsMenu(true);

        weeklyFragment = new StatisticsWeeklyFragment();
        weeklyFragment.setupFragment(this);
        mView.setContent(getChildFragmentManager(),weeklyFragment,false);

        return mView.getRootView();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu,inflater);
    }


    @Override
    public void changeToDaily(LocalDate date) {
        dailyFragment = new StatisticsDailyFragment();
        dailyFragment.setupFragment(date,this);
        mView.setContent(getChildFragmentManager(),dailyFragment,true);
    }


    @Override
    public void moveToDetailView(MenuEntity menu) {
        DetailedMealFragment detailedMealFragment = new DetailedMealFragment();
        detailedMealFragment.setupFragment(menu,false,this);
        mView.setContent(getChildFragmentManager(),detailedMealFragment,true);
    }


    @Override
    public void menuDeleted() {
        if(dailyFragment != null) {
            dailyFragment.menuDeleting();
        }
    }
}
