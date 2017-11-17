package com.leet.leet.utils.database.entities.user;

import com.leet.leet.common.Enums;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YasuhiraChiba on 2017/11/02.
 */

public class UserProfileEntity {

    private UserGoalEntity goals;
    private String name;
    private String gender;
    private String email;
    private int age;

    private float height;
    private float weight;

    //private float height;
    private float feet;
    private float inches;

    private List<String> allergies;


    public UserProfileEntity(){}

    public UserProfileEntity(String name, String gender, int age, float weight, float feet, float inches, List<String> allergies) {

        this.name = name;
        this.gender = gender;
        this.age = age;
        this.weight = weight;
        this.feet = feet;
        this.inches = inches;
        this.allergies = allergies;

    }

    public String getName() {return this.name; }


    public void setName(String name) {this.name = name; }

    public String getGender() {return this.gender; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getWeight() {
        return this.weight;
    }
    public void setWeight(float weight) {
        this.weight = weight;
    }


    public float getFeet() {
        return this.feet;
    }
    public void setFeet(float feet) {
        this.feet = feet;
    }

    public float getInches() {
        return this.inches;
    }
    public void setInches(float inches) {
        this.inches = inches;
    }


    public List<String> getAllergies() {return this.allergies;  }
    public void setAllergies(List<String> allergies) {
        this.allergies = allergies;
    }
    public UserGoalEntity getUserGoals() {
        return goals;
    }

    public void setUserGoals(UserGoalEntity goals) {
        this.goals = goals;
    }




}
