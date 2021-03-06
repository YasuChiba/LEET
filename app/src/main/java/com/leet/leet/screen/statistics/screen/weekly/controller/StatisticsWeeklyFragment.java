package com.leet.leet.screen.statistics.screen.weekly.controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leet.leet.common.Enums;
import com.leet.leet.screen.statistics.model.StatisticsModel;
import com.leet.leet.screen.statistics.screen.daily.controller.StatisticsDailyFragment;
import com.leet.leet.screen.statistics.screen.weekly.StatisticsWeeklyInterface;
import com.leet.leet.screen.statistics.screen.weekly.model.StatisticsWeeklyModel;
import com.leet.leet.screen.statistics.screen.weekly.view.StatisticsWeeklyView;
import com.leet.leet.screen.statistics.view.StatisticsView;
import com.leet.leet.screen.statistics.screen.weekly.view.StatisticsWeeklyViewInterface;
import com.leet.leet.screen.statistics.view.StatisticsView;
import com.leet.leet.utils.DateHelper;
import com.leet.leet.utils.database.FirebaseDBCallaback;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by YasuhiraChiba on 2017/11/07.
 */

public class StatisticsWeeklyFragment extends Fragment implements StatisticsWeeklyViewInterface.StatisticsWeeklyViewListner {

    StatisticsWeeklyView mView;
    StatisticsWeeklyModel mModel;

    StatisticsWeeklyInterface mListener;

    public void setupFragment(StatisticsWeeklyInterface listner) {
        this.mListener = listner;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mModel = new StatisticsWeeklyModel();
        mView = new StatisticsWeeklyView(inflater,container,this);

        mModel.getUserGoal(new FirebaseDBCallaback<Boolean>() {
            @Override
            public void getData(Boolean data) {

            }
        });

        //get statts data from database and set to view.
        mModel.getStatisticsData(DateHelper.getPastDate(5),
                DateHelper.getCurrentDate(),
                new FirebaseDBCallaback<Boolean>() {
                    @Override
                    public void getData(Boolean success) {
                        //set data to list view
                        mView.setupListView(getContext(),
                                mModel.getAllList(),
                                mModel.getUserGoalEntity());
                        //set data to header's graph
                        mView.setDataToGraph(mModel.getWeekList(),mModel.getPriceList(),mModel.getUserGoalEntity().getPrice());
                    }
        });

        return mView.getRootView();
    }

    @Override
    public void graphUpdateButtonTap(Enums.GraphElements type) {

        switch (type){
            case Calorie:
                mView.setDataToGraph(mModel.getWeekList(),mModel.getCalorieList(),mModel.getUserGoalEntity().getCalorie());
                break;
            case Price:
                mView.setDataToGraph(mModel.getWeekList(),mModel.getPriceList(),mModel.getUserGoalEntity().getPrice());
                break;
            case Protein:
                mView.setDataToGraph(mModel.getWeekList(),mModel.getProteinList(),mModel.getUserGoalEntity().getProtein());
                break;
            case Fat:
                mView.setDataToGraph(mModel.getWeekList(),mModel.getFatList(),mModel.getUserGoalEntity().getFat());
                break;
            case Carb:
                mView.setDataToGraph(mModel.getWeekList(),mModel.getCarbsList(),mModel.getUserGoalEntity().getCarbs());
                break;
        }
    }

    //if the element of list view is tapped, this method called.
    @Override
    public void listElementTap(int index) {
        mListener.changeToDaily(mModel.getDayList().get(mModel.getDayList().size() - index));
    }
}
