package com.leet.leet.screen.statistics.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.Switch;

import com.leet.leet.R;
import com.leet.leet.screen.statistics.controller.StatisticsFragment;

/**
 * Created by YasuhiraChiba on 2017/11/05.
 */

public class StatisticsView implements StatisticsViewInterface, CompoundButton.OnCheckedChangeListener {

    private View mRootView;
    private StatisticsViewListener mListner;

    private FrameLayout container;
    private Switch changeContentSwitch;


    public StatisticsView(LayoutInflater inflater, ViewGroup container,StatisticsViewListener listener ) {
        mRootView = inflater.inflate(R.layout.view_statistics, container, false);
        this.mListner = listener;

        initialize();
    }

    private void initialize() {
        container = (FrameLayout)mRootView.findViewById(R.id.statistics_container);
        changeContentSwitch = (Switch)mRootView.findViewById(R.id.statistics_switch);

        changeContentSwitch.setOnCheckedChangeListener(this);
    }

    public void setContent(FragmentManager fragmentManager, Fragment fragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.statistics_container, fragment);
        transaction.commit();
    }

    @Override
    public View getRootView() {
        return mRootView;
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

        Log.d("","switch changed");
        if(b) {
            mListner.contentChange(StatisticsFragment.StatisticsContent.Daily);
        } else {
            mListner.contentChange(StatisticsFragment.StatisticsContent.Weekly);
        }

    }
}
