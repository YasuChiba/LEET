 package com.leet.leet.screen.meal.screens.ResultView.view;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.leet.leet.R;
import com.leet.leet.common.Enums;
import com.leet.leet.screen.meal.screens.ResultView.ResultViewListAdapter;
import com.leet.leet.utils.database.entities.menu.MenuEntity;

import java.util.ArrayList;



public class ResultView  implements ResultViewInterface,ResultViewInterface.MealResultHeaderListener,AdapterView.OnItemClickListener {

    private View mRootView;

    private ListView listView;
    private MealResultViewListHeader header;

    private ResultViewListAdapter listViewAdapter;
    private MealResultViewListener mListner;

    public ResultView(LayoutInflater inflater, ViewGroup container, MealResultViewListener listner) {
        mRootView = inflater.inflate(R.layout.view_menu_result, container, false);
        listViewAdapter = new ResultViewListAdapter(inflater.getContext());
        header = new MealResultViewListHeader(inflater.getContext());

        this.mListner = listner;
        initialize();
    }

    private void initialize() {
        listView = (ListView)mRootView.findViewById(R.id.menu_search_list_view);
        listView.addHeaderView(header);
        listView.setAdapter(listViewAdapter);
        listView.setOnItemClickListener(this);

    }

    public void setupListView(ArrayList<MenuEntity> data) {
        listViewAdapter.setData(data);
    }

    public void setupMealTimeSpinner(ArrayList<String> data, int defualtIndex) {
        header.setupMealTimeSpinner(data,defualtIndex,this);
    }

    @Override
    public View getRootView() {
        return mRootView;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        mListner.listTap(i);
    }

    @Override
    public void mealTimeSelected(Enums.MealTime time) {
        mListner.mealTimeSelected(time);
    }
}
