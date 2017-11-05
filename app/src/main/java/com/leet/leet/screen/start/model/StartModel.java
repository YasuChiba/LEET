package com.leet.leet.screen.start.model;


import android.util.Log;

import com.leet.leet.common.Enums;
import com.leet.leet.utils.DateHelper;
import com.leet.leet.utils.SharedPrefManager;
import com.leet.leet.utils.authentication.FirebaseAuthHelper;
import com.leet.leet.utils.database.FirebaseDBCallaback;
import com.leet.leet.utils.database.FirebaseDBMenuDataHelper;
import com.leet.leet.utils.database.entities.menu.MenuEntity;

import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by YasuhiraChiba on 2017/10/31.
 */

public class StartModel {

    public boolean isFirstLaunch() {
        return SharedPrefManager.loadIsFirstLaunch();
    }

    public boolean isLoggedIn() {
        return FirebaseAuthHelper.isLoggedIn();
    }

    public void getMenu() {

        LocalDate d = DateHelper.getFutureDate(1);

        FirebaseDBMenuDataHelper.getMenuData(Enums.RestaurantName.CafeVentanas, d, Enums.MealTime.Breakfast,
                new FirebaseDBCallaback<ArrayList<MenuEntity>>() {
                     @Override
                     public void getData(ArrayList<MenuEntity> data) {
                            Log.d("","");
                      }
                 });
    }
}
