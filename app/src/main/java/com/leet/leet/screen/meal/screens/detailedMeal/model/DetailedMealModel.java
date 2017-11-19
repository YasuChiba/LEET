package com.leet.leet.screen.meal.screens.detailedMeal.model;

import com.leet.leet.utils.database.entities.menu.MenuEntity;

/**
 * Created by k3vn19 on 11/16/2017.
 *
 * Purpose - This class serves as the "Model" for the Detailed Menu Page.
 */

public class DetailedMealModel {

    public DetailedMealModel(){} //default constructor

    //Purpose - Once the user has decided to eat a meal, they will add it to their history.
    //          This method will add the MenuEntity to the profile's history.
    public void addMeal(MenuEntity meal){
        //DB.addMeal(meal); TODO - Find out which DB method to use here

    } //end of addMeal
} //end of class
