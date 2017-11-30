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
import android.content.Context;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.leet.leet.R;
import com.leet.leet.common.Enums;
import com.leet.leet.common.customViews.NestedListView;
import com.leet.leet.screen.statistics.screen.weekly.StatisticsWeeklyListViewAdapter;
import com.leet.leet.utils.SharedPrefManager;

import org.joda.time.LocalDate;

import java.util.ArrayList;

/**
 * Created by YasuhiraChiba on 2017/11/07.
 */

public class StatisticsWeeklyView implements StatisticsWeeklyViewInterface,
        StatisticsWeeklyViewInterface.StatisticsWeeklyListViewHeaderListener,
        AdapterView.OnItemClickListener {

    private View mRootView;
    private StatisticsWeeklyViewInterface.StatisticsWeeklyViewListner mListner;

    private ListView listView;
    StatisticsWeeklyListViewAdapter adapter;
    private StatisticsWeeklyListViewHeader header;


    public StatisticsWeeklyView(LayoutInflater inflater, ViewGroup container,StatisticsWeeklyViewListner mListner) {

        this.mListner = mListner;
        mRootView = inflater.inflate(R.layout.view_statistics_weekly, container, false);

        initialize(inflater.getContext());
    }

    private void initialize(Context context) {
        header = new StatisticsWeeklyListViewHeader(context);
        adapter = new StatisticsWeeklyListViewAdapter(context);

        listView = (ListView)mRootView.findViewById(R.id.statistics_weekly_list_view);
        listView.addHeaderView(header);
        listView.setHeaderDividersEnabled(true);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

        header.setListner(this);
    }

    @Override
    public View getRootView() {
        return mRootView;
    }

    public void setupListView(Context context, ArrayList<String> week, ArrayList<LocalDate> date, ArrayList<Float> data) {
        adapter.setData(week,date,data);
    }

    public void setDataToGraph(final ArrayList<String> labelList , final ArrayList<Float> val) {
       header.setDataToGraph(labelList,val);
    }

    @Override
    public void buttonTap(Enums.GraphElements elem) {
        mListner.graphUpdateButtonTap(elem);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        mListner.listElementTap(i);
    }
}
