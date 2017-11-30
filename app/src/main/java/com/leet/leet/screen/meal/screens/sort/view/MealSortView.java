package com.leet.leet.screen.meal.screens.sort.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.leet.leet.R;
import com.leet.leet.screen.meal.screens.ResultView.view.ResultViewInterface;

import java.util.ArrayList;

/**
 * Created by YasuhiraChiba on 2017/11/29.
 */

public class MealSortView implements MealSortDialogViewInterface{
    private View mRootView;

    private Spinner priceSpinner;
    private ArrayAdapter<String> priceSpinnerAdapter;



    public MealSortView(LayoutInflater inflater) {
        mRootView = inflater.inflate(R.layout.dialog_view_meal_sort, null);
        priceSpinnerAdapter= new ArrayAdapter<String>(inflater.getContext(),R.layout.row_spn);

        initialize();
    }

    private void initialize() {
        priceSpinner = mRootView.findViewById(R.id.meal_sort_price_spinner);
        priceSpinnerAdapter.setDropDownViewResource(R.layout.row_spn_dropdown);
        priceSpinner.setAdapter(priceSpinnerAdapter);
    }

    public void setupSpinners(ArrayList<String> priceValues) {
        priceSpinnerAdapter.addAll(priceValues);
        priceSpinnerAdapter.notifyDataSetChanged();
    }

    @Override
    public View getRootView() {
        return mRootView;
    }
}
