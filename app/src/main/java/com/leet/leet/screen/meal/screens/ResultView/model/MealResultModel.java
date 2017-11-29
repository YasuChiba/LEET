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

    public void getMenu(final FirebaseDBCallaback<Boolean> callback) {
        FirebaseDBMenuDataHelper.getMenuData(Enums.RestaurantName.CafeVentanas,
                DateHelper.getCurrentDate(),
                Enums.MealTime.Breakfast,
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
}
