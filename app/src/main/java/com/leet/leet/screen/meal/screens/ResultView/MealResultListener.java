package com.leet.leet.screen.meal.screens.ResultView;

import com.leet.leet.utils.database.entities.menu.MenuEntity;

/**
 * Created by Sam on 11/19/2017.
 *
 * Purpose - This interface is for methods that transition from the results page to a menu page.
 */

// This interface is so MealFragment can communicate with ResultControllerFragment
public interface MealResultListener {
    void moveToDetailFragment(MenuEntity data);
    void moveToAddCustomFragment();
}
