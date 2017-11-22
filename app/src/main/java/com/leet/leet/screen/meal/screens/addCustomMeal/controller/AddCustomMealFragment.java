package com.leet.leet.screen.meal.screens.addCustomMeal.controller;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;

import com.leet.leet.screen.meal.screens.addCustomMeal.model.AddCustomMealModel;
import com.leet.leet.screen.meal.screens.addCustomMeal.view.AddCustomMealView;
import com.leet.leet.screen.meal.screens.addCustomMeal.view.CustomMealInterface;

/**
 * Created by k3vn19 on 11/15/2017.
 *
 * Purpose - This class is to act as the "Controller" for the Add Custom Meal Page.
 */

public class AddCustomMealFragment extends Fragment implements CustomMealInterface.CustomMealListener {

    //declaration of view and model for this controller
    private AddCustomMealView mView;
    private AddCustomMealModel mModel;

    private CustomMealInterface mListener;

    public AddCustomMealFragment() {} //default constructor

    public void setupFragment(CustomMealInterface listener){
        this.mListener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        //initiate the model and view on create
        mModel = new AddCustomMealModel();
        mView = new AddCustomMealView(inflater, container);
        mView.setListener(this); //not sure if needed

        //get root view - not sure what this does exactly though
        return mView.getRootView();
    } //end of onCreateView

    @Override
    //Delegate adding meal to the model using parameters retreived from the view
    public void addMealClick(){
        mModel.addMeal(mView.getMealName(), mView.getPriceVal(), mView.getCalVal(),
        mView.getCarbsVal(), mView.getTotalFatVal(), mView.getSatFatVal(), mView.getProteinVal(),
                mView.getSodiumVal(), mView.getCholesterolVal(), mView.getDietaryFiberVal(),
                mView.getSugarVal());
    }

} //end of class
