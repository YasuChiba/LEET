package com.leet.leet.screen.statistics.screen.weekly.model;

import com.leet.leet.utils.DateHelper;
import com.leet.leet.utils.database.FirebaseDBCallaback;
import com.leet.leet.utils.database.FirebaseDBUserDataHelper;
import com.leet.leet.utils.database.entities.menu.MenuEntity;

import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by YasuhiraChiba on 2017/11/07.
 */

public class StatisticsWeeklyModel {

    private ArrayList<String> weekList = new ArrayList<String>();
    private ArrayList<Float> priceList = new ArrayList<Float>();
    private ArrayList<Float> calorieList = new ArrayList<Float>();
    private ArrayList<Float> proteinList = new ArrayList<Float>();
    private ArrayList<Float> fatList = new ArrayList<Float>();
    private ArrayList<Float> carbsList = new ArrayList<Float>();


    public void setDataTest() {
        MenuEntity ent = new MenuEntity();
        ent.setName("TTasdsda0");
        ent.setPrice(200);
        FirebaseDBUserDataHelper.setStatisticsData(DateHelper.getCurrentDate(),ent);
    }

    public void getStatisticsData(final LocalDate startDate,
                                  final LocalDate endDate,
                                  final FirebaseDBCallaback<Boolean> callback) {

        FirebaseDBUserDataHelper.getStatisticsData(startDate, endDate, new FirebaseDBCallaback<HashMap<String, ArrayList<MenuEntity>>>() {
            @Override
            public void getData(HashMap<String, ArrayList<MenuEntity>> data) {

                ArrayList<String> weekL = new ArrayList<String>();
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
                    weekL.add(DateHelper.getWeekByString(DateHelper.getStringByDate(date)).getString());
                    date = DateHelper.getFutureDateOfTheDate(date,1);
                }

                priceList = priceL;
                calorieList = calorieL;
                proteinList = proteinL;
                fatList = fatL;
                carbsList = carbsL;
                weekList = weekL;

                callback.getData(true);
            }
        });
    }

    public ArrayList<String> getWeekList() {
        return weekList;
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
