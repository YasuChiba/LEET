package com.leet.leet.screen.statistics.screen.daily;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.leet.leet.screen.statistics.screen.daily.model.StatisticsDailyModel;
import com.leet.leet.screen.statistics.screen.weekly.model.SumModel;
import com.leet.leet.screen.statistics.screen.weekly.view.StatisticsWeeklyListViewRow;
import com.leet.leet.utils.DateHelper;
import com.leet.leet.utils.database.entities.menu.MenuEntity;
import com.leet.leet.utils.database.entities.user.UserGoalEntity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.leet.leet.R;

import android.widget.ImageView;
import android.widget.Switch;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

/**
 * Created by YasuhiraChiba on 2017/11/22.
 */

public class StatisticsDailyListViewAdapter extends BaseExpandableListAdapter {

    private Context context;
    public List<String> expandableListTitle;
    public HashMap<String, List<MenuEntity>> expandableListDetail;

    public StatisticsDailyListViewAdapter(Context context){
        this.context = context;

        initList();
    }

    private void initList() {
        expandableListDetail = new HashMap<String, List<MenuEntity>>();
        expandableListTitle = new ArrayList<String>();

    }

    public void setDataToRow(List<MenuEntity> m_breakfast, List<MenuEntity> m_lunch,
                                List<MenuEntity> m_dinner){

        ArrayList<MenuEntity> childList;

        expandableListTitle = new ArrayList<>();
        expandableListTitle.add(
                new String("Breakfast"));
        expandableListTitle.add(
                new String( "Lunch"));
        expandableListTitle.add(
                new String( "Dinner"));

        expandableListDetail = new HashMap<>();

        childList = new ArrayList<>();
        if(!m_breakfast.isEmpty()) {
            for (int i = 0; i < m_breakfast.size(); i++) {
                childList.add(m_breakfast.get(i));
            }
        }

        expandableListDetail.put(expandableListTitle.get(0), childList);

        childList = new ArrayList<>();
        if(!m_lunch.isEmpty()) {
            for (int i = 0; i < m_lunch.size(); i++) {
                childList.add(m_lunch.get(i));
            }
        }

        expandableListDetail.put(expandableListTitle.get(1), childList);

        childList = new ArrayList<>();
        if(!m_dinner.isEmpty()) {
            for (int i = 0; i < m_dinner.size(); i++) {
                childList.add(m_dinner.get(i));
            }
        }
        expandableListDetail.put(expandableListTitle.get(2), childList);
        this.notifyDataSetChanged();
    }

    @Override
    public Object getChild(int listPosition, int expandedListPosition) {
        return this.expandableListDetail.get(this.expandableListTitle.get(listPosition))
                .get(expandedListPosition);
    }

    @Override
    public long getChildId(int listPosition, int expandedListPosition) {
        return expandedListPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        //final String expandedListText = (String) getChild(listPosition, expandedListPosition);

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.customview_statistics_daily_list_view_row_child, null);
        }
        TextView expandedListTextView = (TextView) convertView
                .findViewById(R.id.expandedListItem);
        expandedListTextView.setText(expandableListDetail.get(expandableListTitle.get(groupPosition)).get(childPosition).getName());
        return convertView;
    }

    @Override
    public int getChildrenCount(int listPosition) {
        return this.expandableListDetail.get(this.expandableListTitle.get(listPosition))
                .size();
    }

    @Override
    public Object getGroup(int listPosition) {
        return this.expandableListTitle.get(listPosition);
    }

    @Override
    public int getGroupCount() {
        return this.expandableListTitle.size();
    }

    @Override
    public long getGroupId(int listPosition) {
        return listPosition;
    }

    @Override
    public View getGroupView(int listPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String listTitle = (String) getGroup(listPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.customview_statistics_daily_list_view_row_parent, null);
        }
        TextView listTitleTextView = (TextView) convertView
                .findViewById(R.id.listTitle);
        listTitleTextView.setTypeface(null, Typeface.BOLD);
        listTitleTextView.setText(listTitle);
        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int listPosition, int expandedListPosition) {
        return true;
    }
}