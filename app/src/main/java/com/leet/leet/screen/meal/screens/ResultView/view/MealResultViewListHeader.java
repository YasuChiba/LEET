package com.leet.leet.screen.meal.screens.ResultView.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.leet.leet.R;
import com.leet.leet.common.Enums;

import java.util.ArrayList;

/**
 * Created by YasuhiraChiba on 2017/11/29.
 */

public class MealResultViewListHeader extends LinearLayout implements AdapterView.OnItemSelectedListener{

    private Spinner mealTimeSpinner;
    private ArrayAdapter<String> mealTimeSpinnerAdapter;
    ResultViewInterface.MealResultHeaderListener listener;

    public MealResultViewListHeader(Context context) {
        super(context);
        initializeView(context);
    }

    public MealResultViewListHeader(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initializeView(context);
    }

    public MealResultViewListHeader(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeView(context);
    }

    private void initializeView(Context context) {
        View.inflate(context, R.layout.customview_menu_result_list_view_header, this);
        mealTimeSpinner = (Spinner)this.findViewById(R.id.meal_result_list_header_mealtime_spinner);
        mealTimeSpinnerAdapter= new ArrayAdapter<String>(context,R.layout.row_spn);
        mealTimeSpinnerAdapter.setDropDownViewResource(R.layout.row_spn_dropdown);
        mealTimeSpinner.setAdapter(mealTimeSpinnerAdapter);
    }

    public void setupMealTimeSpinner(ArrayList<String> data, int defualtIndex,ResultViewInterface.MealResultHeaderListener listener) {
        this.listener = listener;

        mealTimeSpinnerAdapter.addAll(data);
        mealTimeSpinnerAdapter.notifyDataSetChanged();
        mealTimeSpinner.setSelection(defualtIndex);
        mealTimeSpinner.setOnItemSelectedListener(this);
    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(i==0) {
            listener.mealTimeSelected(Enums.MealTime.Breakfast);

        } else if(i==1) {
            listener.mealTimeSelected(Enums.MealTime.Lunch);
        } else if(i==2) {
            listener.mealTimeSelected(Enums.MealTime.Dinner);
        } else if (i == 3) {
            listener.mealTimeSelected(Enums.MealTime.All);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
