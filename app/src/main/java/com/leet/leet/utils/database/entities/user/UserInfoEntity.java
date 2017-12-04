package com.leet.leet.utils.database.entities.user;

import java.util.List;

/**
 * Created by snail on 11/16/2017.
 */

public class UserInfoEntity {
    private String name;
    private String gender;
    private int age;


    private List<String> allergies;

    public UserInfoEntity() {}

    public UserInfoEntity(String name, String gender, int age, List<String> allergies)
    {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.allergies = allergies;
    }

    public void setName(String name) { this.name = name; }
    public void setGender(String gender) { this.gender = gender; }
    public void setAllergies(List<String> allergies) {this.allergies = allergies; }

    public String getName(){ return this.name; }
    public String getGender() {return this.gender; }
    public int getAge() { return this.age; }

    public List<String> getAllergies() {return this.allergies; }
}

