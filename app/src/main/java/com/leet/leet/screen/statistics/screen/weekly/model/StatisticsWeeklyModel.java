package com.leet.leet.screen.statistics.screen.weekly.model;

import com.leet.leet.utils.DateHelper;
import com.leet.leet.utils.database.FirebaseDBCallaback;
import com.leet.leet.utils.database.FirebaseDBUserDataHelper;
import com.leet.leet.utils.database.entities.menu.MenuEntity;

import java.util.ArrayList;
import java.util.HashMap;
import android.util.Log;

import com.leet.leet.common.Enums;
import com.leet.leet.utils.DateHelper;
import com.leet.leet.utils.database.FirebaseDBCallaback;
import com.leet.leet.utils.database.FirebaseDBMenuDataHelper;
import com.leet.leet.utils.database.FirebaseDBUserDataHelper;
import com.leet.leet.utils.database.entities.menu.MenuEntity;
import com.leet.leet.utils.database.entities.user.UserStatisticsEntity;

import org.joda.time.LocalDate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by YasuhiraChiba on 2017/11/07.
 */

public class StatisticsWeeklyModel {


    private ArrayList<LocalDate> dayList = new ArrayList<>();
    private ArrayList<Float> priceList = new ArrayList<Float>();
    private ArrayList<Float> calorieList = new ArrayList<Float>();
    private ArrayList<Float> proteinList = new ArrayList<Float>();
    private ArrayList<Float> fatList = new ArrayList<Float>();
    private ArrayList<Float> carbsList = new ArrayList<Float>();


    public void setDataTest() {

        for(int i=0;i<10;i++){
            LocalDate date = DateHelper.getPastDate(i);

            for(int j=0;j<3;j++){
                Enums.MealTime time = Enums.MealTime.Breakfast;
                if(j==0) time = Enums.MealTime.Breakfast;
                if(j==1)time = Enums.MealTime.Lunch;
                if(j==2)time = Enums.MealTime.Dinner;

                for(int k=0;k<5;k++) {
                    final LocalDate d = date;
                    final Enums.MealTime t = time;
                    FirebaseDBMenuDataHelper.getMenuData(Enums.RestaurantName.CafeVentanas, DateHelper.getCurrentDate(), time,
                            new FirebaseDBCallaback<ArrayList<MenuEntity>>() {
                                @Override
                                public void getData(ArrayList<MenuEntity> data) {
                                    int ran = (int)(Math.random()*data.size());
                                    FirebaseDBUserDataHelper.setStatisticsData(d, t,data.get(ran));
                                }
                            });
                }
            }
        }
        /*
        MenuEntity ent = new MenuEntity();
        ent.setName("TTasdsda0");
        ent.setPrice(200);
        FirebaseDBUserDataHelper.setStatisticsData(DateHelper.getCurrentDate(),ent);
        */
    }

