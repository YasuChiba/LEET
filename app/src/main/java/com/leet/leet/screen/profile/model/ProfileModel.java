package com.leet.leet.screen.profile.model;

import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.leet.leet.R;
import com.leet.leet.common.Enums;
import com.leet.leet.screen.profile.controller.ProfileFragment;
import com.leet.leet.screen.profile.view.ProfileView;
import com.leet.leet.utils.authentication.FirebaseAuthHelper;
import com.leet.leet.utils.database.FDAHelper;
import com.leet.leet.utils.database.FirebaseDBCallaback;
import com.leet.leet.utils.database.FirebaseDBUserDataHelper;
import com.leet.leet.utils.database.entities.user.UserGoalEntity;
import com.leet.leet.utils.database.entities.user.UserInfoEntity;
import com.leet.leet.utils.database.entities.user.UserProfileEntity;

import java.util.List;

import static android.content.ContentValues.TAG;

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
    public void logout(){
        FirebaseAuthHelper.logout();
    }
    public void saveGoals(UserGoalEntity goalEntity) {
        FirebaseDBUserDataHelper.setUserGoals(goalEntity);
    }

    public void saveInfo(UserInfoEntity infoEntity) {
        FirebaseDBUserDataHelper.setUserInfo(infoEntity);
    }


    public void getUserData(final FirebaseDBCallaback<UserProfileEntity> callaback) {
        //final UserProfileEntity acc_info = new UserProfileEntity();
        FirebaseDBUserDataHelper.getUserProfile(new FirebaseDBCallaback<UserProfileEntity>() {
            @Override
            public void getData(UserProfileEntity data) {
                callaback.getData(data);
            }
        });

    }
    public void getUserRecommended(final FirebaseDBCallaback<UserProfileEntity> callaback) {
        //final UserProfileEntity acc_info = new UserProfileEntity();
        FirebaseDBUserDataHelper.getUserProfile(new FirebaseDBCallaback<UserProfileEntity>() {
            @Override
            public void getData(UserProfileEntity data) {
                int recCal = 0;
                int recProtein = 0;
                int recCarbs = 130;
                int recFat = 0;
                if(data.getInfo().getGender() == "male")
                {
                    recCal = FDAHelper.getMaleCalories(data.getInfo().getAge());
                    recProtein = FDAHelper.getMaleProtein(data.getInfo().getAge());
                }
                else
                {
                    recCal = FDAHelper.getFemaleCalories(data.getInfo().getAge());
                    recProtein = FDAHelper.getFemaleProtein(data.getInfo().getAge());
                }
                recFat = (recCal/36);
                recCarbs = (6*recCal/40);
                data.getGoals().setCalorie(recCal);
                data.getGoals().setProtein(recProtein);
                data.getGoals().setFat(recFat);
                data.getGoals().setCarbs(recCarbs);

                callaback.getData(data);
            }
        });

    }

    public void deleteAccount(){
        FirebaseDBUserDataHelper.removeUserID();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        user.delete()
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "User account deleted.");
                        }
                    }
                });

    }

    public UserGoalEntity getUserGoalData() {
        return new UserGoalEntity();
    }
}




