package com.leet.leet.screen.statistics.screen.weekly.view;

import android.content.Context;
import android.graphics.Canvas;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.leet.leet.R;

/**
 * Created by YasuhiraChiba on 2017/11/22.
 */

public class StatisticsWeeklyListViewRow extends LinearLayout {

    TextView tvWeek;
    TextView tvData;
    ImageView priceIcon;
    ImageView calIcon;
    ImageView protIcon;
    ImageView fatIcon;
    ImageView carbIcon;

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

        priceIcon = this.findViewById(R.id.statistics_weekly_list_row_price_icon);
        calIcon = this.findViewById(R.id.statistics_weekly_list_row_cal_icon);
        protIcon = this.findViewById(R.id.statistics_weekly_list_row_prot_icon);
        fatIcon = this.findViewById(R.id.statistics_weekly_list_row_fat_icon);
        carbIcon = this.findViewById(R.id.statistics_weekly_list_row_carbs_icon);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void setData(String week,
                        float price,
                        float priceGoal,
                        float cal,
                        float calGoal,
                        float prot,
                        float protGoal,
                        float fat,
                        float fatGoal,
                        float carb,
                        float carbGoal) {

        tvWeek.setText(week);
        setIcon(priceIcon,price,priceGoal);
        setIcon(calIcon,cal,calGoal);
        setIcon(protIcon,prot,protGoal);
        setIcon(fatIcon,fat,fatGoal);
        setIcon(carbIcon,carb,carbGoal);
    }

    private void setIcon(ImageView view, float val, float goal) {
        if(val>goal) {
            view.setImageResource(R.mipmap.up_arrow_red);
        } else {
            view.setImageResource(R.mipmap.down_arrow_green);
        }
    }
}
