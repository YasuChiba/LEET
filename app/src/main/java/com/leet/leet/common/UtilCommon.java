package com.leet.leet.common;

import android.app.Application;

/**
 * Created by YasuhiraChiba on 2017/10/31.
 */

//Application class. this class is instanciated when the app launched
public class UtilCommon extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ContextManager.onCreateApplication(getApplicationContext());
    }

}
