package com.leet.leet.screen.profile.model;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
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

    public void saveProfileData(ProfileView v){
        Log.d("data", "working");
        price =  Float.parseFloat(((EditText)v.getRootView().findViewById(R.id.Price)).getText().toString());
        calorie =  Float.parseFloat(((EditText)v.getRootView().findViewById(R.id.Calorie)).getText().toString());
        carbs =  Float.parseFloat(((EditText)v.getRootView().findViewById(R.id.Carbs)).getText().toString());
        protein =  Float.parseFloat(((EditText)v.getRootView().findViewById(R.id.Protein)).getText().toString());
        fat =  Float.parseFloat(((EditText)v.getRootView().findViewById(R.id.Fat)).getText().toString());

        UserGoalEntity goal = new UserGoalEntity(calorie, price, fat, carbs, protein);
        FirebaseDBUserDataHelper.setUserGoals(goal);


    }


}
