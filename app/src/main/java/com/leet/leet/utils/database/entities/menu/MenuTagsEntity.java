package com.leet.leet.utils.database.entities.menu;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by YasuhiraChiba on 2017/11/01.
 */

public class MenuTagsEntity {

    private Boolean glutenFriendly;
    private Boolean vegan;
    private Boolean vegetarian;

    public MenuTagsEntity() {
    }

    public MenuTagsEntity(Boolean glutenFriendly, Boolean vegan, Boolean vegetarian){
        this.glutenFriendly = glutenFriendly;
        this.vegan = vegan;
        this.vegetarian = vegetarian;
    }

    public Boolean getGlutenFriendly() {
        return glutenFriendly;
    }

    public void setGlutenFriendly(Boolean glutenFriendly) {
        this.glutenFriendly = glutenFriendly;
    }

    public Boolean getVegan() {
        return vegan;
    }

    public void setVegan(Boolean vegan) {
        this.vegan = vegan;
    }

    public Boolean getVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(Boolean vegetarian) {
        this.vegetarian = vegetarian;
    }


}