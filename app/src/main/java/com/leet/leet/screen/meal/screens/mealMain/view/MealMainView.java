package com.leet.leet.screen.meal.screens.mealMain.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.leet.leet.R;

/**
 * Created by YasuhiraChiba on 2017/11/16.
 */

public class MealMainView implements MealMainViewInterface, View.OnClickListener{

    private View mRootView;
    private MealMainViewListner mListner;
    Button sixtyFour;

    public MealMainView(LayoutInflater inflater, ViewGroup container, MealMainViewListner listner) {
        this.mListner = listner;
        mRootView = inflater.inflate(R.layout.view_meal_main, container, false);
        initialize();
    }

    private void initialize() {

        sixtyFour = (Button)mRootView.findViewById(R.id.sixtyFour);

        sixtyFour.setOnClickListener(this);
    }

    @Override
    public View getRootView() {
        return mRootView;
    }


    @Override
    public void onClick(View view) {

        //pass the button click event to MealMainFragment.
        mListner.buttonTap();
    }
}
