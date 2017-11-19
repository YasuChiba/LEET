package com.leet.leet.screen.meal.screens.ResultView;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.leet.leet.R;
import com.leet.leet.screen.meal.screens.ResultView.ResultViewAdapter;
import com.leet.leet.utils.database.entities.menu.MenuEntity;

import java.util.ArrayList;



public class ResultView implements ResultViewInterface {

    private View mRootView;

    private ListView listView;

    public ResultView(LayoutInflater inflater, ViewGroup container) {
        mRootView = inflater.inflate(R.layout.view_menu_search, container, false);

        initialize();
    }

    private void initialize() {
        listView = (ListView)mRootView.findViewById(R.id.menu_search_list_view);
    }

    public void setupListView(Context context, ArrayList<MenuEntity> data) {
        ResultViewAdapter adapter = new ResultViewAdapter(context);
        adapter.setData(data);
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);
    }

    @Override
    public View getRootView() {
        return mRootView;
    }
}