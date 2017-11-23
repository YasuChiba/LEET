package com.leet.leet.screen.main.model;

import com.leet.leet.utils.authentication.FirebaseAuthHelper;

/**
 * Created by YasuhiraChiba on 2017/10/31.
 */

public class MainModel {

    public String[] tabTitles = {"statistics"};
    public boolean isLoggedIn() {
        return FirebaseAuthHelper.isLoggedIn();
    }

}
