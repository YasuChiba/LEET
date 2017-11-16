package com.leet.leet.screen.profile.model;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.leet.leet.R;
import com.leet.leet.screen.profile.view.ProfileView;
import com.leet.leet.utils.database.FirebaseDBCallaback;
import com.leet.leet.utils.database.FirebaseDBUserDataHelper;
import com.leet.leet.utils.database.entities.user.UserGoalEntity;
import com.leet.leet.utils.database.entities.user.UserProfileEntity;

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
    float feet;
    float inches;
    float weight;
    String email;
    String name;


    public void saveProfileData( String price,
                                 String calorie,
                                 String carbs,
                                 String protein,
                                 String fat,
                                 String feet,
                                 String inches,
                                 String weight,
                                 String email,
                                 String name){
        Log.d("data", "working");
        this.price =  Float.parseFloat(price);
        this.calorie =  Float.parseFloat(calorie);
        this.carbs =  Float.parseFloat(carbs);
        this.protein =  Float.parseFloat(protein);
        this.fat =  Float.parseFloat(fat);
        this.feet =  Float.parseFloat(feet);
        this.inches = Float.parseFloat(inches);
        this.weight =  Float.parseFloat(weight);


        UserGoalEntity goal = new UserGoalEntity(this.calorie, this.price, this.fat, this.carbs, this.protein);
        FirebaseDBUserDataHelper.setUserGoals(goal);
        FirebaseDBUserDataHelper.setEmail(email);
        FirebaseDBUserDataHelper.setName(name);
        FirebaseDBUserDataHelper.setFeet(this.feet);
        FirebaseDBUserDataHelper.setInches(this.inches);
        FirebaseDBUserDataHelper.setWeight(this.weight);

        FirebaseDBUserDataHelper.getUserGoals(new FirebaseDBCallaback<UserGoalEntity>() {
            @Override
            public void getData(UserGoalEntity data) {
                Log.d("", data.getCalorie() + "");
            }
        });


    }


}
