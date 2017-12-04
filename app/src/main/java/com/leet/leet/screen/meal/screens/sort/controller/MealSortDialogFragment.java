package com.leet.leet.screen.meal.screens.sort.controller;



import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.support.v4.app.DialogFragment;

import com.leet.leet.R;
import com.leet.leet.screen.meal.screens.sort.MealSortDialogInterface;
import com.leet.leet.screen.meal.screens.sort.model.MealSortDialogModel;
import com.leet.leet.screen.meal.screens.sort.view.MealSortDialogViewInterface;
import com.leet.leet.screen.meal.screens.sort.view.MealSortView;

/**
 * Created by YasuhiraChiba on 2017/11/29.
 * Implemented by k3vn19.
 */

public class MealSortDialogFragment extends DialogFragment implements DialogInterface.OnClickListener, MealSortDialogViewInterface.MealSortDialogViewListener{

    MealSortView mView;
    MealSortDialogModel mModel;

    private int price_Range;
    private int calorie_Range;
    private int carbs_Range;
    private int totalFat_Range;
    private int satFat_Range;
    private int protein_Range;
    private int sodium_Range;
    private int cholesterol_Range;
    private int fiber_Range;
    private int sugar_Range;

    //spinners to be instantiated

    private MealSortDialogInterface mListener;

    //assign values to spinners, integers
    public void setupFragment(MealSortDialogInterface listener, int priceRange, int calorieRange,
                              int carbsRange, int totalFatRange, int satFatRange, int proteinRange,
                              int sodiumRange, int cholRange, int fiberRange, int sugarRange) {
        this.mListener = listener;
        price_Range = priceRange;
        calorie_Range = calorieRange;
        protein_Range = proteinRange;
        carbs_Range = carbsRange;
        totalFat_Range = totalFatRange;
        satFat_Range = satFatRange;
        sodium_Range = sodiumRange;
        cholesterol_Range = cholRange;
        fiber_Range = fiberRange;
        sugar_Range = sugarRange;

    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        mModel = new MealSortDialogModel();

        final Activity activity = getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        //create view with passed parameters
        mView = new MealSortView(LayoutInflater.from(activity),this, price_Range, calorie_Range,
                carbs_Range, totalFat_Range, satFat_Range, protein_Range, sodium_Range,
                cholesterol_Range, fiber_Range, sugar_Range);

        builder.setView(mView.getRootView())
                .setTitle("Filter")
                .setPositiveButton("Apply", this)
                .setNegativeButton("Cancel",this);


        initialize();

        return builder.create();

    }

    public void initialize(){

    }


    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        if(i==-1){
            //OKButton
            mListener.dialogOkButtonTap(mModel.getPriceRange(), mModel.getCalorieRange(), mModel.getProteinRange(),
                    mModel.getCarbsRange(), mModel. getTotalFatRange(), mModel.getSatFatRange(), mModel.getSodiumRange(),
                    mModel.getCholesterolRange(), mModel.getFiberRange(), mModel.getSugarRange());

        } else if(i==-2){
            //cancelButton
        }
    }

    @Override
    public void priceSelected(int index) {
        mModel.setPriceRange(index);
    }
    @Override
    public void calorieSelected(int index) {
        mModel.setCalorieRange(index);
    }
    @Override
    public void carbsSelected(int index) {
        mModel.setCarbsRange(index);
    }
    @Override
    public void totalFatSelected(int index) {
        mModel.setTotalFatRange(index);
    }
    @Override
    public void satFatSelected(int index) {
        mModel.setSatFatRange(index);
    }
    @Override
    public void proteinSelected(int index) {
        mModel.setProteinRange(index);
    }
    @Override
    public void sodiumSelected(int index) {
        mModel.setSodiumRange(index);
    }
    @Override
    public void cholesterolSelected(int index) {
        mModel.setCholesterolRange(index);
    }
    @Override
    public void fiberSelected(int index) {
        mModel.setFiberRange(index);
    }
    @Override
    public void sugarSelected(int index) {
        mModel.setSugarRange(index);
    }


}
