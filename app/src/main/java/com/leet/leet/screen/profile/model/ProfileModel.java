package com.leet.leet.screen.profile.model;

import android.util.Log;
import android.widget.EditText;
import com.leet.leet.R;
import com.leet.leet.screen.profile.view.ProfileView;
import com.leet.leet.utils.database.FirebaseDBCallaback;
import com.leet.leet.utils.database.FirebaseDBUserDataHelper;
import com.leet.leet.utils.database.entities.user.UserGoalEntity;
import com.leet.leet.utils.database.entities.user.UserProfileEntity;

import java.util.List;

/**
 * Created by YasuhiraChiba on 2017/11/05.
 */

public class ProfileModel {
    /*EditText price;
    EditText calorie;
    EditText carbs;
    EditText protein;
    EditText fat;*/

    float price;
    float calorie;
    float carbs;
    float protein;
    float fat;
    String name;
    String gender;
    int age;
    float weight;
    float height;
    List<String> allergens;

    public void saveUserInfoData(ProfileView v){
        Log.d("data", "working");
        name =  ((EditText)v.getRootView().findViewById(R.id.name_field)).getText().toString();
        gender =  ((EditText)v.getRootView().findViewById(R.id.gender_field)).getText().toString();
        age = Integer.parseInt(((EditText) v.getRootView().findViewById(R.id.age_field)).getText().toString());
        weight =  Float.parseFloat(((EditText)v.getRootView().findViewById(R.id.weight_field)).getText().toString());
        height =  Float.parseFloat(((EditText)v.getRootView().findViewById(R.id.height_field)).getText().toString());

        final UserProfileEntity new_prof = new UserProfileEntity(name, gender, age, weight, height, allergens);
        FirebaseDBUserDataHelper.getUserGoals(new FirebaseDBCallaback<UserGoalEntity>() {
            @Override
            public void getData(UserGoalEntity data) {
                FirebaseDBUserDataHelper.setUserProfile(new_prof);
                FirebaseDBUserDataHelper.setUserGoals(data);
            }
        });

    }

    public UserProfileEntity getUserInfoData()
    {
        final UserProfileEntity[] acc_info = new UserProfileEntity[1];
        FirebaseDBUserDataHelper.getUserProfile(new FirebaseDBCallaback<UserProfileEntity>() {
            @Override
            public void getData(UserProfileEntity data) {
                acc_info[0] = data;
            }
        });

        Log.d("", acc_info[0].getName());
        return acc_info[0];
    }

    public UserGoalEntity getGoalData() {
        return new UserGoalEntity();
    }
}
