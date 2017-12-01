package com.leet.leet.utils.database.entities.user;

import android.view.Menu;

import com.leet.leet.utils.database.entities.menu.MenuEntity;

import java.util.List;

/**
 * Created by YasuhiraChiba on 2017/11/22.
 */

public class UserStatisticsEntity {

    private String date;
    private List<MenuEntity> breakfastMenu;
    private List<MenuEntity> dinnerMenu;
    private List<MenuEntity> lunchMenu;


    public void setDate(String date) {
        this.date = date;
    }
    public String getDate() {
        return date;
    }

    public void setBreakfastMenu(List<MenuEntity> menu) {
        this.breakfastMenu = menu;
    }
    public List<MenuEntity> getBreakfastMenu() {
        return breakfastMenu;
    }

    public void setLunchMenu(List<MenuEntity> menu) {
        this.lunchMenu = menu;
    }

    public List<MenuEntity> getLunchMenu() {
        return lunchMenu;
    }

    public void setDinnerMenu(List<MenuEntity> menu) {
        this.dinnerMenu = menu;
    }
    public List<MenuEntity> getDinnerMenu() {
        return dinnerMenu;
    }
}
