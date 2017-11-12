package com.leet.leet.screen.statistics.screen.daily.model;

import com.leet.leet.utils.DateHelper;
import com.leet.leet.utils.database.FirebaseDBCallaback;
import com.leet.leet.utils.database.FirebaseDBUserDataHelper;
import com.leet.leet.utils.database.entities.menu.MenuEntity;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by YasuhiraChiba on 2017/11/05.
 */

public class StatisticsDailyModel {

    public void setDataTest() {
        MenuEntity ent = new MenuEntity();
        ent.setName("TEST1");
        ent.setPrice(50);
        FirebaseDBUserDataHelper.setStatisticsData(DateHelper.getCurrentDate(),ent);
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
