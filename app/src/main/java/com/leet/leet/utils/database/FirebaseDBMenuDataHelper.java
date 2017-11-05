package com.leet.leet.utils.database;

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
import java.util.HashMap;
import java.util.Map;

/**
 * Created by YasuhiraChiba on 2017/10/31.
 */

public class FirebaseDBMenuDataHelper {

    private static DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();


    public static void getMenuData(Enums.RestaurantName restaurantName,
                                   final FirebaseDBCallaback<ArrayList<MenuEntity>> callback) {

        mDatabase.child("menu")
                .child(restaurantName.getString())
                .child("11012017")
                .child("dinnerMenu")
                .addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<MenuEntity> result = new ArrayList<MenuEntity>();
                for(DataSnapshot snap :dataSnapshot.getChildren()){
                    MenuEntity ent = snap.getValue(MenuEntity.class);  //automatically parse json to object
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
}
