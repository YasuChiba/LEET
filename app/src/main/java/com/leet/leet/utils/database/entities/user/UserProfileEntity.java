package com.leet.leet.utils.database.entities.user;

import com.leet.leet.common.Enums;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YasuhiraChiba on 2017/11/02.
 */

public class UserProfileEntity {

    private String name;
    private String gender;
    private int age;
    private float weight;
    private float height;
    private List<String> allergies;

    private UserGoalEntity goals;


    public UserProfileEntity(){

    }

    public UserProfileEntity(String name, String gender, int age, float weight, float height, List<String> allergies) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.allergies = allergies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getWeight() {
        return weight;
    }
    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }
    public void setHeight(float height) {
        this.height = height;
    }


    public List<String> getAllergies() {
        return allergies;
    }
    public void setAllergies(List<String> allergies) {
        this.allergies = allergies;
    }

    public UserGoalEntity getUserGoal() {
        return goals;
    }
    public void setUserGoals(UserGoalEntity goals) {
        this.goals = goals;
    }


}
