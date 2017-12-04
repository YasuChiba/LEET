package com.leet.leet.utils.database;

import android.util.Log;
import android.view.Menu;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.leet.leet.common.Enums;
import com.leet.leet.utils.DateHelper;
import com.leet.leet.utils.authentication.FirebaseAuthHelper;
import com.leet.leet.utils.database.entities.menu.MenuEntity;
import com.leet.leet.utils.database.entities.user.UserGoalEntity;
import com.leet.leet.utils.database.entities.user.UserInfoEntity;
import com.leet.leet.utils.database.entities.user.UserProfileEntity;
import com.leet.leet.utils.database.entities.user.UserStatisticsEntity;

import org.joda.time.LocalDate;

import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by YasuhiraChiba on 2017/11/04.
 */

public class FirebaseDBUserDataHelper {

    private static DatabaseReference mDatabaseRef = FirebaseDatabase.getInstance().getReference().child("user_data");


    //retrieve user profile data from database. "callback.getData" will call after finish retrieve and parse all of the data.
    //If firebase cannot load the data, "callback.error" will call and empty Array will return.
    public static void getUserProfile(final FirebaseDBCallaback<UserProfileEntity> callback) {

        mDatabaseRef.child(FirebaseAuthHelper.getUserId())
                .child(Enums.UserDataItem.UserProfile.getString())
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        UserProfileEntity ent = dataSnapshot.getValue(UserProfileEntity.class);
                        callback.getData(ent);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        callback.error();
                    }
                });


    }
    public static void getUserGoals(final FirebaseDBCallaback<UserGoalEntity> callback) {
        mDatabaseRef.child(FirebaseAuthHelper.getUserId())
                .child(Enums.UserDataItem.UserProfile.getString())
                .child(Enums.UserProfile.goals.getString())
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        UserGoalEntity ent = dataSnapshot.getValue(UserGoalEntity.class);
                        callback.getData(ent);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        callback.error();
                    }
                });


    }
    public static void setDefaultProfileEntity(){
        UserInfoEntity infoEntity = new UserInfoEntity("", "", 0, null);
        UserGoalEntity goalEntity = new UserGoalEntity(0, 0, 0, 0, 0);
        UserProfileEntity profileEntity = new UserProfileEntity(goalEntity, infoEntity);
        setUserProfile(profileEntity);
    }
   /* public static UserProfileEntity getUserProfile() {
        final UserProfileEntity[] ent = {null};
        mDatabaseRef.child(FirebaseAuthHelper.getUserId())
                .child(Enums.UserDataItem.UserProfile.getString())
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        ent[0] = dataSnapshot.getValue(UserProfileEntity.class);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.e("callback", "getUserProfile error");
                    }
                });
        return ent[0];

    }*/

    public static void setUserProfile(UserProfileEntity userProfile) {

        mDatabaseRef.child(FirebaseAuthHelper.getUserId())
                .child(Enums.UserDataItem.UserProfile.getString())
                .setValue(userProfile);
    }

    public static void removeUserID(){
        mDatabaseRef.child(FirebaseAuthHelper.getUserId()).removeValue();

    }
    public static void setUserGoals(UserGoalEntity userGoals) {

        Log.d("", "asdfasdfasdfa");
        mDatabaseRef.child(FirebaseAuthHelper.getUserId())
            .child(Enums.UserDataItem.UserProfile.getString())
            .child(Enums.UserProfile.goals.getString())
            .setValue(userGoals);
}
    public static void setUserInfo(UserInfoEntity infoEntity){
        mDatabaseRef.child(FirebaseAuthHelper.getUserId())
                .child(Enums.UserDataItem.UserProfile.getString())
                .child(Enums.UserProfile.info.getString())
                .setValue(infoEntity);
    }

    public static void getCustomMenus(final FirebaseDBCallaback<ArrayList<MenuEntity>> callback) {

        mDatabaseRef.child(FirebaseAuthHelper.getUserId())
                .child(Enums.UserDataItem.CustomMenus.getString())
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        ArrayList<MenuEntity> result = new ArrayList<>();
                        for(DataSnapshot snap :dataSnapshot.getChildren()){
                            MenuEntity ent = snap.getValue(MenuEntity.class);
                            result.add(ent);
                        }
                        callback.getData(result);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        callback.error();
                        callback.getData(new ArrayList<MenuEntity>());
                    }
                });
    }

    public static void addCustomMenu(String menuName, MenuEntity menuEntity) {
        menuEntity.setName(menuName);
        mDatabaseRef.child(FirebaseAuthHelper.getUserId())
                .child(Enums.UserDataItem.CustomMenus.getString())
                .push()
                .setValue(menuEntity);
    }

    //return value is sorted by date
    public static void getStatisticsData(LocalDate startDate,
                                         LocalDate endDate,
                                         final FirebaseDBCallaback< ArrayList<UserStatisticsEntity>> callback) {
        String start = DateHelper.getStringByDate(startDate);
        final String end = DateHelper.getStringByDate(endDate);

        mDatabaseRef.child(FirebaseAuthHelper.getUserId())
                .child(Enums.UserDataItem.Statistics.getString())
                .child("record")
                .orderByKey()
                .startAt(start)
                .endAt(end)
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        ArrayList<UserStatisticsEntity> returnVal = new ArrayList<UserStatisticsEntity>();
                        for(DataSnapshot dateSnap : dataSnapshot.getChildren()) {
                            ArrayList<MenuEntity> breakfast = new ArrayList<>();
                            ArrayList<MenuEntity> lunch = new ArrayList<>();
                            ArrayList<MenuEntity> dinner = new ArrayList<>();

                            for(DataSnapshot menuTimeSnap : dateSnap.child(Enums.MealTime.Breakfast.getString()).getChildren()){
                                MenuEntity ent = menuTimeSnap.getValue(MenuEntity.class);
                                breakfast.add(ent);
                            }
                            for(DataSnapshot menuTimeSnap : dateSnap.child(Enums.MealTime.Lunch.getString()).getChildren()){
                                MenuEntity ent = menuTimeSnap.getValue(MenuEntity.class);
                                lunch.add(ent);
                            }
                            for(DataSnapshot menuTimeSnap : dateSnap.child(Enums.MealTime.Dinner.getString()).getChildren()){
                                MenuEntity ent = menuTimeSnap.getValue(MenuEntity.class);
                                dinner.add(ent);
                            }

                            UserStatisticsEntity ent = new UserStatisticsEntity();
                            ent.setDate(dateSnap.getKey());
                            ent.setBreakfastMenu(breakfast);
                            ent.setLunchMenu(lunch);
                            ent.setDinnerMenu(dinner);
                            returnVal.add(ent);
                        }
                        callback.getData(returnVal);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        callback.error();
                    }
                });
    }

    public static void setStatisticsData(LocalDate date, Enums.MealTime mealTime, MenuEntity menuEntity) {

        mDatabaseRef.child(FirebaseAuthHelper.getUserId())
                .child(Enums.UserDataItem.Statistics.getString())
                .child("record")
                .child(DateHelper.getStringByDate(date))
                .child(mealTime.getString())
                .push()
                .setValue(menuEntity);
    }



}
