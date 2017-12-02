package com.leet.leet.screen.statistics.screen.daily.view;

//import android.support.v4.content.ContextCompat;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.leet.leet.R;
import com.leet.leet.screen.statistics.screen.daily.model.StatisticsDailyModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YasuhiraChiba on 2017/11/05.
import com.github.mikephil.charting.charts.BarChart;

import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;


import com.leet.leet.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YasuhiraChiba on 2017/11/05.
 *
 * Modified by PyonegKyu Hwang on 11/19/2017.
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
        //remove bottomright corner description text
        graphView.getDescription().setEnabled(false);


        //X-Axis labels
        ArrayList<String> labels = new ArrayList<>();
        labels.add("Cal");
        labels.add("Carb");
        labels.add("Fat");
        labels.add("Protein");
        labels.add("Price");

        //center the bars at each labels
        XAxis xAxis = graphView.getXAxis();
        xAxis.setCenterAxisLabels(true);
        graphView.getXAxis().setValueFormatter(new IndexAxisValueFormatter(labels));
        graphView.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM_INSIDE );

    }

    public void setDataToGraph(float price_B, float price_L, float price_D,
                               float[] calories,
                               float[] carbs,
                               float[] fat,
                               float[] protein
                               ) {


        //data input
        ArrayList<BarEntry> entries_intakes = new ArrayList<BarEntry>();
        List<BarEntry> entries_goals = new ArrayList<>();

        float breakfast = 5;
        float lunch;
        lunch = price_L;
        float dinner = 4;
        float[] price_value = new float[]{breakfast, lunch, dinner};

        entries_intakes.add(new BarEntry(0f, calories));
        entries_intakes.add(new BarEntry(1f, getCarb()));
        entries_intakes.add(new BarEntry(2f, fat));
        entries_intakes.add(new BarEntry(3f, protein));
        entries_intakes.add(new BarEntry(4f, price_value));

        entries_goals.add(new BarEntry(0f, getCalGoal()));
        entries_goals.add(new BarEntry(1f, getCarbGoal()));
        entries_goals.add(new BarEntry(2f, getFatGoal()));
        entries_goals.add(new BarEntry(3f, getProteinGoal()));
        entries_goals.add(new BarEntry(4f, getPriceGoal()));


        //BarDataSet set1 = new BarDataSet(entries_intakes, "");
        //BarDataSet set2 = new BarDataSet(entries_goals, "Daily Goal");

        BarDataSet set1;
        BarDataSet set2 = null;

        if (graphView.getData() != null &&
                graphView.getData().getDataSetCount() > 0) {
            set1 = (BarDataSet) graphView.getData().getDataSetByIndex(0);
            set1.setValues(entries_intakes);
            graphView.getData().notifyDataChanged();
            graphView.notifyDataSetChanged();
        } else {
            set1 = new BarDataSet(entries_intakes, "");
            set1.setDrawIcons(false);
            set1.setColors(getColors());
            set1.setStackLabels(new String[]{"Breakfast", "Lunch", "Dinner"});
            set2 = new BarDataSet(entries_goals, "Daily Goal");

            ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
            dataSets.add(set1);

            BarData data = new BarData(dataSets);
            data.setValueTextColor(Color.BLACK);

            graphView.setData(data);
        }

        //bar size, colors, space between two bars and two variables
        set1.setColors(getColors());
        //set1.setStackLabels(new String[]{"Breakfast", "Lunch", "Dinner"});
        set2.setColors(R.color.colorPrimary);
        float groupSpace = 0.08f;
        float barSpace = 0.02f;
        float barWidth = 0.40f;

        //set1 = (BarDataSet) graphView.getData().getDataSetByIndex(0);
        set1.setValues(entries_intakes);
        //setting the data into the graph
        BarData data = new BarData(set1, set2);
        data.setBarWidth(barWidth);

        graphView.setData(data);

        //grouped bar
        graphView.groupBars(0f, groupSpace, barSpace);

        graphView.setFitBars(true);
        graphView.invalidate(); // refresh
    }

    //Color setting for stacked bars
    private int[] getColors() {
        int stacksize = 3;

        int[] colors = new int[stacksize];

        for (int i = 0; i < colors.length; i++) {
            colors[i] = ColorTemplate.MATERIAL_COLORS[i];
        }

        return colors;
    }





    //Setting intake values of graph
    //Hard Coded numbers will be replaced by received values from database
    //Calories intake & goals
    private float[] getCal() {
        //need to divide by 100
        float breakfast = 4;
        float lunch = 6;
        float dinner = 8;
        float[] total = new float[] {breakfast, lunch, dinner};
        return total;
    }
    private float getCalGoal() {
        float goal = 0;
        if(goal == 0) {
            return 23f;
        }
        else {
            return goal / 100;
        }
    }

    //Carb intake & goals
    private float[] getCarb() {
        //need to divide by 10
        float breakfast = 2;
        float lunch = 8;
        float dinner = 10;
        float[] total = new float[] {breakfast, lunch, dinner};
        return total;
    }
    private float getCarbGoal() {
        float goal = 0;
        if(goal == 0) {
            return 13f;
        }
        else {
            return goal / 10;
        }
    }

    //Fat intake & goals
    private float[] getFat() {
        //need to divide by 10
        float breakfast = 0;
        float lunch = 3;
        float dinner = 5;
        float[] total = new float[] {breakfast, lunch, dinner};
        return total;
    }
    private float getFatGoal() {
        float goal = 0;
        if(goal == 0) {
            return 7f;
        }
        else {
            return goal / 10;
        }
    }
    //Protein intake & goals
    private float[] getProtein() {
        //need to divide by 10
        float breakfast = 1;
        float lunch = 4;
        float dinner = 9;
        float[] total = new float[] {breakfast, lunch, dinner};
        return total;
    }
    private float getProteinGoal() {
        float goal = 0;
        if(goal == 0) {
            return 5f;
        }
        else {
            return goal / 10;
        }
    }

    //Price spent & goals
    float breakfast = 2;
    private float[] getPrice() {
        float lunch = 5;
        float dinner = 9;
        float[] total = new float[] {breakfast, lunch, dinner};
        return total;
    }
    private float getPriceGoal() {
        float goal = 0;
        return goal;
    }


    @Override
    public View getRootView() {
        return mRootView;
    }

}
