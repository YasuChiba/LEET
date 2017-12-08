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

    public void logout(){
        FirebaseAuthHelper.logout();
    }
    public void saveGoals(UserGoalEntity goalEntity) {
        //passing usergoalentity to the firebase
        FirebaseDBUserDataHelper.setUserGoals(goalEntity);
    }

    public void saveInfo(UserInfoEntity infoEntity) {
        //passing userinfoentity to the firebase
        FirebaseDBUserDataHelper.setUserInfo(infoEntity);
    }

    /**
     * obatining the user profile entity data via call back method
     * @param callaback
     */
    public void getUserData(final FirebaseDBCallaback<UserProfileEntity> callaback) {
        FirebaseDBUserDataHelper.getUserProfile(new FirebaseDBCallaback<UserProfileEntity>() {
            @Override
            public void getData(UserProfileEntity data) {
                callaback.getData(data);
            }
        });

    }

    /**
     * getting the user recommended values depending on age and gender
     * @param callaback
     */
    public void getUserRecommended(final FirebaseDBCallaback<UserProfileEntity> callaback) {
        FirebaseDBUserDataHelper.getUserProfile(new FirebaseDBCallaback<UserProfileEntity>() {
            @Override
            public void getData(UserProfileEntity data) {
                int recCal = 0;
                int recProtein = 0;
                int recCarbs = 130;
                int recFat = 0;
                if(data.getInfo().getGender() == "male")
                {
                    //obtain the data from the FDAHelper class
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
                //set the data's values and pass it to the callback
                data.getGoals().setCalorie(recCal);
                data.getGoals().setProtein(recProtein);
                data.getGoals().setFat(recFat);
                data.getGoals().setCarbs(recCarbs);

                callaback.getData(data);
            }
        });

    }

    public void deleteAccount(){
        //remove the user ID first
        FirebaseDBUserDataHelper.removeUserID();
        //remove the data for the user
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

}




