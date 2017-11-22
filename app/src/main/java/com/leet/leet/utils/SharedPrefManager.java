package com.leet.leet.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.leet.leet.common.ContextManager;

/**
 * Created by YasuhiraChiba on 2017/10/31.
 */

//class for using shared preference
public class SharedPrefManager {


    private static SharedPreferences prefs =  PreferenceManager.getDefaultSharedPreferences(ContextManager.getInstance().getApplicationContext());
    private static SharedPreferences.Editor editor = prefs.edit();

    private final static String keyForIsFirstLaunch = "isFirstLaunch";
    private final static String keyForRealDisplaySizeX = "realDisplaySizeX";
    private final static String keyForRealDisplaySizeY = "realDisplaySizeY";


    //return true and set false if first launch.
    public static  boolean loadIsFirstLaunch() {
        if(prefs.getBoolean(keyForIsFirstLaunch, true) == true) {
            saveIsFirstLaunch(false);
            return true;
        }
        return false;
    }

    public static void saveIsFirstLaunch(boolean val) {
        editor = prefs.edit();
        editor.putBoolean(keyForIsFirstLaunch,val);
        editor.apply();
    }


    public static int loadRealDisplaySizeX() {
        return prefs.getInt(keyForRealDisplaySizeX,0);
    }

    public static void saveRealDisplaySizeX(int size) {
        editor = prefs.edit();
        editor.putInt(keyForRealDisplaySizeX,size);
        editor.apply();
    }

    public static int loadRealDisplaySizeY() {
        return prefs.getInt(keyForRealDisplaySizeY,0);
    }

    public static void saveRealDisplaySizeY(int size) {
        editor = prefs.edit();
        editor.putInt(keyForRealDisplaySizeY,size);
        editor.apply();
    }

}
