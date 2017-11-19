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
    public void addMeal(String name, int price, int calories, int carbs,
                        int totalFat, int satFat, int protein, int sodium,
                        int cholesterol, int fiber, int sugar){
        //object to add to firebase
        MenuEntity meal;

        //parameters to be used in meal's constructor
        MenuNutritionsEntity nutrition;
        MenuTagsEntity tags = new MenuTagsEntity(false, false, false); //might have to be changed later
        List<String> allergens = null; //might have to be something else

        //initialize MenuNutritionsEntity to be used for MenuEntity constructor
        nutrition = new MenuNutritionsEntity((float)cholesterol, (float)fiber, (float)protein,
                (float)satFat, (float)sodium, (float)sugar, (float)carbs, (float)totalFat, (float) calories,
                 "",allergens);

        //initialize the MenuEntity
        meal = new MenuEntity(name, nutrition, (float)price, tags);

        //add custom meal to firebase
        FirebaseDBUserDataHelper.addCustomMenu(name,meal);

    } //end of addMeal
} //end of class

