package com.leet.leet.screen.meal.screens.ResultView.controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leet.leet.screen.meal.screens.ResultView.ResultListener;
import com.leet.leet.screen.meal.screens.ResultView.model.MealResultModel;
import com.leet.leet.screen.meal.screens.ResultView.view.ResultViewInterface;
import com.leet.leet.screen.meal.screens.ResultView.view.ResultView;
import com.leet.leet.utils.database.FirebaseDBCallaback;

/**
 * Created by Sam on 11/19/2017.
 */

public class ResultControllerFragment extends Fragment implements ResultViewInterface.ResultListener {

    MealResultModel model;
    ResultView resultView;
    ResultListener resultListener; //once button is clicked, move to another fragment

    //Since Fragment cannot implement constructor with our original arguments, we should create this kind of method
    public void setupFragment(ResultListener listener) {
        this.resultListener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        resultView = new ResultView(inflater, container,this);
        model = new MealResultModel();
        model.getMenu(new FirebaseDBCallaback<Boolean>() {
            @Override
            public void getData(Boolean data) {
                resultView.setupListView(model.getMenuEntityList());
            }
        });
        return resultView.getRootView();
    }

    //Method of ResultListener
    @Override
    public void buttonTap() {
        resultListener.moveToOtherFragment();
    }
}
