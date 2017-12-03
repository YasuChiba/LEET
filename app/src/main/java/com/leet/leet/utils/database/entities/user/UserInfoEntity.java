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


    private List<String> allergies;

    public UserInfoEntity() {}

    public UserInfoEntity(String name, String gender, String email, int age, List<String> allergies)
    {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.age = age;

        this.allergies = allergies;
    }

    public void setName(String name) { this.name = name; }
    public void setGender(String gender) { this.gender = gender; }
    public void setEmail(String email) { this.email = email; }

    public void setAllergies(List<String> allergies) {this.allergies = allergies; }

    public String getName(){ return this.name; }
    public String getGender() {return this.gender; }
    public String getEmail() { return this.email; }
    public int getAge() { return this.age; }

    public List<String> getAllergies() {return this.allergies; }
}

