package com.leet.leet.utils.database;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.leet.leet.common.Enums;
import com.leet.leet.utils.DateHelper;
import com.leet.leet.utils.database.entities.menu.MenuEntity;

import org.joda.time.LocalDate;
import java.util.ArrayList;


/**
 * Created by YasuhiraChiba on 2017/10/31.
 */

public class FirebaseDBMenuDataHelper {

    private static DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();


    public static void getMenuData(Enums.RestaurantName restaurantName,
                                   LocalDate date,
                                   Enums.MealTime time,
                                   final FirebaseDBCallaback<ArrayList<MenuEntity>> callback) {

        String dateStrng = DateHelper.getStringByDate(date);
        Log.d("firebaseDB",dateStrng);
        Log.d("firebaseDB",time.getString());
        Log.d("firebaseDB",restaurantName.getString());

        mDatabase.child("menu")
                .child(restaurantName.getString())
                .child(dateStrng)
                .child(time.getString())
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
