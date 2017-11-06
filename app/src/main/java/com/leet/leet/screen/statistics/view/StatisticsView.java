package com.leet.leet.screen.statistics.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leet.leet.R;

/**
 * Created by YasuhiraChiba on 2017/11/05.
 */

public class StatisticsView implements StatisticsViewInterface {

    private View mRootView;


    public StatisticsView(LayoutInflater inflater, ViewGroup container) {
        mRootView = inflater.inflate(R.layout.view_statistics, container, false);

        initialize();
    }

    private void initialize() {

    }

    @Override
    public View getRootView() {
        return null;
    }
}
