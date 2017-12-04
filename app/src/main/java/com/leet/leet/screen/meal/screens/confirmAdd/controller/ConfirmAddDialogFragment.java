package com.leet.leet.screen.meal.screens.confirmAdd.controller;

import android.app.Activity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;

import com.leet.leet.screen.meal.screens.confirmAdd.ConfirmAddDialogInterface;
import com.leet.leet.screen.meal.screens.confirmAdd.model.ConfirmAddDialogModel;
import com.leet.leet.screen.meal.screens.confirmAdd.view.ConfirmAddDialogViewInterface;
import com.leet.leet.screen.meal.screens.confirmAdd.view.ConfirmAddView;
import com.leet.leet.utils.database.entities.menu.MenuEntity;

/**
 * Created by k3vn19 on 12/3/2017.
 */

public class ConfirmAddDialogFragment extends DialogFragment implements DialogInterface.OnClickListener,ConfirmAddDialogViewInterface.ConfirmAddDialogViewListener {

    ConfirmAddView mView;
    ConfirmAddDialogModel mModel;

    MenuEntity menu; //Menu to add to firebase, is passed into the constructor by detailedMeal

    public void setupFragment(MenuEntity _menu){
        menu = _menu;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        mModel = new ConfirmAddDialogModel();

        final Activity activity = getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        //create view with passed parameters
        mView = new ConfirmAddView(LayoutInflater.from(activity),this);

        builder.setView(mView.getRootView())
                .setTitle("Meal Time Selection")
                .setPositiveButton("Confirm", this)
                .setNegativeButton("Cancel",this);

        return builder.create();
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        if(i==-1){
            //OKButton, add meal to history
            mModel.addMeal(menu, mModel.getMealTimeRange());

            Toast.makeText(getContext(), "Added Meal To History", Toast.LENGTH_SHORT).show();
        } else if(i==-2){
            //cancelButton
        }
    }

    @Override
    public void mealTimeSelected(int index) {
        mModel.setMealTimeRange(index);
    }
} //end of class
