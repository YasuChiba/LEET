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
    SumModel sumData;
    private UserGoalEntity userGoalEntity = new UserGoalEntity();



    public static float[] price;
    public static float[] calorie;
    public static float[] protein;
    public static float[] fat;
    public static float[] carbs;

    public static float price_B = 0;
    public static float calorie_B;
    public static float protein_B;
    public static float fat_B;
    public static float carbs_B;

    public static float price_L = 0;
    public static float calorie_L;
    public static float protein_L;
    public static float fat_L;
    public static float carbs_L;

    public static float price_D= 0;
    public static float calorie_D;
    public static float protein_D;
    public static float fat_D;
    public static float carbs_D;


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
                    /*
                    SumModel model = new SumModel(
                            DateHelper.getDateByString(data.get(0).getDate()),
                            price,
                            calorie,
                            protein,
                            fat,
                            carbs);
                            */
                    //sumData = model;

                    /*
                    price = new float[] {price_B, price_L, price_D};
                    calorie = new float[] {calorie_B / 100, calorie_L / 100, calorie_D / 100};
                    protein = new float[] {protein_B, protein_L, protein_D};
                    fat = new float[] {fat_B, fat_L, fat_D};
                    carbs = new float[] {carbs_B, carbs_L, carbs_D};
                    */
                    statisticsData = data.get(0);
                    callback.getData(true);
                } else {
                    callback.getData(false);

                }
            }
        });
    }

    public static float[] getPrice(){
        float[] total = new float[] {calorie_B/100, calorie_L/100, calorie_D/100};
        return total;
    }

    public static float[] getCalorie() {
        float[] total = new float[] {calorie_B/100, calorie_L/100, calorie_D/100};
        return total;
    }

    public static float[] getFat() {
        float[] total = new float[] {fat_B/10, fat_L/10, fat_D/10};
        return total;
    }

    public static float[] getProtein() {
        float[] total = new float[] {protein_B/10, protein_L/10, protein_D/10};
        return total;
    }

    public static float[] getCarbs() {
        float[] total = new float[]{carbs_B/10, carbs_L/10, carbs_D/10};
        return total;
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
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public LocalDate getDate(){
        return date;
    }
}
