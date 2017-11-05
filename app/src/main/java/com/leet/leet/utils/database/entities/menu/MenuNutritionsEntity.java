package com.leet.leet.utils.database.entities.menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by YasuhiraChiba on 2017/11/01.
 */

public class MenuNutritionsEntity {

    private float cholesterol;
    private float dietaryFiber;
    private float protein;
    private float satFat;
    private float sodium;
    private float sugars;
    private float carb;
    private float totalFat;
    private float calories;
    private String servingSize;
    private ArrayList<ArrayList<String>> allergens = new ArrayList<>();


    public MenuNutritionsEntity(){

    }

    public float getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(float cholesterol) {
        this.cholesterol = cholesterol;
    }

    public float getDietaryFiber() {
        return dietaryFiber;
    }

    public void setDietaryFiber(float dietaryFiber) {
        this.dietaryFiber = dietaryFiber;
    }

    public float getProtein() {
        return protein;
    }

    public void setProtein(float protein) {
        this.protein = protein;
    }

    public float getSatFat() {
        return satFat;
    }

    public void setSatFat(float satFat) {
        this.satFat = satFat;
    }

    public float getSodium() {
        return sodium;
    }

    public void setSodium(float sodium) {
        this.sodium = sodium;
    }

    public float getSugars() {
        return sugars;
    }

    public void setSugars(float sugars) {
        this.sugars = sugars;
    }

    public float getCarb() {
        return carb;
    }

    public void setCarb(float carb) {
        this.carb = carb;
    }

    public float getTotalFat() {
        return totalFat;
    }

    public void setTotalFat(float totalFat) {
        this.totalFat = totalFat;
    }

    public float getCalories() {
        return calories;
    }

    public void setCalories(float calories) {
        this.calories = calories;
    }

    public String getServingSize() {
        return servingSize;
    }

    public void setServingSize(String servingSize) {
        this.servingSize = servingSize;
    }

    public ArrayList<String> getAllergens() {
        return this.allergens.get(0);
    }

    public void setAllergens(ArrayList<String> name) {
        this.allergens.add(name);
    }

}

