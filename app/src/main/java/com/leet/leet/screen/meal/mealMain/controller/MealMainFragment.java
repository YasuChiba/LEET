package com.leet.leet.screen.meal.mealMain.controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leet.leet.screen.account.model.AccountModel;
import com.leet.leet.screen.account.view.AccountView;
import com.leet.leet.screen.meal.mealMain.view.MealMainView;

/**
 * Created by YasuhiraChiba on 2017/11/16.
 */

public class MealMainFragment extends Fragment {

    MealMainView mView;

    @Override //what is this?
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        mView = new MealMainView(inflater, container);


        return mView.getRootView();
    }

}
