package com.leet.leet.utils.database.entities.user;

import java.util.List;

/**
 * Created by snail on 11/16/2017.
 */

public class UserInfoEntity {
    private String name;
    private String gender;
    private String email;
    private int age;
    private int weight;

    //private float height;
    private int feet;
    private int inches;

    private List<String> allergies;

    public UserInfoEntity() {}

    public UserInfoEntity(String name, String gender, String email, int age, int weight, int feet, int inches, List<String> allergies)
    {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.age = age;
        this.weight = weight;
        this.feet = feet;
        this.inches = inches;
        this.allergies = allergies;
    }

    public void setName(String name) { this.name = name; }
    public void setGender(String gender) { this.gender = gender; }
    public void setEmail(String email) { this.email = email; }
    public void setAge(int age) { this.age = age; }
    public void setWeight(int weight) {this.weight = weight; }
    public void setFeet(int feet) {this.feet = feet; }
    public void setInches(int inches) {this.inches = inches; }
    public void setAllergies(List<String> allergies) {this.allergies = allergies; }

    public String getName(){ return this.name; }
    public String getGender() {return this.gender; }
    public String getEmail() { return this.email; }
    public int getAge() { return this.age; }
    public int getWeight() {return this.weight; }
    public int getFeet() {return this.feet; }
    public int getInches() {return this.inches; }
    public List<String> getAllergies() {return this.allergies; }
}

