 package com.leet.leet.screen.meal.screens.ResultView.view;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import android.support.v4.app.Fragment;
import com.leet.leet.R;
import com.leet.leet.screen.meal.screens.ResultView.controller.ResultControllerFragment;
import com.leet.leet.screen.meal.screens.ResultView.ResultViewAdapter;
import com.leet.leet.utils.database.entities.menu.MenuEntity;

import java.util.ArrayList;



public class ResultView  implements ResultViewInterface {

    private View mRootView;

    private ListView listView;

    private ResultViewAdapter listViewAdapter;

    public ResultView(LayoutInflater inflater, ViewGroup container, ResultControllerFragment resultControllerFragment) {
        mRootView = inflater.inflate(R.layout.view_menu_search, container, false);
        listViewAdapter = new ResultViewAdapter(inflater.getContext());
        initialize();
    }

    private void initialize() {
        listView = (ListView)mRootView.findViewById(R.id.menu_search_list_view);
        listView.setAdapter(listViewAdapter);
    }

    public void setupListView(ArrayList<MenuEntity> data) {
        listViewAdapter.setData(data);
        listViewAdapter.notifyDataSetChanged();
    }

    @Override
    public View getRootView() {
        return mRootView;
    }
}
