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

public class StatisticsView implements StatisticsViewInterface {

    private View mRootView;
    private StatisticsViewListener mListner;

    private FrameLayout container;

    public StatisticsView(LayoutInflater inflater, ViewGroup container,StatisticsViewListener listener ) {
        mRootView = inflater.inflate(R.layout.view_statistics, container, false);
        this.mListner = listener;

        initialize();
    }

    private void initialize() {
        container = (FrameLayout)mRootView.findViewById(R.id.statistics_container);
    }

    public void setContent(FragmentManager fragmentManager, Fragment fragment) {

        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.setCustomAnimations(
                R.anim.slide_in_right, R.anim.slide_out_left,
                R.anim.slide_in_left, R.anim.slide_out_right
        );
        ft.replace(R.id.statistics_container, fragment);
        ft = ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public View getRootView() {
        return mRootView;
    }

}
