package com.leet.leet.screen.meal.screens.sortMeal.model;

import com.leet.leet.utils.database.entities.menu.MenuEntity;

import java.util.ArrayList;

/**
 * Created by k3vn19 on 11/19/2017.
 *
 * This class acts as the Model for the Sort Menu Options Page.
 *
 * THIS CLASS IS NO LONGER BEING USED
 */

public class SortMealModel {

    private ArrayList<MenuEntity> data; //will contain all MenuEntitys from the previous results page
    private MenuEntity currEntity;

    public SortMealModel(){} //default constructor

    //Purpose - sort the results page using input parameters
    public void sortMenu(int priceMin, int priceMax, int calMin, int calMax, int carbsMin, int carbsMax,
                         int fatMin, int fatMax, int proteinMin, int proteinMax, int sugarMin, int sugarMax){

        //iterate through the ArrayList and remove elements that don't satisfy the min and max values
        for(int i = 0; i < data.size(); i++){
            currEntity = data.get(i);
            // check price
            if((priceMin != -1 && priceMin > currEntity.getPrice()) ||
                    (priceMax != -1 && priceMax < currEntity.getPrice())){
                data.remove(i);
            }
            else if((calMin != -1 && calMin > currEntity.getNutritions().getCalories()) ||
                    (calMax != 1 && calMax < currEntity.getNutritions().getCalories())){
                data.remove(i);
            }
            else if((carbsMin != -1 && carbsMin > currEntity.getNutritions().getCarb()) ||
                    (carbsMax != -1 && carbsMax < currEntity.getNutritions().getCarb())){
                data.remove(i);
            }
            else if((fatMin != -1 && fatMin > currEntity.getNutritions().getTotalFat()) ||
                    (fatMax != -1 && fatMax < currEntity.getNutritions().getTotalFat())){
                data.remove(i);
            }
            else if((proteinMin != -1 && proteinMin > currEntity.getNutritions().getProtein()) ||
                    proteinMax != -1 && proteinMax < currEntity.getNutritions().getProtein()){
                data.remove(i);
            }
            else if((sugarMin != -1 && sugarMin > currEntity.getNutritions().getSugars()) ||
                    (sugarMax != -1 && sugarMax < currEntity.getNutritions().getSugars())){
                data.remove(i);
            }
        } //end of for loop

        //TODO - Might have to return data to previous page, not sure

        //TODO - also need to return to previous page
    } //end of SortMealModel()
} //end of class
