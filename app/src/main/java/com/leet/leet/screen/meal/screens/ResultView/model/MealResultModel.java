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

    /**
     * Purpose - this method determines which menu was selected by the user. Either the user's custom
     *           menu will be retrieved or one of the six dining halls will be retrieved.
     * @param callback
     */
    public void getMenu(final FirebaseDBCallaback<Boolean> callback) {

        // If the user selects a dining hall, get that dining hall's menu
        if(currentRestaurantName != Enums.RestaurantName.Custom) {
            FirebaseDBMenuDataHelper.getMenuData(currentRestaurantName,
                    DateHelper.getCurrentDate(),
                    currentMealTime, // default meal time is lunch, so initially load lunch menu
                    new FirebaseDBCallaback<ArrayList<MenuEntity>>() {
                        @Override
                        public void getData(ArrayList<MenuEntity> data) {
                            menuEntityList = data;
                            searchedMenuEntityList = data;
                            callback.getData(true);
                        }
                    });
        }
        else { // get custom meal menu using different Firebase helper, if custom is selected
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

    /*
     * Getters and setters
     */
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

    /**
     * Purpose - These are the strings to be used in the spinner for selecting meal time
     * @return
     */
    public ArrayList<String> getMealTimeList() {
        ArrayList<String> val = new ArrayList<>();
        val.add("Breakfast");
        val.add("Lunch");
        val.add("Dinner");
        return val;
    }

    /**
     * Purpose - this method is called from MealSortDialog to filter out results depending on selected
     *           ranges in the spinners of the dialog.
     * @param priceRange - index in price array string
     * @param calorieRange - index in calorie range array string
     * @param proteinRange - index in protein range array
     * @param carbsRange - index for carbs
     * @param totFatRange - index for totFat
     * @param satFatRange - index for saturated fat
     * @param sodiumRange - index for sodium range
     * @param cholRange - index for cholesterol
     * @param fiberRange - index for fiber
     * @param sugarRange - index for sugar
     */
    public void sort(int priceRange, int calorieRange, int proteinRange, int carbsRange, int totFatRange
        , int satFatRange, int sodiumRange, int cholRange, int fiberRange, int sugarRange) {

        ArrayList<MenuEntity> result = new ArrayList<>();
        float priceMax=-1; //make -1 to skip by default
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
            priceMax = 4;
            priceMin = 0;
        }
        else if(priceRange == 2){
            priceMax = 7;
            priceMin = 4;
        }
        else if(priceRange == 3){
            priceMax = 9999;
            priceMin = 7;
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
        else if(calorieRange == 4){
            calorieMax = 9999;
            calorieMin = 2000;
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
        else if(proteinRange == 4){
            proteinMax = 9999;
            proteinMin = 20;
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
        else if(carbsRange == 4){
            carbsMax = 9999;
            carbsMin = 40;
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
        else if(totFatRange == 4){
            totalFatMin = 50;
            totFatMax = 9999;
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
        else if(satFatRange == 4){
            satFatMax = 9999;
            satFatMin = 30;
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
        else if(sodiumRange == 4){
            sodiumMax = 9999;
            sodiumMin = 2000;
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
        else if(cholRange == 4){
            cholMax = 9999;
            cholMin = 150;
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
        else if(fiberRange == 4){
            fiberMax = 9999;
            fiberMin = 30;
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
        else if(sugarRange == 4){
            sugarMin = 40;
            sugarMax = 9999;
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
                    || tmp.getNutritions().getProtein() > proteinMax)) {
                valid = false;
            }
            if (carbsMax != -1 && (tmp.getNutritions().getCarb() < carbsMin
                    || tmp.getNutritions().getCarb() > carbsMax)) {
                valid = false;
            }
            if (totFatMax != -1 && (tmp.getNutritions().getTotalFat() < totalFatMin
                    || tmp.getNutritions().getTotalFat() > totFatMax)) {
                valid = false;
            }
            if (satFatMax != -1 && (tmp.getNutritions().getSatFat() < satFatMin
                    || tmp.getNutritions().getSatFat() > satFatMax)) {
                valid = false;
            }
            if (sodiumMax != -1 && (tmp.getNutritions().getSodium() < sodiumMin
                    || tmp.getNutritions().getSodium() > sodiumMax)) {
                valid = false;
            }
            if (cholMax != -1 && (tmp.getNutritions().getCholesterol() < cholMin
                    || tmp.getNutritions().getSodium() > sodiumMax)) {
                valid = false;
            }
            if (fiberMax != -1 && (tmp.getNutritions().getDietaryFiber() < fiberMin
                    || tmp.getNutritions().getDietaryFiber() > fiberMax)) {
                valid = false;
            }
            if (sugarMax != -1 && (tmp.getNutritions().getSugars() < sugarMin
                    || tmp.getNutritions().getSugars() > sugarMax)) {
                valid = false;
            }

            if (valid) {
                result.add(tmp);
            }
        }//end of for each loop

        //once all the MenuEntity's that meet the users criteria are filtered assign it to be used in
        //results page
        searchedMenuEntityList = result;

    }//end of method
}//end of class
