package com.leet.leet.common;

import android.content.Context;

/**
 * Created by YasuhiraChiba on 2017/10/31.
 */


//singleton class for get application class.  should not use if you want activity context.
//onCreateApplication should be called in Application class. (UtilCommon class)
public class ContextManager {

    private static ContextManager singleton = null;
    private Context applicationContext;

    public static void onCreateApplication(Context applicationContext) {
        singleton = new ContextManager(applicationContext);
    }

    private ContextManager(Context applicationContext){
        this.applicationContext = applicationContext;
    }

    public static ContextManager getInstance(){
        if (singleton == null) {
            throw new RuntimeException("ContextManager should be initialized!");
        }
        return singleton;
    }

    public Context getApplicationContext() {
        return applicationContext;
    }
}
