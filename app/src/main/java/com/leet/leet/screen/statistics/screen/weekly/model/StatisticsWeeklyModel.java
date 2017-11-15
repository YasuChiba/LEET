package com.leet.leet.screen.statistics.screen.weekly.model;

import com.leet.leet.utils.DateHelper;
import com.leet.leet.utils.database.FirebaseDBCallaback;
import com.leet.leet.utils.database.FirebaseDBUserDataHelper;
import com.leet.leet.utils.database.entities.menu.MenuEntity;

import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by YasuhiraChiba on 2017/11/07.
 */

public class StatisticsWeeklyModel {

    public void setDataTest() {
        MenuEntity ent = new MenuEntity();
        ent.setName("TEST1");
        ent.setPrice(50);
        FirebaseDBUserDataHelper.setStatisticsData(DateHelper.getCurrentDate(),ent);
    }

    public void getStatisticsData(LocalDate startDate,
                                  LocalDate endDate,
                                  final FirebaseDBCallaback<HashMap<String,ArrayList>> callback) {

        FirebaseDBUserDataHelper.getStatisticsData(startDate, endDate,
                new FirebaseDBCallaback<HashMap<String, ArrayList>>() {
                    @Override
                    public void getData(HashMap<String, ArrayList> data) {




                        callback.getData(data);
                    }
                });
    }

    public void getDateTest() {
        FirebaseDBUserDataHelper.getStatisticsData(DateHelper.getCurrentDate(), DateHelper.getCurrentDate(),
                new FirebaseDBCallaback<HashMap<String, ArrayList>>() {
                    @Override
                    public void getData(HashMap<String, ArrayList> data) {
                        System.out.println(data);
                    }
                });
    }
}