    public void getStatisticsData(final LocalDate startDate,
                                  final LocalDate endDate,
                                  final FirebaseDBCallaback<Boolean> callback) {


        FirebaseDBUserDataHelper.getStatisticsData(startDate, endDate, new FirebaseDBCallaback<ArrayList<UserStatisticsEntity>>() {
            @Override
            public void getData(ArrayList<UserStatisticsEntity> data) {

                ArrayList<LocalDate> dayL = new ArrayList<>();
                ArrayList<Float> priceL = new ArrayList<Float>();
                ArrayList<Float> calorieL = new ArrayList<Float>();
                ArrayList<Float> proteinL = new ArrayList<Float>();
                ArrayList<Float> fatL = new ArrayList<Float>();
                ArrayList<Float> carbsL = new ArrayList<Float>();


                for(UserStatisticsEntity entity : data) {
                    float price = 0;
                    float calorie = 0;
                    float protein = 0;
                    float fat = 0;
                    float carbs = 0;

                    for(MenuEntity menu : entity.getBreakfastMenu()) {
                        price += menu.getPrice();
                        calorie += menu.getNutritions().getCalories();
                        protein += menu.getNutritions().getProtein();
                        fat += menu.getNutritions().getTotalFat();
                        carbs += menu.getNutritions().getCarb();
                    }

                    for(MenuEntity menu : entity.getLunchMenu()) {
                        price += menu.getPrice();
                        calorie += menu.getNutritions().getCalories();
                        protein += menu.getNutritions().getProtein();
                        fat += menu.getNutritions().getTotalFat();
                        carbs += menu.getNutritions().getCarb();
                    }

                    for(MenuEntity menu : entity.getDinnerMenu()) {
                        price += menu.getPrice();
                        calorie += menu.getNutritions().getCalories();
                        protein += menu.getNutritions().getProtein();
                        fat += menu.getNutritions().getTotalFat();
                        carbs += menu.getNutritions().getCarb();
                    }
                    priceL.add(price);
                    calorieL.add(calorie);
                    proteinL.add(protein);
                    fatL.add(fat);
                    carbsL.add(carbs);
                    dayL.add(DateHelper.getDateByString(entity.getDate()));
                }

                priceList = priceL;
                calorieList = calorieL;
                proteinList = proteinL;
                fatList = fatL;
                carbsList = carbsL;
                dayList = dayL;

                callback.getData(true);
            }
        });
/*
        FirebaseDBUserDataHelper.getStatisticsData(startDate, endDate, new FirebaseDBCallaback<HashMap<String, ArrayList<MenuEntity>>>() {
            @Override
            public void getData(HashMap<String, ArrayList<MenuEntity>> data) {

                ArrayList<LocalDate> dayL = new ArrayList<>();
                ArrayList<Float> priceL = new ArrayList<Float>();
                ArrayList<Float> calorieL = new ArrayList<Float>();
                ArrayList<Float> proteinL = new ArrayList<Float>();
                ArrayList<Float> fatL = new ArrayList<Float>();
                ArrayList<Float> carbsL = new ArrayList<Float>();

                LocalDate date = startDate;
                LocalDate end = DateHelper.getFutureDateOfTheDate(endDate,1);

                while(date.compareTo(end) != 0) {
                    float price = 0;
                    float calorie = 0;
                    float protein = 0;
                    float fat = 0;
                    float carbs = 0;

                    if(data.get(DateHelper.getStringByDate(date)) != null) {
                        for(MenuEntity tmp : data.get(DateHelper.getStringByDate(date))) {
                            price += tmp.getPrice();
                            if(tmp.getNutritions() != null) {
                                calorie += tmp.getNutritions().getCalories();
                                protein += tmp.getNutritions().getProtein();
                                fat += tmp.getNutritions().getTotalFat();
                                carbs = tmp.getNutritions().getCarb();
                            }
                        }
                    }
                    priceL.add(price);
                    calorieL.add(calorie);
                    proteinL.add(protein);
                    fatL.add(fat);
                    carbsL.add(carbs);

                    dayL.add(date);
                    date = DateHelper.getFutureDateOfTheDate(date,1);
                }

                priceList = priceL;
                calorieList = calorieL;
                proteinList = proteinL;
                fatList = fatL;
                carbsList = carbsL;
                dayList = dayL;

                callback.getData(true);
            }
        });
        */
    }

    public ArrayList<LocalDate> getDayList() {
        return dayList;
    }

    public ArrayList<String> getWeekList() {
        ArrayList<String> returnVal = new ArrayList<>();
        for(LocalDate tmp:dayList) {
            returnVal.add(DateHelper.getWeekByString(DateHelper.getStringByDate(tmp)).getString());
        }
        return returnVal;
    }

    public ArrayList<Float> getPriceList() {
        return priceList;
    }

    public ArrayList<Float> getCalorieList() {
        return calorieList;
    }

    public ArrayList<Float> getProteinList() {
        return proteinList;
    }

    public ArrayList<Float> getFatList() {
        return fatList;
    }

    public ArrayList<Float> getCarbsList() {
        return carbsList;
    }

}
