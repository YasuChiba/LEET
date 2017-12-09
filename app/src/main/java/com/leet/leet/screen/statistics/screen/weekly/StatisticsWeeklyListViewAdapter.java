package com.leet.leet.screen.statistics.screen.weekly;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.leet.leet.screen.statistics.screen.weekly.model.SumModel;
import com.leet.leet.screen.statistics.screen.weekly.view.StatisticsWeeklyListViewRow;
import com.leet.leet.utils.DateHelper;
import com.leet.leet.utils.database.entities.user.UserGoalEntity;

import org.joda.time.LocalDate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by YasuhiraChiba on 2017/11/22.
 */

//adapter class for listview in stats weekly
public class StatisticsWeeklyListViewAdapter extends BaseAdapter {

    private Context context;

    private ArrayList<SumModel> data;
    private UserGoalEntity goal;


    public StatisticsWeeklyListViewAdapter(Context context) {
        this.context = context;

        data = new ArrayList<>();
    }


    //set data to listview
    public void setData(ArrayList<SumModel> data,
                        UserGoalEntity goal) {

        this.data = (ArrayList<SumModel>) data.clone();
        this.goal = goal;
        Collections.reverse(this.data);

        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    //create view for each row
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        String week = DateHelper.getWeekByString(DateHelper.getStringByDate(data.get(i).day)).getString();

        if(view == null) {
            StatisticsWeeklyListViewRow row = new StatisticsWeeklyListViewRow(context);
            row.setData(week,
                    data.get(i).price,goal.getPrice(),
                    data.get(i).calorie,goal.getCalorie(),
                    data.get(i).protein,goal.getProtein(),
                    data.get(i).fat,goal.getFat(),
                    data.get(i).carbs,goal.getCarbs());
            return row;
        } else {
            ((StatisticsWeeklyListViewRow)view).setData(week,
                    data.get(i).price,goal.getPrice(),
                    data.get(i).calorie,goal.getCalorie(),
                    data.get(i).protein,goal.getProtein(),
                    data.get(i).fat,goal.getFat(),
                    data.get(i).carbs,goal.getCarbs());
            return view;
        }
    }
}
