package com.leet.leet.screen.profile.model;

import android.util.Log;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.auth.UserInfo;
import com.leet.leet.R;
import com.leet.leet.common.Enums;
import com.leet.leet.screen.profile.view.ProfileView;
import com.leet.leet.utils.database.FirebaseDBCallaback;
import com.leet.leet.utils.database.FirebaseDBUserDataHelper;
import com.leet.leet.utils.database.entities.user.UserGoalEntity;
import com.leet.leet.utils.database.entities.user.UserInfoEntity;
import com.leet.leet.utils.database.entities.user.UserProfileEntity;

import java.util.List;

/**
 * Created by YasuhiraChiba on 2017/11/05.
 */

public class ProfileModel {

    /*public void saveUserInfoData(ProfileView v) {
        Log.d("data", "working");
        name = ((EditText) v.getRootView().findViewById(R.id.name_field)).getText().toString();
        gender = ((EditText) v.getRootView().findViewById(R.id.gender_field)).getText().toString();
        age = Integer.parseInt(((EditText) v.getRootView().findViewById(R.id.age_field)).getText().toString());
        weight = Float.parseFloat(((EditText) v.getRootView().findViewById(R.id.weight_field)).getText().toString());
        feet = Float.parseFloat(((EditText) v.getRootView().findViewById(R.id.height_field)).getText().toString());

        final UserInfoEntity new_info = new UserInfoEntity(name, gender, "", age, weight, feet, 0, allergens);

        FirebaseDBUserDataHelper.getUserProfile(new FirebaseDBCallaback<UserProfileEntity>() {
            @Override
            public void getData(UserProfileEntity data) {
                FirebaseDBUserDataHelper.setUserProfile(new UserProfileEntity(new UserGoalEntity(10,20,30,40,50), new_info));
            }
        });
    }*/

    public void saveGoals(UserGoalEntity goalEntity){
        FirebaseDBUserDataHelper.setUserGoals(goalEntity);
    }
    public void saveInfo(UserInfoEntity infoEntity){
        FirebaseDBUserDataHelper.setUserInfo(infoEntity);
    }

    public UserProfileEntity getUserInfoData()
    {
        final UserProfileEntity acc_info = new UserProfileEntity();
        FirebaseDBUserDataHelper.getUserProfile(new FirebaseDBCallaback<UserProfileEntity>() {
            @Override
            public void getData(UserProfileEntity data) {
                acc_info.setUserInfo(data.getUserInfo());
                acc_info.setUserGoals(data.getUserGoals());
            }
        });

        return acc_info;
    }

    public UserGoalEntity getUserGoalData() {
        return new UserGoalEntity();
    }
}



