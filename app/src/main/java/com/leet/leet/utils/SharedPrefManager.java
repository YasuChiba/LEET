package com.leet.leet.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by YasuhiraChiba on 2017/10/31.
 */

public class SharedPrefManager {

    private static String keyForIsFirstLaunch = "isFirstLaunch";


    //return true and set false if first launch.
    public static boolean loadIsFirstLaunch(Context context) {
        SharedPreferences prefs =  PreferenceManager.getDefaultSharedPreferences(context);

        if(prefs.getBoolean(keyForIsFirstLaunch, true) == true) {
            setIsFirstLaunch(context,false);
            return true;
        }
        return false;
    }

    private static void setIsFirstLaunch(Context context, boolean value) {
        SharedPreferences prefs =  PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(keyForIsFirstLaunch,value);
    }

}
