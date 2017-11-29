package com.leet.leet.screen.meal.screens.ResultView;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.leet.leet.screen.meal.screens.ResultView.view.ResultViewRow;
import com.leet.leet.utils.database.entities.menu.MenuEntity;

import java.util.ArrayList;


public class ResultViewListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<MenuEntity> data = new ArrayList<>();

    public ResultViewListAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<MenuEntity> data) {
        this.data = data;
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

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null) {
            ResultViewRow row = new ResultViewRow(context);
            row.setData(data.get(i));
            return row;
        } else {
            ((ResultViewRow)view).setData(data.get(i));
            return view;
        }
    }
}