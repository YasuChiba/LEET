package com.leet.leet.utils.database;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by YasuhiraChiba on 2017/11/04.
 */

//T is generics.
public abstract class FirebaseDBCallaback<T> {

    public abstract void getData(T data);

    public void error() {
        Log.d("FirebaseDB Error","cannot get data from firebase db");
    }
}
