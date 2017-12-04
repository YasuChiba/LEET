package com.leet.leet.common;

import android.app.Application;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

import com.google.firebase.database.FirebaseDatabase;
import com.leet.leet.utils.SharedPrefManager;

import net.danlew.android.joda.JodaTimeAndroid;

/**
 * Created by YasuhiraChiba on 2017/10/31.
 */

//Application class. this class is instanciated when the app launched
public class UtilCommon extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ContextManager.onCreateApplication(getApplicationContext());
        JodaTimeAndroid.init(this);
        getDisplaySize();
    }


    private void getDisplaySize() {
        WindowManager wm = (WindowManager)getSystemService(WINDOW_SERVICE);
        Display disp = wm.getDefaultDisplay();

        Point realSize = new Point();
        disp.getRealSize(realSize);
        SharedPrefManager.saveRealDisplaySizeX(realSize.x);
        SharedPrefManager.saveRealDisplaySizeY(realSize.y);
    }

}
