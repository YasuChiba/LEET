package com.leet.leet.screen.statistics.controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leet.leet.screen.account.model.AccountModel;
import com.leet.leet.screen.account.view.AccountView;
import com.leet.leet.screen.statistics.model.StatisticsModel;
import com.leet.leet.screen.statistics.view.StatisticsView;

/**
 * Created by YasuhiraChiba on 2017/11/05.
 */

public class StatisticsFragment extends Fragment {

    StatisticsView mView;
    StatisticsModel mModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mModel = new StatisticsModel();
        mView = new StatisticsView(inflater,container);

        return mView.getRootView();
    }
}
