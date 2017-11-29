package com.leet.leet.screen.meal.screens.ResultView.model;

import com.leet.leet.common.Enums;
import com.leet.leet.utils.DateHelper;
import com.leet.leet.utils.database.FirebaseDBCallaback;
import com.leet.leet.utils.database.FirebaseDBMenuDataHelper;
import com.leet.leet.utils.database.entities.menu.MenuEntity;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by YasuhiraChiba on 2017/11/28.
 */

public class MealResultModel {

    private ArrayList<MenuEntity> menuEntityList;
    private Enums.MealTime currentMealTime;

    public MealResultModel() {
        currentMealTime = Enums.MealTime.Lunch;
    }

    public void getMenu(final FirebaseDBCallaback<Boolean> callback) {
        FirebaseDBMenuDataHelper.getMenuData(Enums.RestaurantName.CafeVentanas,
                DateHelper.getCurrentDate(),
                currentMealTime,
                new FirebaseDBCallaback<ArrayList<MenuEntity>>() {
                    @Override
                    public void getData(ArrayList<MenuEntity> data) {
                        menuEntityList = data;
                        callback.getData(true);
                    }
                });
    }

    public ArrayList<MenuEntity> getMenuEntityList() {
        return menuEntityList;
    }

    public void setCurrentMealTime(Enums.MealTime time) {
        this.currentMealTime = time;
    }

    public Enums.MealTime getCurrentMealTime() {
        return currentMealTime;
    }

    public ArrayList<String> getMealTimeList() {
        ArrayList<String> val = new ArrayList<>();
        val.add("Breakfast");
        val.add("Lunch");
        val.add("Dinner");
        return val;
    }
}
