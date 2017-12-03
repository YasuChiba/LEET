package com.leet.leet.screen.statistics.screen.daily.view;

//import android.support.v4.content.ContextCompat;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.leet.leet.R;
import com.leet.leet.screen.statistics.screen.daily.StatisticsDailyListViewAdapter;
import com.leet.leet.screen.statistics.screen.daily.model.StatisticsDailyModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YasuhiraChiba on 2017/11/05.
 *
 **/

public class StatisticsDailyView implements StatisticsDailyViewInterface {
    private View mRootView;

    private ListView listView;
    StatisticsDailyListViewAdapter adapter;
    private StatisticsDailyListViewHeader header;

    public StatisticsDailyView(LayoutInflater inflater, ViewGroup container) {

        mRootView = inflater.inflate(R.layout.view_statistics_daily, container, false);

        initialize(inflater.getContext());
    }

    private void initialize(Context context) {
        header = new StatisticsDailyListViewHeader(context);
        adapter = new StatisticsDailyListViewAdapter(context);

        listView = (ListView)mRootView.findViewById(R.id.statistics_daily_list_view);
        listView.addHeaderView(header);
        listView.setHeaderDividersEnabled(true);
        listView.setAdapter(adapter);

    }

    @Override
    public View getRootView() {
        return mRootView;
    }

    public void setDataToGraph(float[] price,
                               float[] calories,
                               float[] carbs,
                               float[] fat,
                               float[] protein) {
        header.setDataToGraph(price, calories, carbs, fat, protein);
    }

}
