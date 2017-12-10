package com.leet.leet.screen.statistics.screen.daily;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.leet.leet.utils.database.entities.menu.MenuEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.leet.leet.R;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.BaseExpandableListAdapter;

/**
 * Created by Pyeong Kyu Hwang on 12/02/2017.
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

    /**
     * Setting up Data for Expenable List View
     *
     *
     * @param m_breakfast : list of breakfast menu that user had
     * @param m_lunch     : list of lunch menu that user had
     * @param m_dinner     : list of dinner menu that user had
     */
    public void setDataToRow(List<MenuEntity> m_breakfast, List<MenuEntity> m_lunch,
                                List<MenuEntity> m_dinner){

        ArrayList<MenuEntity> childList;

        //initialize the parent list with hard codes since the app only tracks regular meal time
        expandableListTitle = new ArrayList<>();
        expandableListTitle.add(
                new String("Breakfast"));
        expandableListTitle.add(
                new String( "Lunch"));
        expandableListTitle.add(
                new String( "Dinner"));

        //initialize hashmap to hold child(menus) to like with parent(title) list.
        expandableListDetail = new HashMap<>();

        //enlist Breakfast menus in hashmap
        childList = new ArrayList<>();
        if(!m_breakfast.isEmpty()) {
            for (int i = 0; i < m_breakfast.size(); i++) {
                childList.add(m_breakfast.get(i));
            }
        }
        //link the hashmap of breakfast meals to breakfast tab
        expandableListDetail.put(expandableListTitle.get(0), childList);

        //enlist lunch menus in hashmap
        childList = new ArrayList<>();
        if(!m_lunch.isEmpty()) {
            for (int i = 0; i < m_lunch.size(); i++) {
                childList.add(m_lunch.get(i));
            }
        }
        //link the hashmap of breakfast meals to lunch tab
        expandableListDetail.put(expandableListTitle.get(1), childList);

        //enlist dinner menus in hashmap
        childList = new ArrayList<>();
        if(!m_dinner.isEmpty()) {
            for (int i = 0; i < m_dinner.size(); i++) {
                childList.add(m_dinner.get(i));
            }
        }
        //link the hashmap of breakfast meals to dinner tab
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

    /**
     * @param listPosition : list position
     * @param isExpanded   : indicates boolean of expanded or not
     * @param convertView  : change the view
     * @param parent        : titles(breakfast, lunch, dinner)
     * @return View
     */
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

    /**
     * This enables to menu to be selected
     *
     * @param listPosition
     * @param expandedListPosition
     * @return boolean
     */
    @Override
    public boolean isChildSelectable(int listPosition, int expandedListPosition) {
        return true;
    }
}