package com.leet.leet.screen.main.model;

import com.leet.leet.utils.authentication.FirebaseAuthHelper;

/**
 * Created by YasuhiraChiba on 2017/10/31.
 */

public class MainModel {

<<<<<<< HEAD
    public String[] tabTitles = {"profile", "statistics"};
=======
    public String[] tabTitles = {"profile","statistics"};
>>>>>>> 60dafc0113775718dd102cf4a88014f4d47d62a1
    public boolean isLoggedIn() {
        return FirebaseAuthHelper.isLoggedIn();
    }

}
