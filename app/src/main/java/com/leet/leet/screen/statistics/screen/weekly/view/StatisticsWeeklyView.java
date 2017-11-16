package com.leet.leet.screen.statistics.screen.weekly.view;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.leet.leet.R;
import com.leet.leet.common.Enums;
import com.leet.leet.utils.SharedPrefManager;

import java.util.ArrayList;

/**
 * Created by YasuhiraChiba on 2017/11/07.
 */

public class StatisticsWeeklyView implements StatisticsWeeklyViewInterface, View.OnClickListener {

    private View mRootView;
    private StatisticsWeeklyViewInterface.StatisticsWeeklyViewListner mListner;

    private LineChart graphView;
    private ConstraintLayout constraintLayout;
    private LinearLayout graphButtonContainer;
    private Button btGraphCalorie;
    private Button btGraphPrice;
    private Button btGraphProtein;
    private Button btGraphFat;
    private Button btGraphCarb;

    public StatisticsWeeklyView(LayoutInflater inflater, ViewGroup container,StatisticsWeeklyViewListner mListner) {

        mRootView = inflater.inflate(R.layout.view_statistics_weekly, container, false);
        this.mListner = mListner;
        initialize();
    }

    private void initialize() {
        constraintLayout = (ConstraintLayout)mRootView.findViewById(R.id.statistics_weekly_constraintlayout);
        graphButtonContainer = (LinearLayout)mRootView.findViewById(R.id.statistics_weekly_graph_button_container);
        btGraphCalorie = (Button)mRootView.findViewById(R.id.statistics_weekly_calorie_bt);
        btGraphPrice = (Button)mRootView.findViewById(R.id.statistics_weekly_price_bt);
        btGraphProtein = (Button)mRootView.findViewById(R.id.statistics_weekly_protein_bt);
        btGraphFat = (Button)mRootView.findViewById(R.id.statistics_weekly_fats_bt);
        btGraphCarb = (Button)mRootView.findViewById(R.id.statistics_weekly_carbs_bt);
        graphView = (LineChart)mRootView.findViewById(R.id.stats_weekly_graph);

        btGraphCalorie.setOnClickListener(this);
        btGraphPrice.setOnClickListener(this);
        btGraphProtein.setOnClickListener(this);
        btGraphFat.setOnClickListener(this);
        btGraphCarb.setOnClickListener(this);

        ConstraintSet set = new ConstraintSet();
        set.clone(constraintLayout);
        set.constrainHeight(R.id.statistics_weekly_graph_button_container, SharedPrefManager.loadRealDisplaySizeX()/6);
        set.applyTo(constraintLayout);


        //------------SETUP GRAPH----------------------
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

    @Override
    public void onClick(View view) {

        Enums.GraphElements elem = Enums.GraphElements.Calorie;
        switch (view.getId()) {
            case R.id.statistics_weekly_calorie_bt:
                elem = Enums.GraphElements.Calorie;
                break;
            case R.id.statistics_weekly_price_bt:
                elem = Enums.GraphElements.Price;
                break;
            case R.id.statistics_weekly_protein_bt:
                elem = Enums.GraphElements.Protein;
                break;
            case R.id.statistics_weekly_fats_bt:
                elem = Enums.GraphElements.Fat;
                break;
            case R.id.statistics_weekly_carbs_bt:
                elem = Enums.GraphElements.Carb;
                break;
        }
        mListner.graphUpdateButtonTap(elem);
    }
}
