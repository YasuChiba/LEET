package com.leet.leet.screen.meal.screens.ResultView;

import com.leet.leet.utils.database.entities.menu.MenuEntity;

/**
 * Created by Sam on 11/19/2017.
 */

// This interface is so MealFragment can communicate with ResultControllerFragment
public interface MealResultListener {
    void moveToDetailFragment(MenuEntity data);
    void moveToAddCustomFragment();
}
