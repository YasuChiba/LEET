package com.leet.leet.screen.meal.screens.sort.model;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by YasuhiraChiba on 2017/11/29.
 */

public class MealSortDialogModel {

    public ArrayList<String> getPriceArray() {
        ArrayList<String> val = new ArrayList<>();
        val.add("0~5");
        val.add("5~10");
        val.add("10~15");
        return val;
    }
}
