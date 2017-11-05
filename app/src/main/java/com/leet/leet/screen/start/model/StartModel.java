package com.leet.leet.screen.start.model;


import android.util.Log;

import com.leet.leet.common.Enums;
import com.leet.leet.utils.DateHelper;
import com.leet.leet.utils.SharedPrefManager;
import com.leet.leet.utils.authentication.FirebaseAuthHelper;
import com.leet.leet.utils.database.FirebaseDBCallaback;
import com.leet.leet.utils.database.FirebaseDBMenuDataHelper;
import com.leet.leet.utils.database.FirebaseDBUserDataHelper;
import com.leet.leet.utils.database.entities.menu.MenuEntity;
import com.leet.leet.utils.database.entities.menu.MenuTagsEntity;
import com.leet.leet.utils.database.entities.user.UserProfileEntity;

import org.joda.time.LocalDate;

import java.util.ArrayList;

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

    public void setUserProfile() {
        UserProfileEntity ent = new UserProfileEntity();

        ent.setGender(Enums.Gender.Male.getString());
        ent.setName("tes");
        ent.setAge(20);
        ent.setHeight(10);
        ent.setWeight(10);

        FirebaseDBUserDataHelper.setUserProfile(ent);
    }

    public void addCustomMenu() {
        MenuEntity menu = new MenuEntity();

        menu.setPrice(19);
        menu.setTags(new MenuTagsEntity());

        FirebaseDBUserDataHelper.addCustomMenu("te",menu);
    }
}
