package com.leet.leet.utils.database.entities.user;

import java.util.ArrayList;

/**
 * Created by YasuhiraChiba on 2017/11/02.
 */

public class UserProfileEntity {

    private String name;
    private String gender;
    private int age;
    private float weight;
    private float height;
    private ArrayList<ArrayList<String>> allergies = new ArrayList<>();
    private UserGoalEntity goals;


    public UserProfileEntity(){

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

    public ArrayList<String> getAllerigies() {
        return this.allergies.get(0);
    }
    public void setAllergies(ArrayList<String> allergies) {
        this.allergies.add(allergies);
    }
}
