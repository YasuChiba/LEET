package com.leet.leet.screen.statistics.screen.weekly.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.leet.leet.R;
import com.leet.leet.common.Enums;
import com.leet.leet.utils.SharedPrefManager;

import java.util.ArrayList;

/**
 * Created by YasuhiraChiba on 2017/11/22.
 */

//header for weekly page. This header contains graph.
public class StatisticsWeeklyListViewHeader extends LinearLayout implements View.OnClickListener {


    private LineChart graphView;
    private LinearLayout graphButtonContainer;
    private Button btGraphCalorie;
    private Button btGraphPrice;
    private Button btGraphProtein;
    private Button btGraphFat;
    private Button btGraphCarb;

    private StatisticsWeeklyViewInterface.StatisticsWeeklyListViewHeaderListener mListner;


    public StatisticsWeeklyListViewHeader(Context context) {
        super(context);
        initialiseView(context);
    }

    public StatisticsWeeklyListViewHeader(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialiseView(context);
    }

    public StatisticsWeeklyListViewHeader(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialiseView(context);
    }

    private void initialiseView(Context context) {
        View.inflate(context, R.layout.customview_statistics_weekly_list_view_header, this);

        graphButtonContainer = (LinearLayout)this.findViewById(R.id.statistics_weekly_graph_button_container);
        btGraphCalorie = (Button)this.findViewById(R.id.statistics_weekly_calorie_bt);
        btGraphPrice = (Button)this.findViewById(R.id.statistics_weekly_price_bt);
        btGraphProtein = (Button)this.findViewById(R.id.statistics_weekly_protein_bt);
        btGraphFat = (Button)this.findViewById(R.id.statistics_weekly_fats_bt);
        btGraphCarb = (Button)this.findViewById(R.id.statistics_weekly_carbs_bt);
        graphView = (LineChart)this.findViewById(R.id.stats_weekly_graph);

        btGraphCalorie.setOnClickListener(this);
        btGraphPrice.setOnClickListener(this);
        btGraphProtein.setOnClickListener(this);
        btGraphFat.setOnClickListener(this);
        btGraphCarb.setOnClickListener(this);

        graphButtonContainer.setLayoutParams(new LinearLayout.LayoutParams(
                SharedPrefManager.loadRealDisplaySizeX(),
                SharedPrefManager.loadRealDisplaySizeX()/10));


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
        graphView.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
    }

    public void setListner(StatisticsWeeklyViewInterface.StatisticsWeeklyListViewHeaderListener listener) {
        this.mListner = listener;
    }

    public void setDataToGraph(final ArrayList<String> labelList , final ArrayList<Float> val, float goal) {
        ArrayList<Float> tmp = new ArrayList<>();

        //test data
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

        YAxis yAxis = graphView.getAxisLeft();
        yAxis.removeAllLimitLines();
        yAxis.addLimitLine(new LimitLine(goal, "Goal"));

        graphView.notifyDataSetChanged();
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
        mListner.buttonTap(elem);
    }



}
