package com.leet.leet.screen.statistics.screen.daily.controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leet.leet.common.Enums;
import com.leet.leet.screen.statistics.screen.daily.StatisticsDailyInterface;
import com.leet.leet.screen.statistics.screen.daily.model.StatisticsDailyModel;
import com.leet.leet.screen.statistics.screen.daily.view.StatisticsDailyView;
import com.leet.leet.screen.statistics.screen.daily.view.StatisticsDailyViewInterface;
import com.leet.leet.utils.database.FirebaseDBCallaback;
import com.leet.leet.utils.database.entities.menu.MenuEntity;

import org.joda.time.LocalDate;


/**
 * Created by YasuhiraChiba on 2017/11/05.
 *
 * Modified by Pyeong Kyu Hwang on 2017/12/02.
 * {@link Fragment} subclass.
 */


public class StatisticsDailyFragment extends Fragment implements StatisticsDailyViewInterface.StatisticsDailyViewListener {

    StatisticsDailyView mView;
    StatisticsDailyModel mModel;
    private StatisticsDailyInterface mListener;

    /**
     * Simple fragment
     *
     * @param date
     * @param listener
     */
    public void setupFragment(LocalDate date,StatisticsDailyInterface listener) {
        this.mListener = listener;
        mModel = new StatisticsDailyModel();
        mModel.setDate(date);
    }

    /**
     * onCreateView
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return view
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = new StatisticsDailyView(inflater,container,this);

        //Call functions in model to retrive data from the firebase
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
                        );                    }
                });
            }
        });


        return mView.getRootView();
    }

    /**
     * Function to enable ExpendableListView to response with touch
     *
     * @param time  : breakfast, lunch, or dinner
     * @param index : number of items
     */
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
        mModel.menuSelected(menu,time);
        mListener.moveToDetailView(menu);
    }

    /**
     * function cals deleteSelectedMeal function from model to delete a selected item.
     */
    public void menuDeleting() {
        mModel.deleteSelectedMeal();
    }
}

