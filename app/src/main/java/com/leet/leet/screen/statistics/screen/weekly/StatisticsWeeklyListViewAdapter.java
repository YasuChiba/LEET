package com.leet.leet.screen.statistics.screen.weekly;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.leet.leet.screen.statistics.screen.weekly.view.StatisticsWeeklyListViewRow;

import org.joda.time.LocalDate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by YasuhiraChiba on 2017/11/22.
 */

public class StatisticsWeeklyListViewAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<LocalDate> date;
    private ArrayList<String> week;
    private ArrayList<Float> data;


    public StatisticsWeeklyListViewAdapter(Context context) {
        this.context = context;

        week = new ArrayList<>();
        data = new ArrayList<>();
    }

    public void setData(ArrayList<String> week,ArrayList<LocalDate> date,ArrayList<Float> data) {
        Collections.reverse(data);
        Collections.reverse(date);
        Collections.reverse(week);

        this.date = date;
        this.week = week;
        this.data = data;
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return week.size();
    }

    @Override
    public Object getItem(int i) {
        return week.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null) {
            StatisticsWeeklyListViewRow row = new StatisticsWeeklyListViewRow(context);
            row.setData(week.get(i),"Price : " + data.get(i));
            return row;
        } else {
            ((StatisticsWeeklyListViewRow)view).setData(week.get(i),"Price : "+data.get(i));
            return view;
        }
    }
}
