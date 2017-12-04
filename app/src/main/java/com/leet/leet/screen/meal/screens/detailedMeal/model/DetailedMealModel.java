package com.leet.leet.screen.meal.screens.detailedMeal.model;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.leet.leet.common.Enums;
import com.leet.leet.utils.database.FirebaseDBUserDataHelper;
import com.leet.leet.utils.database.entities.menu.MenuEntity;

import org.joda.time.LocalDate;

import android.widget.Toast;


/**
 * Created by k3vn19 on 11/16/2017.
 *
 * Purpose - This class serves as the "Model" for the Detailed Menu Page.
 */

public class DetailedMealModel {

    private MenuEntity menu;

    public DetailedMealModel(){} //default constructor

    public void setMenuEntity(MenuEntity menu) {
        this.menu = menu;
    }
    public MenuEntity getMenuEntity() {
        return menu;
    }
} //end of class
