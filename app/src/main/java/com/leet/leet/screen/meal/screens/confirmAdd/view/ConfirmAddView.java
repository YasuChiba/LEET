package com.leet.leet.screen.meal.screens.confirmAdd.view;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.leet.leet.R;
import com.leet.leet.utils.database.entities.menu.MenuEntity;

/**
 * Created by k3vn19 on 12/3/2017.
 */

public class ConfirmAddView implements ConfirmAddDialogViewInterface,AdapterView.OnItemSelectedListener {

    private View mRootView;
    private ConfirmAddDialogViewListener mListener;

    private Spinner mealTimeSpinner;

    /**
     * Constructor
     * @param inflater
     * @param listener
     */
    public ConfirmAddView(LayoutInflater inflater, ConfirmAddDialogViewListener listener){
        mRootView = inflater.inflate(R.layout.dialog_view_confirm_add, null);
        this.mListener = listener;

        initialize();
    }

    /**
     * Purpose - Initialiaze the spinner  and set the the default to lunch. Then set a listener
     *           to the spinner. When the spinner is then changed then onItemSeletected() is called.
     */
    private void initialize() {
        mealTimeSpinner = mRootView.findViewById(R.id.meal_time_spinner);
        mealTimeSpinner.setSelection(1); //default to lunch
        mealTimeSpinner.setOnItemSelectedListener(this);
    }

    @Override
    public View getRootView() {
        return mRootView;
    }

    @Override
    /**
     * Purpose - This method is called when a value in the spinner is changed.
     */
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch (adapterView.getId()) {
            case R.id.meal_time_spinner:
                mListener.mealTimeSelected(i);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

} //end of class
