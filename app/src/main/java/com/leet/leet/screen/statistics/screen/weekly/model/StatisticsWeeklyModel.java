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
import com.leet.leet.utils.database.entities.user.UserGoalEntity;
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


    private ArrayList<SumModel> dataList = new ArrayList<>();
    private UserGoalEntity userGoalEntity = new UserGoalEntity();

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
                ArrayList<SumModel> dataL = new ArrayList<SumModel>();

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

                    SumModel model = new SumModel(
                            DateHelper.getDateByString(entity.getDate()),
                            price,
                            calorie,
                            protein,
                            fat,
                            carbs);

                    dataL.add(model);
                }

                LocalDate d = startDate;
                for(int i=0; ; i++) {
                    if(dataL.size() <= i) {
                        float tmp = 0;
                        SumModel m = new SumModel(d,tmp,tmp,tmp,tmp,tmp);
                        dataL.add(m);
                    } else {
                        if(dataL.get(i).day.compareTo(d) != 0) {
                            float tmp = 0;
                            SumModel m = new SumModel(d,tmp,tmp,tmp,tmp,tmp);
                            dataL.add(i,m);
                        }
                    }
                    d = DateHelper.getFutureDateOfTheDate(d,1);
                    if(d.compareTo(endDate) > 0) {
                        break;
                    }
                }

                dataList = dataL;
                callback.getData(true);
            }
        });
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

    public ArrayList<LocalDate> getDayList() {
        ArrayList<LocalDate> list = new ArrayList<>();
        for(SumModel m : dataList) {
            list.add(m.day);
        }
        return list;
    }

    public ArrayList<String> getWeekList() {
        ArrayList<String> returnVal = new ArrayList<>();
        for(SumModel m : dataList) {
            returnVal.add(DateHelper.getWeekByString(DateHelper.getStringByDate(m.day)).getString());
        }
        return returnVal;
    }

    public ArrayList<Float> getPriceList() {
        ArrayList<Float> list = new ArrayList<>();
        for(SumModel m : dataList) {
            list.add(m.price);
        }
        return list;
    }

    public ArrayList<Float> getCalorieList() {
        ArrayList<Float> list = new ArrayList<>();
        for(SumModel m : dataList) {
            list.add(m.calorie);
        }
        return list;
    }

    public ArrayList<Float> getProteinList() {
        ArrayList<Float> list = new ArrayList<>();
        for(SumModel m : dataList) {
            list.add(m.protein);
        }
        return list;
    }

    public ArrayList<Float> getFatList() {
        ArrayList<Float> list = new ArrayList<>();
        for(SumModel m : dataList) {
            list.add(m.fat);
        }
        return list;
    }

    public ArrayList<Float> getCarbsList() {
        ArrayList<Float> list = new ArrayList<>();
        for(SumModel m : dataList) {
            list.add(m.carbs);
        }
        return list;
    }

    public ArrayList<SumModel> getAllList() {
        return dataList;
    }

    public UserGoalEntity getUserGoalEntity(){
        return userGoalEntity;
    }

}
