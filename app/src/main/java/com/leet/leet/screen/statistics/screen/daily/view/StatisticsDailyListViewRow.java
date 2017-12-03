package com.leet.leet.screen.statistics.screen.daily.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.leet.leet.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by BK Hwang on 2017-12-03.
 */

public class StatisticsDailyListViewRow extends LinearLayout {


    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    TextView menu_name;
    TextView tvData;
    TextView price_value;
    TextView cal_value;
    TextView prot_value;
    TextView fat_value;
    TextView carb_value;

    public StatisticsDailyListViewRow(Context context)  {
        super(context);
        initializeView(context);
    }

    public StatisticsDailyListViewRow(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeView(context);
    }

    public StatisticsDailyListViewRow(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initializeView(context);
    }

    private void initializeView(Context context) {
        View.inflate(context, R.layout.customview_statistics_daily_list_view_row_child, this);
        menu_name = (TextView)this.findViewById(R.id.statistics_daily_row_week_tv);

        price_value = (TextView)this.findViewById(R.id.statistics_daily_list_row_price_icon);
        cal_value = (TextView) this.findViewById(R.id.statistics_weekly_list_row_cal_icon);
        prot_value = (TextView) this.findViewById(R.id.statistics_weekly_list_row_prot_icon);
        fat_value = (TextView) this.findViewById(R.id.statistics_weekly_list_row_fat_icon);
        carb_value = (TextView) this.findViewById(R.id.statistics_weekly_list_row_carbs_icon);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void setData(String item,
                        float price,
                        float cal,
                        float prot,
                        float fat,
                        float carb
                        ) {

        menu_name.setText(item);
        price_value.setText((int) price);
        cal_value.setText((int) cal);
        prot_value.setText((int) prot);
        fat_value.setText((int) fat);
        carb_value.setText((int) carb);
    }

    private void prepareListData(String menu,
                                 float price,
                                 float cal,
                                 float prot,
                                 float fat,
                                 float carb) {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        listDataHeader.add("Breakfast");
        listDataHeader.add("Lunch");
        listDataHeader.add("Dinner");
    }
}