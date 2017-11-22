package com.leet.leet.screen.meal.screens.addCustomMeal.model;

import com.leet.leet.utils.database.FirebaseDBUserDataHelper;
import com.leet.leet.utils.database.entities.menu.MenuEntity;
import com.leet.leet.utils.database.entities.menu.MenuNutritionsEntity;
import com.leet.leet.utils.database.entities.menu.MenuTagsEntity;

import java.util.List;

/**
 * Created by k3vn19 on 11/15/2017.
 *
 * Purpose - This class is to act as the "Model" for the Add Custom Meal Page.
 */

public class AddCustomMealModel {

    public AddCustomMealModel(){} //default constructor

    //Purpose - With the parameters provided by the controller, the model now creates a MenuEntity
    //          and adds it to firebase through the use of DBUserDataHelper.
    public void addMeal(String name, String price, String calories, String carbs,
                        String totalFat, String satFat, String protein, String sodium,
                        String cholesterol, String fiber, String sugar){
        //object to add to firebase
        MenuEntity meal;

        //parameters to be used in meal's constructor
        MenuNutritionsEntity nutrition;
        MenuTagsEntity tags = new MenuTagsEntity(false, false, false); //might have to be changed later
        List<String> allergens = null; //might have to be something else

        //initialize MenuNutritionsEntity to be used for MenuEntity constructor
        nutrition = new MenuNutritionsEntity(Float.parseFloat(cholesterol), Float.parseFloat(fiber),
                Float.parseFloat(protein), Float.parseFloat(satFat), Float.parseFloat(sodium),
                Float.parseFloat(sugar), Float.parseFloat(carbs), Float.parseFloat(totalFat),
                Float.parseFloat(calories),"",allergens);

        //initialize the MenuEntity
        meal = new MenuEntity(name, nutrition, Float.parseFloat(price), tags);

        //add custom meal to firebase
        FirebaseDBUserDataHelper.addCustomMenu(name,meal);

    } //end of addMeal
} //end of class

