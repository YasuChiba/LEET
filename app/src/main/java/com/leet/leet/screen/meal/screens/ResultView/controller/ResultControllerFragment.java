package com.leet.leet.screen.meal.screens.ResultView.controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leet.leet.common.Enums;
import com.leet.leet.screen.meal.screens.ResultView.MealResultListener;
import com.leet.leet.screen.meal.screens.ResultView.model.MealResultModel;
import com.leet.leet.screen.meal.screens.ResultView.view.ResultViewInterface;
import com.leet.leet.screen.meal.screens.ResultView.view.ResultView;
import com.leet.leet.utils.database.FirebaseDBCallaback;

/**
 * Created by Sam on 11/19/2017.
 */

public class ResultControllerFragment extends Fragment implements ResultViewInterface.MealResultViewListener {

    MealResultModel model;
    ResultView resultView;
    private MealResultListener mListner;

    //Since Fragment cannot implement constructor with our original arguments, we should create this kind of method
    public void setupFragment(Enums.RestaurantName restaurantName,MealResultListener listener) {
        model = new MealResultModel();
        model.setCurrentRestaurantName(restaurantName);
        this.mListner = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        resultView = new ResultView(inflater, container,this);
        this.setMenuToListView();
        resultView.setupMealTimeSpinner(model.getMealTimeList(),model.getCurrentMealTime().getIndex());
        return resultView.getRootView();
    }

    private void setMenuToListView() {
        model.getMenu(new FirebaseDBCallaback<Boolean>() {
            @Override
            public void getData(Boolean data) {
                resultView.setupListView(model.getMenuEntityList());
            }
        });
    }

    @Override
    public void listTap(int i) {
        mListner.moveToDetailFragment(model.getMenuEntityList().get(i-1));
    }

    @Override
    public void mealTimeSelected(Enums.MealTime time) {
        model.setCurrentMealTime(time);
        setMenuToListView();
    }
}
