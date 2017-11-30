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
import com.leet.leet.screen.meal.screens.sort.model.MealSortDialogModel;
import com.leet.leet.screen.meal.screens.sort.view.MealSortDialogViewInterface;
import com.leet.leet.screen.meal.screens.sort.view.MealSortView;

/**
 * Created by YasuhiraChiba on 2017/11/29.
 */

public class MealSortDialogFragment extends DialogFragment implements DialogInterface.OnClickListener{

    MealSortView mView;
    MealSortDialogModel mModel;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        mModel = new MealSortDialogModel();

        final Activity activity = getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        mView = new MealSortView(LayoutInflater.from(activity));
        mView.setupSpinners(mModel.getPriceArray());

        builder.setView(mView.getRootView())
                .setTitle("Fragment Dialog")
                .setPositiveButton("OK", this)
                .setNegativeButton("Cancel",this);

        return builder.create();
    }


    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        if(i==0){

        } else {

        }
    }
}
