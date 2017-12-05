package com.leet.leet.screen.meal.screens.sortMeal.controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leet.leet.screen.meal.screens.sortMeal.model.SortMealModel;
import com.leet.leet.screen.meal.screens.sortMeal.view.SortMealInterface;
import com.leet.leet.screen.meal.screens.sortMeal.view.SortMealView;

/**
 * Created by k3vn19 on 11/19/2017.
 *
 * This class acts as the Controller for the Sort Menu Options Page.
 *
 * THIS CLASS IS NO LONGER BEING USED
 */

public class SortMealFragment extends Fragment implements SortMealInterface.SortMealListener {

    //declaration of view and model for this controller
    private SortMealView mView;
    private SortMealModel mModel;

    private SortMealInterface mListener;

    public SortMealFragment() {
    } //default constructor

    public void setupFragment(SortMealInterface listener) {
        this.mListener = listener;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //initiate the model and view on create
        mModel = new SortMealModel();
        mView = new SortMealView(inflater, container);
        mView.setListener(this); //not sure if needed

        //get root view - not sure what this does exactly though
        return mView.getRootView();

    } //end of onCreateView

    @Override
    //Delegate sorting to the model using parameters from the view
    public void sort(){
        mModel.sortMenu(mView.getPriceMin(), mView.getPriceMax(), mView.getCaloriesMin(),
                mView.getCaloriesMax(), mView.getCarbsMin(), mView.getCarbsMax(),
                mView.getFatMin(), mView.getFatMax(), mView.getProteinMin(), mView.getProteinMax(),
                mView.getSugarMin(), mView.getSugarMax());
    }

} //end of class


