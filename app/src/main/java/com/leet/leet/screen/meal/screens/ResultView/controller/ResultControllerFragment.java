package com.leet.leet.screen.meal.screens.ResultView.controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leet.leet.screen.meal.screens.ResultView.ResultListener;
import com.leet.leet.screen.meal.screens.ResultView.view.ResultViewInterface;
import com.leet.leet.screen.meal.screens.ResultView.view.ResultView;

/**
 * Created by Sam on 11/19/2017.
 */

public class ResultControllerFragment extends Fragment implements ResultViewInterface.ResultListener {
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
        return resultView.getRootView();
    }

    //Method of ResultListener
    @Override
    public void buttonTap() {
        resultListener.moveToOtherFragment();
    }
}
