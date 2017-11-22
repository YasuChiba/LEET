package com.leet.leet.screen.meal.screens.addCustomMeal.controller;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.leet.leet.screen.meal.screens.addCustomMeal.model.AddCustomMealModel;
import com.leet.leet.screen.meal.screens.addCustomMeal.view.AddCustomMealView;
import com.leet.leet.screen.meal.screens.addCustomMeal.view.CustomMealInterface;

import static java.security.AccessController.getContext;

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

        //validate user input
        boolean validated = validateFeilds();

        if (validated) {
            mModel.addMeal(mView.getMealName(), mView.getPriceVal(), mView.getCalVal(),
                    mView.getCarbsVal(), mView.getTotalFatVal(), mView.getSatFatVal(), mView.getProteinVal(),
                    mView.getSodiumVal(), mView.getCholesterolVal(), mView.getDietaryFiberVal(),
                    mView.getSugarVal());
            clearFields();

            //Toast telling the user meal has been added
            Toast.makeText(getContext(), "Created Meal", Toast.LENGTH_SHORT).show();

        }
        else {
            //Toast telling the user they have invalid input
            Toast.makeText(getContext(), "Invalid Input", Toast.LENGTH_SHORT).show();
        }
    } //end of addMealClick()

    /**
     * Purpose - Validate the user input for adding custom meals
     * @return true if entries are valid, false otherwise
     */
    public boolean validateFeilds(){
        //make sure there is some name
        if(mView.getMealName().length() == 0){
            return false;
        }
        //make sure no entries are negative
        else if(mView.getPriceVal() < 0){return false;}
        else if(mView.getCalVal() < 0){ return false;}
        else if(mView.getCarbsVal() < 0){ return false;}
        else if(mView.getTotalFatVal() < 0){ return false;}
        else if(mView.getSatFatVal()< 0){ return false;}
        else if(mView.getProteinVal() < 0){ return false;}
        else if(mView.getSodiumVal() < 0){ return false;}
        else if(mView.getSugarVal() < 0){ return false;}
        else if(mView.getCholesterolVal() < 0){ return false;}
        else if(mView.getDietaryFiberVal() < 0){ return false;}

        return true;
    }


    /**
     * Purpose - After the user has added meal to the database, clear the TextViews
     *           for future entries.
     */
    public void clearFields(){
        //clear the fields so the user knows they can add another meal
        mView.setNameVal("");
        mView.setPriceVal("");
        mView.setCalVal("");
        mView.setCarbsVal("");
        mView.setTotalFatVal("");
        mView.setSatFatVal("");
        mView.setProteinVal("");
        mView.setSodiumVal("");
        mView.setSugarVal("");
        mView.setCholesterolVal("");
        mView.setFiberVal("");
    }

} //end of class
