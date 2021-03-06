package com.leet.leet.utils.database.entities.menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    private List<String> allergens;


    public MenuNutritionsEntity(){} //default constructor

    public MenuNutritionsEntity(float _cholesterol, float _fiber, float _protein, float sat_Fat,
                                float _sodium, float _sugar, float _carbs, float _totalFat, float _cal,
                                String _servingSize, List<String> _allergens){

        this.cholesterol = _cholesterol;
        this.dietaryFiber = _fiber;
        this. protein = _protein;
        this.satFat = sat_Fat;
        this.sodium = _sodium;
        this.sugars = _sugar;
        this.carb = _carbs;
        this.totalFat = _totalFat;
        this.calories = _cal;
        this.servingSize = _servingSize;
        this.allergens = _allergens;
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

    public List<String> getAllergens() {
        return allergens;
    }

    public void setAllergens(List<String> allergens) {
        this.allergens = allergens;
    }
}

