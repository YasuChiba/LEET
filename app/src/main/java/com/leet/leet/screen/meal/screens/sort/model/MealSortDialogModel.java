package com.leet.leet.screen.meal.screens.sort.model;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by YasuhiraChiba on 2017/11/29.
 */

public class MealSortDialogModel {

    private int priceRange;
    private int calorieRange;
    private int carbsRange;
    private int totalFatRange;
    private int satFatRange;
    private int proteinRange;
    private int sodiumRange;
    private int cholesterolRange;
    private int fiberRange;
    private int sugarRange;

    public void setPriceRange(int i){
        priceRange = i;
    }
    public int getPriceRange(){
        return priceRange;
    }

    public void setCalorieRange(int i){calorieRange = i;}
    public int getCalorieRange(){return calorieRange;}

    public void setCarbsRange(int i){carbsRange = i;}
    public int getCarbsRange(){return carbsRange;}

    public void setTotalFatRange(int i){totalFatRange = i;}
    public int getTotalFatRange(){return totalFatRange;}

    public void setSatFatRange(int i){satFatRange = i;}
    public int getSatFatRange(){return satFatRange;}

    public void setProteinRange(int i){proteinRange = i;}
    public int getProteinRange(){return proteinRange;}

    public void setSodiumRange(int i){sodiumRange = i;}
    public int getSodiumRange(){return sodiumRange;}

    public void setCholesterolRange(int i){cholesterolRange = i;}
    public int getCholesterolRange(){return cholesterolRange;}

    public void setFiberRange(int i){fiberRange = i;}
    public int getFiberRange(){return fiberRange;}

    public void setSugarRange(int i){sugarRange = i;}
    public int getSugarRange(){return sugarRange;}

} //end of class
