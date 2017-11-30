package com.leet.leet.screen.meal.screens.sort.view;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.leet.leet.R;

import java.util.ArrayList;

/**
 * Created by YasuhiraChiba on 2017/11/29.
 */

public class MealSortView implements MealSortDialogViewInterface,AdapterView.OnItemSelectedListener{
    private View mRootView;
    private MealSortDialogViewListener mListener;

    private Spinner priceSpinner;
    private ArrayAdapter<String> priceSpinnerAdapter;



    public MealSortView(LayoutInflater inflater,MealSortDialogViewListener listener) {
        mRootView = inflater.inflate(R.layout.dialog_view_meal_sort, null);
        priceSpinnerAdapter= new ArrayAdapter<String>(inflater.getContext(),R.layout.row_spn);
        this.mListener = listener;
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
        priceSpinner.setOnItemSelectedListener(this);
    }

    @Override
    public View getRootView() {
        return mRootView;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch(adapterView.getId()) {
            case R.id.meal_sort_price_spinner:
                mListener.priceSelected(i);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
