package com.leet.leet.screen.statistics.screen.daily.model;

import com.leet.leet.common.Enums;
import com.leet.leet.screen.statistics.screen.weekly.model.SumModel;
import com.leet.leet.utils.DateHelper;
import com.leet.leet.utils.database.FirebaseDBCallaback;
import com.leet.leet.utils.database.FirebaseDBUserDataHelper;
import com.leet.leet.utils.database.entities.menu.MenuEntity;
import com.leet.leet.utils.database.entities.user.UserStatisticsEntity;

import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by YasuhiraChiba on 2017/11/05.
 */

public class StatisticsDailyModel {


    LocalDate date;
    UserStatisticsEntity statisticsData;
    SumModel sumData;


    public void getStatisticsData(final FirebaseDBCallaback<Boolean> callback) {

        FirebaseDBUserDataHelper.getStatisticsData(date, date, new FirebaseDBCallaback<ArrayList<UserStatisticsEntity>>() {
            @Override
            public void getData(ArrayList<UserStatisticsEntity> data) {
                if(data.size() == 1) {
                    float price = 0;
                    float calorie = 0;
                    float protein = 0;
                    float fat = 0;
                    float carbs = 0;

                    for(MenuEntity menu : data.get(0).getBreakfastMenu()) {
                        price += menu.getPrice();
                        calorie += menu.getNutritions().getCalories();
                        protein += menu.getNutritions().getProtein();
                        fat += menu.getNutritions().getTotalFat();
                        carbs += menu.getNutritions().getCarb();
                    }

                    for(MenuEntity menu : data.get(0).getLunchMenu()) {
                        price += menu.getPrice();
                        calorie += menu.getNutritions().getCalories();
                        protein += menu.getNutritions().getProtein();
                        fat += menu.getNutritions().getTotalFat();
                        carbs += menu.getNutritions().getCarb();
                    }

                    for(MenuEntity menu : data.get(0).getDinnerMenu()) {
                        price += menu.getPrice();
                        calorie += menu.getNutritions().getCalories();
                        protein += menu.getNutritions().getProtein();
                        fat += menu.getNutritions().getTotalFat();
                        carbs += menu.getNutritions().getCarb();
                    }

                    SumModel model = new SumModel(
                            DateHelper.getDateByString(data.get(0).getDate()),
                            price,
                            calorie,
                            protein,
                            fat,
                            carbs);
                    sumData = model;
                    statisticsData = data.get(0);
                    callback.getData(true);
                } else {
                    callback.getData(false);

                }
            }
        });
    }

    public void deleteMeal(String menuKey, Enums.MealTime mealTime) {
        FirebaseDBUserDataHelper.deleteStatisticsMenuData(date,mealTime,menuKey);
    }

    public String getWeek() {
        return DateHelper.getWeekByString(DateHelper.getStringByDate(sumData.day)).getString();
    }

    public float getTotalPrice() {
        return sumData.price;
    }

    public float getTotalCalorie() {
        return sumData.calorie;
    }

    public float getTotalProtein() {
        return sumData.protein;
    }

    public float getTotalFat() {
        return sumData.fat;
    }

    public float getTotalCarb() {
        return sumData.carbs;
    }

    public List<MenuEntity> getBreakfastList() {
        return statisticsData.getBreakfastMenu();
    }

    public List<MenuEntity> getLunchList() {
        return statisticsData.getLunchMenu();
    }

    public List<MenuEntity> getDinnerList() {
        return statisticsData.getDinnerMenu();
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    public LocalDate getDate(){
        return date;
    }
}
