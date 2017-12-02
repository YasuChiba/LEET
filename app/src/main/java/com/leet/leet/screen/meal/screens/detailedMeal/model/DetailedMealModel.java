package com.leet.leet.screen.meal.screens.detailedMeal.model;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.leet.leet.common.Enums;
import com.leet.leet.utils.database.FirebaseDBUserDataHelper;
import com.leet.leet.utils.database.entities.menu.MenuEntity;

import org.joda.time.LocalDate;

import android.widget.Toast;


/**
 * Created by k3vn19 on 11/16/2017.
 *
 * Purpose - This class serves as the "Model" for the Detailed Menu Page.
 */

public class DetailedMealModel {

    private MenuEntity menu;
    public DetailedMealModel(){} //default constructor

    //Purpose - Once the user has decided to eat a meal, they will add it to their history.
    //          This method will add the MenuEntity to the profile's history.
    public void addMeal(MenuEntity meal, Enums.MealTime time){

        //add the meal to the database
        FirebaseDBUserDataHelper.setStatisticsData(new LocalDate() , time,meal);
        //Toast.makeText(this, "Added Meal To History", Toast.LENGTH_SHORT).show();

    } //end of addMeal

    public void setMenuEntity(MenuEntity menu) {
        this.menu = menu;
    }

    public MenuEntity getMenuEntity() {
        return menu;
    }
} //end of class