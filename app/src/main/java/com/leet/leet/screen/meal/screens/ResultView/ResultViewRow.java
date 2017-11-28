package com.leet.leet.screen.meal.screens.ResultView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.leet.leet.R;
import com.leet.leet.utils.database.entities.menu.MenuEntity;

/**
 * On the menu screen, this class represents the "card" for each meal item that appears on the menu.
 */
public class ResultViewRow extends LinearLayout {

    private TextView name;
    private TextView name2;

    public ResultViewRow(Context context) {
        super(context);
        initialiseView(context);
    }

    public ResultViewRow(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialiseView(context);
    }

    public ResultViewRow(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initialiseView(context);
    }

    private void initialiseView(Context context) {
        View.inflate(context, R.layout.customview_menu_search_list_view_row, this);

        name = (TextView)this.findViewById(R.id.name);
        name2 = (TextView)this.findViewById(R.id.name2);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }


    public void setData(MenuEntity data) {
        name.setText(data.getName());
        name2.setText((int) data.getNutritions().getProtein());
    }

}