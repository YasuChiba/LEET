package com.leet.leet.screen.statistics.screen.daily;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.leet.leet.screen.statistics.screen.weekly.model.SumModel;
import com.leet.leet.screen.statistics.screen.weekly.view.StatisticsWeeklyListViewRow;
import com.leet.leet.utils.DateHelper;
import com.leet.leet.utils.database.entities.user.UserGoalEntity;

import org.joda.time.LocalDate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.leet.leet.R;

/**
 * Created by YasuhiraChiba on 2017/11/22.
 */

public class StatisticsDailyListViewAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listDataChild;

    private ArrayList<SumModel> data;
    private UserGoalEntity goal;


    public StatisticsDailyListViewAdapter(Context context) {
        this.context = context;
        this.listDataHeader = new ArrayList<String>();
        this.listDataChild =  new HashMap<String, List<String>>();

        data = new ArrayList<>();
    }


    public void setData() {

        this.data = (ArrayList<SumModel>) data.clone();
        this.goal = goal;


        this.notifyDataSetChanged();
    }


    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this.listDataChild.get(this.listDataHeader.get(groupPosition))
                .get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {

        return convertView;
    }


    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final String childText = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.customview_statistics_daily_list_view_row_child, null);
        }

        TextView txtListChild = (TextView) convertView
                .findViewById(R.id.statistics_daily_row_week_tv);

        txtListChild.setText(childText);
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.listDataChild.get(this.listDataHeader.get(groupPosition))
                .size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this.listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }


    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }


}