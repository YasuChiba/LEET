package com.leet.leet.screen.statistics.screen.weekly.view;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.leet.leet.R;

import java.util.ArrayList;

/**
 * Created by YasuhiraChiba on 2017/11/07.
 */

public class StatisticsWeeklyView implements StatisticsWeeklyViewInterface {

    private View mRootView;

    private LineChart graphView;



    public StatisticsWeeklyView(LayoutInflater inflater, ViewGroup container) {

        mRootView = inflater.inflate(R.layout.view_statistics_weekly, container, false);

        initialize();
    }

    private void initialize() {
        graphView = (LineChart)mRootView.findViewById(R.id.stats_weekly_graph);
       // graphView.setOnChartGestureListener(this);
        //graphView.setOnChartValueSelectedListener(this);
        graphView.setDrawGridBackground(false);

        graphView.getDescription().setEnabled(false);
        graphView.setTouchEnabled(true);
        // enable scaling and dragging
        graphView.setDragEnabled(false);
        graphView.setScaleEnabled(false);
        // mChart.setScaleXEnabled(true);
        // mChart.setScaleYEnabled(true);
        // if disabled, scaling can be done on x- and y-axis separately
        graphView.setPinchZoom(true);
        graphView.getLegend().setEnabled(false);

    }

    @Override
    public View getRootView() {
        return mRootView;
    }

    public void setDataToGraph(final ArrayList<String> labelList , final ArrayList<Float> val) {
        ArrayList<Float> tmp = new ArrayList<>();

        if(val == null) {
            tmp.add(((float)10));
            tmp.add((float)20);
            tmp.add((float)90);
            tmp.add((float)10);
            tmp.add((float)10);
            tmp.add((float)66);
            tmp.add((float)30);
        } else {
            tmp = val;
        }


        ArrayList<Entry> entries = new ArrayList<Entry>();
        for(int i=0; i<tmp.size();i++){
            entries.add(new Entry(i, tmp.get(i)));
        }

        LineDataSet dataSet = new LineDataSet(entries,null);
        dataSet.setColor(Color.BLACK);

        LineData data = new LineData(dataSet);
        graphView.setData(data);

        XAxis xAxis = graphView.getXAxis();
        xAxis.setGranularity(1f);
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return labelList.get((int)value);
            }
        });

        graphView.invalidate();

    }
}
