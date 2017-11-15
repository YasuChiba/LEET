package com.leet.leet.screen.statistics.screen.weekly.view;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
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
        setDataToGraph();

    }

    @Override
    public View getRootView() {
        return mRootView;
    }

    private void setDataToGraph() {

        ArrayList<Integer> val = new ArrayList<>();
        val.add(10);
        val.add(29);
        val.add(100);

        ArrayList<Entry> values = new ArrayList<Entry>();
        for(int i=0; i<val.size();i++){
            values.add(new Entry(i, val.get(i)));
        }

        LineDataSet set1;
        if (graphView.getData() != null &&
                graphView.getData().getDataSetCount() > 0) {
            set1 = (LineDataSet)graphView.getData().getDataSetByIndex(0);
            set1.setValues(values);
            graphView.getData().notifyDataChanged();
            graphView.notifyDataSetChanged();
        } else {
            // create a dataset and give it a type
            set1 = new LineDataSet(values,null);

            set1.setDrawIcons(false);

            // set the line to be drawn like this "- - - - - -"
            set1.enableDashedLine(10f, 5f, 0f);
            set1.enableDashedHighlightLine(10f, 5f, 0f);
            set1.setColor(Color.BLACK);
            set1.setCircleColor(Color.BLACK);
            set1.setLineWidth(1f);
            set1.setCircleRadius(3f);
            set1.setDrawCircleHole(false);
            set1.setValueTextSize(9f);
            set1.setDrawFilled(true);
            set1.setFormLineWidth(1f);
            set1.setFormLineDashEffect(new DashPathEffect(new float[]{10f, 5f}, 0f));
            set1.setFormSize(15.f);

            if (Utils.getSDKInt() >= 18) {
                // fill drawable only supported on api level 18 and above
                /*
                Drawable drawable = ContextCompat.getDrawable(this, R.drawable.);
                set1.setFillDrawable(drawable);
                */
                set1.setFillColor(Color.BLACK);
            } else {
                set1.setFillColor(Color.BLACK);
            }

            ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
            dataSets.add(set1); // add the datasets

            // create a data object with the datasets
            LineData data = new LineData(dataSets);

            // set data
            graphView.setData(data);
        }
    }
}
