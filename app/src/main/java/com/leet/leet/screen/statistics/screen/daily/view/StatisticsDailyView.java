package com.leet.leet.screen.statistics.screen.daily.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.leet.leet.R;
import com.leet.leet.common.Enums;
import com.leet.leet.screen.statistics.screen.daily.StatisticsDailyListViewAdapter;
import com.leet.leet.utils.database.entities.menu.MenuEntity;
import com.leet.leet.utils.database.entities.user.UserGoalEntity;

import java.util.List;

/**
 * Created by YasuhiraChiba on 2017/11/05.
 *
 **/

public class StatisticsDailyView implements StatisticsDailyViewInterface
, ExpandableListView.OnChildClickListener{
    private View rootView;
    private ExpandableListView expListView;
    private StatisticsDailyViewListener mListener;

    private StatisticsDailyListViewAdapter adapter;
    private StatisticsDailyListViewHeader header;



    public StatisticsDailyView(LayoutInflater inflater, ViewGroup container,StatisticsDailyViewListener listener) {
        this.mListener = listener;
        rootView = inflater.inflate(R.layout.view_statistics_daily, container, false);
        initialize(inflater.getContext());
    }

    private void initialize(Context context) {
        //calling header to draw graph
        header = new StatisticsDailyListViewHeader(context);
        //calling adapter to draw expandablelistview
        adapter = new StatisticsDailyListViewAdapter(context);

        expListView = (ExpandableListView) rootView.findViewById(R.id.expandableListView);
        expListView.addHeaderView(header);
        expListView.setHeaderDividersEnabled(true);
        expListView.setAdapter(adapter);
        expListView.setOnChildClickListener(this);
    }

    @Override
    public View getRootView() {
        return rootView;
    }

    //call setDataToGraph function in StatisticsDailyListViewHeader to set data in the graph.
    public void setDataToGraph(float[] price,
                               float[] calories,
                               float[] carbs,
                               float[] fat,
                               float[] protein,
                               UserGoalEntity goalEntity) {
        header.setDataToGraph(price, calories, carbs, fat, protein, goalEntity);
    }


    public void setDataToRow(List<MenuEntity> m_breakfast, List<MenuEntity> m_lunch, List<MenuEntity> m_dinner) {
        adapter.setDataToRow(m_breakfast, m_lunch, m_dinner);

    }

    //handles tabs to react on click
    @Override
    public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {

        Enums.MealTime time = Enums.MealTime.Breakfast;
        if(i==0) {
            time = Enums.MealTime.Breakfast;
        } else if(i == 1) {
            time = Enums.MealTime.Lunch;
        } else {
            time = Enums.MealTime.Dinner;
        }
        mListener.elementTapped(time,i1);
        return false;
    }
}
