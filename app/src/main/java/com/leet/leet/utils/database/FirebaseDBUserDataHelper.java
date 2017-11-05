package com.leet.leet.utils.database;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.leet.leet.common.Enums;
import com.leet.leet.utils.authentication.FirebaseAuthHelper;
import com.leet.leet.utils.database.entities.user.UserProfileEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by YasuhiraChiba on 2017/11/04.
 */

public class FirebaseDBUserDataHelper {

    private static DatabaseReference mDatabaseRef = FirebaseDatabase.getInstance().getReference().child("user_data");


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


    public static void setUserProfile(UserProfileEntity userProfile) {
        Map<String, Object> data = new HashMap<>();
        data.put("userProfile",userProfile);
        mDatabaseRef.child("userdata")
                .child(FirebaseAuthHelper.getUserId())
                .updateChildren(data);
    }


}
