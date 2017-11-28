package com.leet.leet.screen.statistics.screen.weekly.view;

import android.content.Context;
import android.graphics.Canvas;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.leet.leet.R;

/**
 * Created by YasuhiraChiba on 2017/11/22.
 */

public class StatisticsWeeklyListViewRow extends LinearLayout {

    TextView tvWeek;
    TextView tvData;

    public StatisticsWeeklyListViewRow(Context context)  {
        super(context);
        initialiseView(context);
    }

    public StatisticsWeeklyListViewRow(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialiseView(context);
    }

    public StatisticsWeeklyListViewRow(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initialiseView(context);
    }

    private void initialiseView(Context context) {
        View.inflate(context, R.layout.customview_statistics_weekly_list_view_row, this);
        tvWeek = (TextView)this.findViewById(R.id.statistics_weekly_row_week_tv);
        tvData = (TextView)this.findViewById(R.id.statistics_weekly_row_data);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void setData(String week, String data) {
        tvWeek.setText(week);
        tvData.setText(data);
    }
}
