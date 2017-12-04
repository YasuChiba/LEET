package com.leet.leet.screen.meal.screens.confirmAdd.model;

import com.leet.leet.common.Enums;
import com.leet.leet.utils.database.FirebaseDBUserDataHelper;
import com.leet.leet.utils.database.entities.menu.MenuEntity;

import org.joda.time.LocalDate;

import static com.leet.leet.common.Enums.MealTime.Breakfast;
import static com.leet.leet.common.Enums.MealTime.Dinner;
import static com.leet.leet.common.Enums.MealTime.Lunch;

/**
 * Created by k3vn19 on 12/3/2017.
 */

public class ConfirmAddDialogModel {

    private int mealTimeRange; //index in the string-array of meal time ranges: bfast, lunch, dinner

    /**
     * default constructor, set default to lunch
     */
    public ConfirmAddDialogModel(){
        mealTimeRange = 1;
    }

    //Purpose - Once the user has decided to eat a meal, they will add it to their history.
    //          This method will add the MenuEntity to the profile's history.
    public void addMeal(MenuEntity meal, int time){
        Enums.MealTime mealTime = Breakfast;

        //Determine which meal time to use depending on index in string array
        if(time == 0){
            mealTime = Breakfast;
        }
        else if(time == 1){
            mealTime = Lunch;
        }
        else if(time == 2){
            mealTime = Dinner;
        }

        //add the meal to the database
        FirebaseDBUserDataHelper.setStatisticsData(new LocalDate(), mealTime , meal);

    } //end of addMeal

    /**
     * Setter
     * @param i - The meal time to set
     */
    public void setMealTimeRange(int i){
        mealTimeRange = i;
    }

    /**
     * Getter for meal time, is used in the fragment.
     * @return
     */
    public int getMealTimeRange(){
        return mealTimeRange;
    }

}
