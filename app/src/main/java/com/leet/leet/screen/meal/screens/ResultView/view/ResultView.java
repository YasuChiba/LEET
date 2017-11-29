 package com.leet.leet.screen.meal.screens.ResultView.view;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.leet.leet.R;
import com.leet.leet.screen.meal.screens.ResultView.ResultViewAdapter;
import com.leet.leet.utils.database.entities.menu.MenuEntity;

import java.util.ArrayList;



public class ResultView  implements ResultViewInterface,AdapterView.OnItemClickListener {

    private View mRootView;

    private ListView listView;

    private ResultViewAdapter listViewAdapter;

    private MealResultViewListener mListner;

    public ResultView(LayoutInflater inflater, ViewGroup container, MealResultViewListener listner) {
        mRootView = inflater.inflate(R.layout.view_menu_search, container, false);
        listViewAdapter = new ResultViewAdapter(inflater.getContext());
        this.mListner = listner;
        initialize();
    }

    private void initialize() {
        listView = (ListView)mRootView.findViewById(R.id.menu_search_list_view);
        listView.setAdapter(listViewAdapter);
        listView.setOnItemClickListener(this);
    }

    public void setupListView(ArrayList<MenuEntity> data) {
        listViewAdapter.setData(data);
        listViewAdapter.notifyDataSetChanged();
    }

    @Override
    public View getRootView() {
        return mRootView;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        mListner.listTap(i);
    }
}
