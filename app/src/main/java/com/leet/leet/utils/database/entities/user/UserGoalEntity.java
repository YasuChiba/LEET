package com.leet.leet.utils.database.entities.user;

/**
 * Created by YasuhiraChiba on 2017/11/04.
 */

public class UserGoalEntity {

    private float calorie = 0;
    private float price = 0;
    private float fat = 0;
    private float carbs = 0;
    private float protein = 0;

    public UserGoalEntity(){}

    public UserGoalEntity(float calorie, float price, float fat, float carbs, float protein){
        this.calorie = calorie;
        this.price = price;
        this.fat = fat;
        this.carbs = carbs;
        this.protein = protein;

    }



    public float getCalorie() {
        return calorie;
    }
    public void setCalorie(float calorie) {
        this.calorie = calorie;
    }

    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }

    public float getFat() {
        return fat;
    }
    public void setFat(float fat) {
        this.fat = fat;
    }

    public float getCarbs() {
        return carbs;
    }
    public void setCarbs(float carbs) {
        this.carbs = carbs;
    }

    public float getProtein() {
        return protein;
    }
    public void setPritein(float protein) {
        this.protein = protein;
    }


}
