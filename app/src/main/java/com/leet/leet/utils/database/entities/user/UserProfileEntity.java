package com.leet.leet.utils.database.entities.user;

import com.leet.leet.common.Enums;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YasuhiraChiba on 2017/11/02.
 */

public class UserProfileEntity {

    private UserGoalEntity goals;
    private UserInfoEntity info;
   /*private String name;
   private String gender;
   private String email;
   private int age;

   private float height;
   private float weight;

   //private float height;
   private float feet;
   private float inches;*/

    private List<String> allergies;


    public UserProfileEntity(){}
    public UserProfileEntity(UserGoalEntity goals, UserInfoEntity info)
    {
        this.goals = goals;
        this.info = info;
    }
    public UserGoalEntity getUserGoals() {
        return goals;
    }

    public void setUserGoals(UserGoalEntity goals) {
        this.goals = goals;
    }

    public void setUserInfo(UserInfoEntity info) {
        this.info = info;

    }

    public UserInfoEntity getUserInfo()
    {
        return this.info;
    }



}

