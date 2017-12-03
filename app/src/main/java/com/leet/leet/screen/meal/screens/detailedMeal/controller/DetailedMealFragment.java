package com.leet.leet.screen.meal.screens.detailedMeal.controller;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.leet.leet.common.Enums;
import com.leet.leet.screen.meal.screens.detailedMeal.model.DetailedMealModel;
import com.leet.leet.screen.meal.screens.detailedMeal.view.DetailedMealInterface;
import com.leet.leet.screen.meal.screens.detailedMeal.view.DetailedMealView;
import com.leet.leet.utils.database.entities.menu.MenuEntity;
import com.leet.leet.utils.database.entities.menu.MenuNutritionsEntity;
import com.leet.leet.utils.database.entities.menu.MenuTagsEntity;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by k3vn19 on 11/16/2017.
 *
 * Purpose - This class serves as the "Controller" for the Deatiled Menu Item page.
 */


public class DetailedMealFragment extends Fragment implements DetailedMealInterface.DetailedMealListener {

    //declaration of view and model for this controller
    private DetailedMealView mView;
    private DetailedMealModel mModel;


    public void setupFragment(MenuEntity data){
        mModel = new DetailedMealModel();
        mModel.setMenuEntity(data);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        //initiate the model and view on create
        mView = new DetailedMealView(inflater, container);
        mView.setListener(this); //not sure if needed


        displayNutrition();

        //get root view - not sure what this does exactly though
        return mView.getRootView();
    } //end of onCreateView

    //Purpose - Using the View's setters will set the TextView to display the MenuEntity's nutritional
    //          contents.
    public void displayNutrition(){
        MenuEntity meal = mModel.getMenuEntity();
        mView.setMealName(meal.getName());
        mView.setPrice(meal.getPrice());
        mView.setCalories(meal.getNutritions().getCalories());
        mView.setCarbs(meal.getNutritions().getCarb());
        mView.setTotalFat(meal.getNutritions().getTotalFat());
        mView.setSaturatedFat(meal.getNutritions().getSatFat());
        mView.setProtein(meal.getNutritions().getProtein());
        mView.setSodium(meal.getNutritions().getSodium());
        mView.setCholesterol(meal.getNutritions().getCholesterol());
        mView.setDietaryFiber(meal.getNutritions().getDietaryFiber());
        mView.setSugar(meal.getNutritions().getSugars());
        mView.setServingSize(meal.getNutritions().getServingSize());
        //mView.setAllergens((meal.getNutritions().getAllergens()));

    }

    @Override
    //Delegate adding meal to the model using parameters retreived from the view
    public void addMealClick() {
        //add the meal to the user's history when the add button is pressed.

        //TODO: need to set MealTime   ---11/24  Yasuhira Chiba
        mModel.addMeal(mModel.getMenuEntity(), Enums.MealTime.Breakfast);

        Toast.makeText(getContext(), "Added Meal To History", Toast.LENGTH_SHORT).show();
    }


}
