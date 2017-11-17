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
    private float weight;

    //private float height;
    private float feet;
    private float inches;

    private List<String> allergies;

    public UserInfoEntity(String name, String gender, String email, int age, float weight, float feet, float inches, List<String> allergies)
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
    public void setWeight(float weight) {this.weight = weight; }
    public void setFeet(float feet) {this.feet = feet; }
    public void setInches(float inches) {this.inches = inches; }
    public void setAllergies(List<String> allergies) {this.allergies = allergies; }

    public String getName(){ return this.name; }
    public String getGender() {return this.gender; }
    public String getEmail() { return this.email; }
    public int getAge() { return this.age; }
    public float getWeight() {return this.weight; }
    public float getFeet() {return this.feet; }
    public float getInches() {return this.inches; }
    public List<String> getAllergies() {return this.allergies; }
}
