package com.leet.leet.screen.statistics.screen.daily.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.leet.leet.R;
import com.leet.leet.utils.database.entities.user.UserGoalEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BK Hwang on 2017-12-02.
 */

public class StatisticsDailyListViewHeader extends LinearLayout {
    private BarChart graphView;


    public StatisticsDailyListViewHeader(Context context) {
        super(context);
        initializeView(context);
    }

    public StatisticsDailyListViewHeader(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeView(context);
    }

    public StatisticsDailyListViewHeader(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeView(context);
    }

    //Function to initialize graph.
    private void initializeView(Context context) {
        View.inflate(context, R.layout.customview_statistics_daily_list_view_header, this);

        graphView = (BarChart)this.findViewById(R.id.stats_daily_chart);

        //disable touch on the graph
        graphView.setTouchEnabled(false);
        //remove vertical axis grid
        graphView.getAxisLeft().setDrawGridLines(false);
        graphView.getXAxis().setDrawGridLines(false);
        //remove bottomright corner description text
        graphView.getDescription().setEnabled(false);


        //Setting up X-Axis labels
        final ArrayList<String> xLabel = new ArrayList<>();
        xLabel.add("Cal");
        xLabel.add("Carb");
        xLabel.add("Fat");
        xLabel.add("Prot");
        xLabel.add("Price");

        XAxis xAxis = graphView.getXAxis();
        graphView.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM_INSIDE);
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return xLabel.get((int)value);
            }
        });


        xAxis.setGranularity(1f);
    }

    /*  This function sets up data on graph.
        Parameters: float[] price            : holds values of price spent
                    float[] calories         : holds values of calories intakes
                    float[] carbs            : holds values of carbohydrates intakes
                    float[] fat              : holds values of fat intakes
                    float[] protein          : holds values of protein intakes
                    UserGoalEntity goalEntity: holds values of user goal

     */

    public void setDataToGraph(float[] price,
                               float[] calories,
                               float[] carbs,
                               float[] fat,
                               float[] protein,
                               UserGoalEntity goalEntity) {

        //data input, initialize two list of BarEntry to hold values of daily intakes and user goals.
        ArrayList<BarEntry> entries_intakes = new ArrayList<BarEntry>();
        ArrayList<BarEntry> entries_goals = new ArrayList<>();

        entries_intakes.add(new BarEntry(0f, calories));
        entries_intakes.add(new BarEntry(1f, carbs));
        entries_intakes.add(new BarEntry(2f, fat));
        entries_intakes.add(new BarEntry(3f, protein));
        entries_intakes.add(new BarEntry(4f, price));

        entries_goals.add(new BarEntry(0f, goalEntity.getCalorie()/100));
        entries_goals.add(new BarEntry(1f, goalEntity.getCarbs()/10));
        entries_goals.add(new BarEntry(2f, goalEntity.getFat()/10));
        entries_goals.add(new BarEntry(3f, goalEntity.getProtein()/10));
        entries_goals.add(new BarEntry(4f, goalEntity.getPrice()));
        //end of data input to ArrayList

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
        set2.setColors(R.color.colorPrimary);
        float groupSpace = 0.1f;
        float barSpace = 0.03f;
        float barWidth = 0.42f;

        //set1 = (BarDataSet) graphView.getData().getDataSetByIndex(0);
        set1.setValues(entries_intakes);
        //setting the data into the graph
        BarData data = new BarData(set1, set2);
        data.setBarWidth(barWidth);

        graphView.setData(data);

        //grouping bars
        graphView.groupBars(0f, groupSpace, barSpace);

        graphView.notifyDataSetChanged();
        graphView.invalidate(); // refresh
    }

    //Color setting for stacked bars
    private int[] getColors() {
        //stacksize is three since we will track regular meal times: breakfast, lunch, and dinner
        int stacksize = 3;

        int[] colors = new int[stacksize];

        for (int i = 0; i < colors.length; i++) {
            colors[i] = ColorTemplate.MATERIAL_COLORS[i];
        }

        return colors;
    }
}
