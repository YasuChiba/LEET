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
 * This will create graph.
 *
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


    /**
     * This will initialize empty graph with xAxis labels
     *
     * @param context
     */
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


        //X-Axis labels
        final ArrayList<String> labels = new ArrayList<>();
        labels.add("Cal");
        labels.add("Carb");
        labels.add("Fat");
        labels.add("Prot");
        labels.add("Price");

        //center the bars at each labels
        XAxis xAxis = graphView.getXAxis();
        xAxis.setCenterAxisLabels(false);

        //place label in correct place
        graphView.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM_INSIDE );

        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return labels.get((int)value);
            }
        });

        //to not make duplicated label
        xAxis.setGranularity(1f);

    }

    /**
     * This will set up values in the graph.
     *
     * @param price        : array of price of breakfast, lunch, and dinner
     * @param calories     : array of calories of breakfast, lunch, and dinner
     * @param carbs        : array of carbs of breakfast, lunch, and dinner
     * @param fat           : array of fat of breakfast, lunch, and dinner
     * @param protein       : array of protein of breakfast, lunch, and dinner
     * @param goalEntity    : user goals
     */
    public void setDataToGraph(float[] price,
                               float[] calories,
                               float[] carbs,
                               float[] fat,
                               float[] protein,
                               UserGoalEntity goalEntity
    )
    {
        //create ArrayList to hold values of intakes and goals.
        ArrayList<BarEntry> entries_intakes = new ArrayList<BarEntry>();
        List<BarEntry> entries_goals = new ArrayList<>();

        entries_intakes.add(new BarEntry(0f, calories));
        entries_intakes.add(new BarEntry(1f, carbs));
        entries_intakes.add(new BarEntry(2f, fat));
        entries_intakes.add(new BarEntry(3f, protein));
        entries_intakes.add(new BarEntry(4f, price));

        entries_goals.add(new BarEntry(0f, goalEntity.getCalorie()));
        entries_goals.add(new BarEntry(1f, goalEntity.getCarbs()));
        entries_goals.add(new BarEntry(2f, goalEntity.getFat()));
        entries_goals.add(new BarEntry(3f, goalEntity.getProtein()));
        entries_goals.add(new BarEntry(4f, goalEntity.getPrice()));

        BarDataSet set1;
        BarDataSet set2 = null;

        //data entry to graph.
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
        float barSpace = 0.03f;
        float barWidth = 0.35f;

        //set1 = (BarDataSet) graphView.getData().getDataSetByIndex(0);
        set1.setValues(entries_intakes);
        //setting the data into the graph
        BarData data = new BarData(set1, set2);
        data.setBarWidth(barWidth);

        graphView.setData(data);

        //grouped bar
        graphView.groupBars(0f, groupSpace, barSpace);

        graphView.invalidate(); // refresh
    }

    /**
     * This sets up the colors of stacked bar
     *
     * @return int[] colors : color values
     */
    private int[] getColors() {
        int stacksize = 3;

        int[] colors = new int[stacksize];

        for (int i = 0; i < colors.length; i++) {
            colors[i] = ColorTemplate.MATERIAL_COLORS[i];
        }

        return colors;
    }
}
