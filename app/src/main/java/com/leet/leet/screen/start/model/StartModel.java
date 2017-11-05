package com.leet.leet.screen.start.model;


import com.leet.leet.utils.SharedPrefManager;
import com.leet.leet.utils.authentication.FirebaseAuthHelper;
import com.leet.leet.utils.database.FirebaseDBCallaback;
import com.leet.leet.utils.database.FirebaseDBMenuDataHelper;
import com.leet.leet.utils.database.entities.menu.MenuEntity;

import java.util.ArrayList;

/**
 * Created by YasuhiraChiba on 2017/10/31.
 */

public class StartModel {

    public boolean isFirstLaunch() {
        return SharedPrefManager.loadIsFirstLaunch();
    }

    public boolean isLoggedIn() {
        return FirebaseAuthHelper.isLoggedIn();
    }
}
