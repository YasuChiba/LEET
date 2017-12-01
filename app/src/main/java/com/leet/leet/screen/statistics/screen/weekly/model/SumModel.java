package com.leet.leet.screen.statistics.screen.weekly.model;

import org.joda.time.LocalDate;

/**
 * Created by YasuhiraChiba on 2017/11/30.
 */

public class SumModel {

    SumModel(LocalDate day, float price, float calorie, float protein, float fat, float carbs) {
        this.day = day;
        this.price = price;
        this.calorie = calorie;
        this.protein = protein;
        this.fat = fat;
        this.carbs = carbs;
    }
    public LocalDate day;
    public float price;
    public float calorie;
    public float protein;
    public float fat;
    public float carbs;
}