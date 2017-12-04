package com.leet.leet.screen.meal.screens.ResultView.model;

import android.util.Log;
import android.view.Menu;

import com.leet.leet.common.Enums;
import com.leet.leet.utils.DateHelper;
import com.leet.leet.utils.database.FirebaseDBCallaback;
import com.leet.leet.utils.database.FirebaseDBMenuDataHelper;
import com.leet.leet.utils.database.FirebaseDBUserDataHelper;
import com.leet.leet.utils.database.entities.menu.MenuEntity;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by YasuhiraChiba on 2017/11/28.
 */

public class MealResultModel {

    private ArrayList<MenuEntity> menuEntityList;
    private ArrayList<MenuEntity> searchedMenuEntityList;
    private Enums.MealTime currentMealTime;
    private Enums.RestaurantName currentRestaurantName;

    public MealResultModel() {

        //TODO:need to consider about default value
        currentMealTime = Enums.MealTime.Lunch;
        currentRestaurantName = Enums.RestaurantName.CafeVentanas;
    }

    public void getMenu(final FirebaseDBCallaback<Boolean> callback) {

        if(currentRestaurantName != Enums.RestaurantName.Custom) {
            Log.d("If", "In if");
            FirebaseDBMenuDataHelper.getMenuData(currentRestaurantName,
                    DateHelper.getCurrentDate(),
                    currentMealTime,
                    new FirebaseDBCallaback<ArrayList<MenuEntity>>() {
                        @Override
                        public void getData(ArrayList<MenuEntity> data) {
                            menuEntityList = data;
                            searchedMenuEntityList = data;
                            callback.getData(true);
                        }
                    });
        }
        else {
            FirebaseDBUserDataHelper.getCustomMenus(new FirebaseDBCallaback<ArrayList<MenuEntity>>() {
                @Override
                public void getData(ArrayList<MenuEntity> data) {
                    menuEntityList = data;
                    searchedMenuEntityList = data;
                    callback.getData(true);
                }
            });
        }
    }

    public Enums.RestaurantName getRestaurantName() {
        return currentRestaurantName;
    }
    public ArrayList<MenuEntity> getMenuEntityList() {
        return searchedMenuEntityList;
    }

    public void setCurrentMealTime(Enums.MealTime time) {
        this.currentMealTime = time;
    }

    public Enums.MealTime getCurrentMealTime() {
        return currentMealTime;
    }

    public void setCurrentRestaurantName(Enums.RestaurantName name) {
        this.currentRestaurantName = name;
    }

    public ArrayList<String> getMealTimeList() {
        ArrayList<String> val = new ArrayList<>();
        val.add("Breakfast");
        val.add("Lunch");
        val.add("Dinner");
        return val;
    }

