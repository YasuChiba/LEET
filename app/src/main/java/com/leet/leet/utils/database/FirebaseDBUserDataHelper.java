package com.leet.leet.utils.database;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.leet.leet.common.Enums;
import com.leet.leet.utils.authentication.FirebaseAuthHelper;
import com.leet.leet.utils.database.entities.menu.MenuEntity;
import com.leet.leet.utils.database.entities.user.UserProfileEntity;

import java.util.ArrayList;

/**
 * Created by YasuhiraChiba on 2017/11/04.
 */

public class FirebaseDBUserDataHelper {

    private static DatabaseReference mDatabaseRef = FirebaseDatabase.getInstance().getReference().child("user_data");


    //retrieve user profile data from database. "callback.getData" will call after finish retrieve and parse all of the data.
    //If firebase cannot load the data, "callback.error" will call and empty Array will return.
    /*public static void getUserProfile(final FirebaseDBCallaback<UserProfileEntity> callback) {

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


    }*/
    public static UserProfileEntity getUserProfile() {
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

    }

    public static void setUserProfile(UserProfileEntity userProfile) {

        mDatabaseRef.child(FirebaseAuthHelper.getUserId())
                .child(Enums.UserDataItem.UserProfile.getString())
                .setValue(userProfile);
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
                            ent.setName(snap.getKey());
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

        mDatabaseRef.child(FirebaseAuthHelper.getUserId())
                .child(Enums.UserDataItem.CustomMenus.getString())
                .child(menuName)
                .setValue(menuEntity);
    }


}
