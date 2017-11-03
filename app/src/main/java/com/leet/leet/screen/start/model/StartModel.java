package com.leet.leet.screen.start.model;


import com.leet.leet.utils.SharedPrefManager;
import com.leet.leet.utils.authentication.FirebaseAuthManager;

/**
 * Created by YasuhiraChiba on 2017/10/31.
 */

public class StartModel {

    public boolean isFirstLaunch() {
        return SharedPrefManager.loadIsFirstLaunch();
    }

    public boolean isLoggedIn() {
        return FirebaseAuthManager.isLoggedIn();
    }
}