    public void sort(int priceRange, int calorieRange, int proteinRange, int carbsRange, int totFatRange
        , int satFatRange, int sodiumRange, int cholRange, int fiberRange, int sugarRange) {

        ArrayList<MenuEntity> result = new ArrayList<>();
        float priceMax=-1; //make -1 to skip
        float priceMin=0;
        float calorieMax = -1;
        float calorieMin = 0;
        float proteinMax = -1;
        float proteinMin = 0;
        float carbsMax = -1;
        float carbsMin = 0;
        float totFatMax = -1;
        float totalFatMin = 0;
        float satFatMax = -1;
        float satFatMin = 0;
        float sodiumMax = -1;
        float sodiumMin = -1;
        float cholMax = -1;
        float cholMin = 0;
        float fiberMax = -1;
        float fiberMin = 0;
        float sugarMax = -1;
        float sugarMin = 0;

        //check price Array index
        if(priceRange == 1){
            priceMax = 5;
            priceMin = 0;
        }
        else if(priceRange == 2){
            priceMax = 10;
            priceMin = 5;
        }
        else if(priceRange == 3){
            priceMax = 15;
            priceMin = 10;
        }

        //check calorie range
        if(calorieRange == 1){
            calorieMax = 600;
        }
        else if(calorieRange == 2){
            calorieMax = 1200;
            calorieMin = 600;
        }
        else if(calorieRange == 3){
            calorieMax = 2000;
            calorieMin = 1200;
        }

        //check protein range
        if(proteinRange == 1){
            proteinMax = 5;
        }
        else if(proteinRange == 2){
            proteinMax = 15;
            proteinMin = 5;
        }
        else if(proteinRange == 3){
            proteinMax = 20;
            proteinMin = 15;
        }

        //check carbs range
        if(carbsRange == 1){
            carbsMax = 15;
        }
        else if(carbsRange == 2){
            carbsMax = 25;
            carbsMin = 15;
        }
        else if(carbsRange == 3){
            carbsMax = 40;
            carbsMin = 25;
        }

        //check total fat
        if(totFatRange == 1){
            totFatMax = 15;
        }
        else if(totFatRange == 2){
            totFatMax = 30;
            totalFatMin = 15;
        }
        else if(totFatRange == 3){
            totFatMax = 50;
            totalFatMin = 30;
        }

        //check saturated fat range
        if(satFatRange == 1){
            satFatMax = 10;
        }
        else if(satFatRange == 2){
            satFatMax = 20;
            satFatMin = 10;
        }
        else if(satFatRange == 3){
            satFatMax = 30;
            satFatMin = 20;
        }

        //check sodium range
        if(sodiumRange == 1){
            sodiumMax = 600;
        }
        else if(sodiumRange == 2){
            sodiumMax = 1200;
            sodiumMin = 600;
        }
        else if(sodiumRange == 3){
            sodiumMax = 2000;
            sodiumMin = 1200;
        }

        //check cholesterol range
        if(cholRange == 1){
            cholMax = 50;
        }
        else if(cholRange == 2){
            cholMax = 100;
            cholMin = 50;
        }
        else if(cholRange == 3){
            cholMax = 150;
            cholMin = 100;
        }

        //check fiber range
        if(fiberRange == 1){
            fiberMax = 5;
        }
        else if(fiberRange == 2){
            fiberMax = 15;
            fiberMin = 5;
        }
        else if(fiberRange == 3){
            fiberMax = 30;
            fiberMin = 15;
        }

        //check sugar range
        if(sugarRange == 1){
            sugarMax = 15;
        }
        else if(sugarRange == 2){
            sugarMax = 25;
            sugarMin = 15;
        }
        else if(sugarRange == 3){
            sugarMax = 40;
            sugarMin = 25;
        }

        //add to result if the range is valid
        for(MenuEntity tmp : menuEntityList) {
            boolean valid = true;
            if (priceMax != -1 && (tmp.getPrice() < priceMin || tmp.getPrice() > priceMax)) {
                valid = false;
            }
            if (calorieMax != -1 && (tmp.getNutritions().getCalories() < calorieMin ||
                    tmp.getNutritions().getCalories() > calorieMax)) {
                valid = false;
            }
            if (proteinMax != -1 && (tmp.getNutritions().getProtein() < proteinMin
                    && tmp.getNutritions().getProtein() > proteinMax)) {
                valid = false;
            }
            if (carbsMax != -1 && (tmp.getNutritions().getCarb() < carbsMin
                    && tmp.getNutritions().getCarb() > carbsMax)) {
                valid = false;
            }
            if (totFatMax != -1 && (tmp.getNutritions().getTotalFat() < totalFatMin
                    && tmp.getNutritions().getTotalFat() > totFatMax)) {
                valid = false;
            }
            if (satFatMax != -1 && (tmp.getNutritions().getSatFat() < satFatMin
                    && tmp.getNutritions().getSatFat() > satFatMax)) {
                valid = false;
            }
            if (sodiumMax != -1 && (tmp.getNutritions().getSodium() < sodiumMin
                    && tmp.getNutritions().getSodium() > sodiumMax)) {
                valid = false;
            }
            if (cholMax != -1 && (tmp.getNutritions().getCholesterol() < cholMin
                    && tmp.getNutritions().getSodium() > sodiumMax)) {
                valid = false;
            }
            if (fiberMax != -1 && (tmp.getNutritions().getDietaryFiber() < fiberMin
                    && tmp.getNutritions().getDietaryFiber() > fiberMax)) {
                valid = false;
            }
            if (sugarMax != -1 && (tmp.getNutritions().getSugars() < sugarMin
                    && tmp.getNutritions().getSugars() > sugarMax)) {
                valid = false;
            }

            if (valid) {
                result.add(tmp);
            }
        }//end of for each loop

        searchedMenuEntityList = result;

    }//end of method
}//end of class
