package com.leet.leet.screen.meal.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leet.leet.R;
import com.leet.leet.screen.meal.screens.addCustomMeal.controller.AddCustomMealFragment;

/** This class is the base view for Meal where it would control the shifting between fragments
 * Created by Jhern on 11/15/2017.
 */

public class MealView implements MealViewInterface  {

    private View mRootView;

    public MealView(LayoutInflater inflater, ViewGroup container) {
        mRootView = inflater.inflate(R.layout.view_meal, container, false); //connect the view with the meal base view
    }

    /**
     * This method is used to get the view the meal base page or shows the view_mail layout
     * @return the View of the view_mail
     */
    @Override
    public View getRootView() {
        return mRootView;
    }

    /**
     *  This method is used shift between fragments in the meal page view
     */
    public void changeContent(FragmentManager fragmentManager, Fragment fragment, boolean isAddToStack) {

        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.setCustomAnimations(
                R.anim.slide_in_right, R.anim.slide_out_left,
                R.anim.slide_in_left, R.anim.slide_out_right
        );
        ft.replace(R.id.meal_base_container, fragment);

        //if add to stack, back button works.
        if(isAddToStack) {
            ft = ft.addToBackStack(null);
        }
        ft.commit();
    }
}
