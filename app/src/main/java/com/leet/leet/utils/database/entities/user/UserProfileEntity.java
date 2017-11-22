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




    public UserProfileEntity(){}
    public UserProfileEntity(UserGoalEntity goals, UserInfoEntity info)
    {
        this.goals = goals;
        this.info = info;
    }
    public UserGoalEntity getGoals() {
        return goals;
    }

    public void setGoals(UserGoalEntity goals) {
        this.goals = goals;
    }

    public void setInfo(UserInfoEntity info) {
        this.info = info;

    }

    public UserInfoEntity getInfo()
    {
        return this.info;
    }



}

