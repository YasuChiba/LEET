package com.leet.leet.screen.statistics.screen.daily.model;

import com.leet.leet.common.Enums;
import com.leet.leet.screen.statistics.screen.weekly.model.SumModel;
import com.leet.leet.utils.DateHelper;
import com.leet.leet.utils.database.FirebaseDBCallaback;
import com.leet.leet.utils.database.FirebaseDBUserDataHelper;
import com.leet.leet.utils.database.entities.menu.MenuEntity;
import com.leet.leet.utils.database.entities.user.UserGoalEntity;
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

    public UserGoalEntity userGoalEntity = new UserGoalEntity();

    public float[] price;
    public float[] calorie;
    public float[] protein;
    public float[] fat;
    public float[] carbs;

    private float price_B = 0;
    private float calorie_B;
    private float protein_B;
    private float fat_B;
    private float carbs_B;

    private float price_L = 0;
    private float calorie_L;
    private float protein_L;
    private float fat_L;
    private float carbs_L;

    private float price_D= 0;
    private float calorie_D;
    private float protein_D;
    private float fat_D;
    private float carbs_D;

    private MenuEntity selectedMenuEntity;
    private Enums.MealTime selectedMealTime;


    public void getStatisticsData(final FirebaseDBCallaback<Boolean> callback) {

        FirebaseDBUserDataHelper.getStatisticsData(date, date, new FirebaseDBCallaback<ArrayList<UserStatisticsEntity>>() {
            @Override
            public void getData(ArrayList<UserStatisticsEntity> data) {
                if(data.size() == 1) {
                    price_B = 0;
                    calorie_B = 0;
                    protein_B = 0;
                    fat_B = 0;
                    carbs_B = 0;

                    price_L = 0;
                    calorie_L = 0;
                    protein_L = 0;
                    fat_L = 0;
                    carbs_L = 0;

                    price_D = 0;
                    calorie_D = 0;
                    protein_D = 0;
                    fat_D = 0;
                    carbs_D = 0;

                    for(MenuEntity menu : data.get(0).getBreakfastMenu()) {
                        price_B += menu.getPrice();
                        calorie_B += menu.getNutritions().getCalories();
                        protein_B += menu.getNutritions().getProtein();
                        fat_B += menu.getNutritions().getTotalFat();
                        carbs_B += menu.getNutritions().getCarb();
                    }

                    for(MenuEntity menu : data.get(0).getLunchMenu()) {
                        price_L += menu.getPrice();
                        calorie_L += menu.getNutritions().getCalories();
                        protein_L += menu.getNutritions().getProtein();
                        fat_L += menu.getNutritions().getTotalFat();
                        carbs_L += menu.getNutritions().getCarb();
                    }

                    for(MenuEntity menu : data.get(0).getDinnerMenu()) {
                        price_D += menu.getPrice();
                        calorie_D += menu.getNutritions().getCalories();
                        protein_D += menu.getNutritions().getProtein();
                        fat_D += menu.getNutritions().getTotalFat();
                        carbs_D += menu.getNutritions().getCarb();
                    }

                    statisticsData = data.get(0);
                    callback.getData(true);
                } else {
                    callback.getData(false);

                }
            }
        });
    }

    public float[] getPrice(){
        float[] total = new float[] {calorie_B/100, calorie_L/100, calorie_D/100};
        return total;
    }

    public float[] getCalorie() {
        float[] total = new float[] {calorie_B/100, calorie_L/100, calorie_D/100};
        return total;
    }

    public float[] getFat() {
        float[] total = new float[] {fat_B/10, fat_L/10, fat_D/10};
        return total;
    }

    public float[] getProtein() {
        float[] total = new float[] {protein_B/10, protein_L/10, protein_D/10};
        return total;
    }

    public float[] getCarbs() {
        float[] total = new float[]{carbs_B/10, carbs_L/10, carbs_D/10};
        return total;
    }

    public void deleteSelectedMeal() {
        FirebaseDBUserDataHelper.deleteStatisticsMenuData(date,selectedMealTime,selectedMenuEntity.getKey());
    }

    public void menuSelected(MenuEntity selectedMenuEntity, Enums.MealTime selectedMealTime) {
        this.selectedMealTime = selectedMealTime;
        this.selectedMenuEntity = selectedMenuEntity;
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

    public void getUserGoal( final FirebaseDBCallaback<Boolean> callback) {
        FirebaseDBUserDataHelper.getUserGoals(new FirebaseDBCallaback<UserGoalEntity>() {
            @Override
            public void getData(UserGoalEntity data) {
                if(data != null) {
                    userGoalEntity = data;
                }
                callback.getData(true);
            }
        });
    }

    public UserGoalEntity getUserGoalEntity(){
        return userGoalEntity;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    public LocalDate getDate(){
        return date;
    }


}
