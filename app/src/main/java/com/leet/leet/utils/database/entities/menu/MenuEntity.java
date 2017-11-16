package com.leet.leet.utils.database.entities.menu;

/**
 * Created by YasuhiraChiba on 2017/10/31.
 */

public class MenuEntity {

    private String name = "";
    private MenuNutritionsEntity nutritions;
    private float price;
    private MenuTagsEntity tags;

    public MenuEntity(){} //default constructor

    public MenuEntity(String name, MenuNutritionsEntity nutritions, float price, MenuTagsEntity tags){
        this.name = name;
        this.nutritions = nutritions;
        this.price = price;
        this.tags = tags;
    }

    public MenuNutritionsEntity getNutritions() {
        return nutritions;
    }
    public void setNutritions(MenuNutritionsEntity nutritions) {
        this.nutritions = nutritions;
    }

    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }

    public MenuTagsEntity getTags() {
        return tags;
    }
    public void setTags(MenuTagsEntity tags) {
        this.tags = tags;
    }


    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

}