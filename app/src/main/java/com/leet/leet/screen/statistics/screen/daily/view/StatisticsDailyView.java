package com.leet.leet.screen.statistics.screen.daily.view;

//import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;

import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;


import com.leet.leet.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YasuhiraChiba on 2017/11/05.
 */

public class StatisticsDailyView implements StatisticsDailyViewInterface {
    private View mRootView;
    private BarChart graphView;


    public StatisticsDailyView(LayoutInflater inflater, ViewGroup container) {

        mRootView = inflater.inflate(R.layout.view_statistics_daily, container, false);

       initialize();
    }


    private void initialize() {
        graphView = (BarChart)mRootView.findViewById(R.id.stats_daily_chart);

        //disable touch on the graph
        graphView.setTouchEnabled(false);
        //remove vertical axis grid
        graphView.getAxisLeft().setDrawGridLines(false);
        graphView.getXAxis().setDrawGridLines(false);

        //data input
        List<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0f, 30f));
        entries.add(new BarEntry(1f, 80f));
        entries.add(new BarEntry(2f, 60f));
        entries.add(new BarEntry(3f, 50f));
        // gap of 2f
        entries.add(new BarEntry(5f, 70f));
        entries.add(new BarEntry(6f, 60f));

        BarDataSet set = new BarDataSet(entries, "BarDataSet");


        BarData data = new BarData(set);
        data.setBarWidth(0.9f); // set custom bar width
        graphView.setData(data);
        graphView.setFitBars(true); // make the x-axis fit exactly all bars
        graphView.invalidate(); // refresh
    }
    @Override
    public View getRootView() {
        return mRootView;
    }

}
