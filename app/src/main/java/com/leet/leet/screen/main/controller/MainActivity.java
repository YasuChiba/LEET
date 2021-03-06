package com.leet.leet.screen.main.controller;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Toast;

import com.leet.leet.R;
import com.leet.leet.common.Enums;
import com.leet.leet.screen.main.model.MainModel;
import com.leet.leet.screen.main.view.MainView;
import com.leet.leet.screen.main.view.MainViewInterface;
import com.leet.leet.screen.meal.controller.MealFragment;
import com.leet.leet.screen.statistics.controller.StatisticsFragment;
import com.leet.leet.screen.main.model.MainModel;
import com.leet.leet.screen.main.view.MainView;
import com.leet.leet.screen.profile.controller.ProfileFragment;
import com.leet.leet.screen.login.LoginInterface;
import com.leet.leet.screen.login.controller.LoginActivity;
import com.leet.leet.screen.signup.controller.SignupActivity;
import com.leet.leet.utils.authentication.FirebaseAuthManager;



public class MainActivity extends AppCompatActivity implements MainViewInterface.MainViewListener {

    private MainView mView;
    private MainModel mModel;

    private Fragment[] fragments;
    private ProfileFragment profileFragment;
    private MealFragment mealFragment;
    private StatisticsFragment statisticsFragment;
    private Enums.TabPosition currentTabPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mModel = new MainModel();
        mView = new MainView(LayoutInflater.from(this), null,this);

        fragments = new Fragment[3];
        mealFragment = new MealFragment();
        profileFragment = new ProfileFragment();
        statisticsFragment = new StatisticsFragment();
        fragments[Enums.TabPosition.Profile.getVal()] = profileFragment;
        fragments[Enums.TabPosition.Meal.getVal()] = mealFragment;
        fragments[Enums.TabPosition.Statistics.getVal()] = statisticsFragment;

        mView.setupTabs(fragments,mModel.tabTitles,1,getSupportFragmentManager());
        currentTabPosition = Enums.TabPosition.Meal;
        setContentView(mView.getRootView());

        invalidateOptionsMenu();
        setSupportActionBar(mView.getToolbar());
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mView.setToolbarTitle(getString(R.string.app_name));
    }

    private void gotoSignup() {
        startActivity(new Intent(this, SignupActivity.class));
    }

    private void gotoLogin() {
        startActivity(new Intent(this, LoginActivity.class));
    }

    private void gotoMain() {
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    public void tabChanged(Enums.TabPosition position) {
        if (FirebaseAuthManager.isGuest() && (position == Enums.TabPosition.Profile ||position == Enums.TabPosition.Statistics)) {
            Toast.makeText(getApplicationContext(), "Please login first", Toast.LENGTH_SHORT).show();
            //gotoSignup();
            gotoLogin();
        }

        currentTabPosition = position;
        if(position == Enums.TabPosition.Profile) {
            profileFragment.isScreenShow(true);
            mealFragment.isScreenShow(false);

        } else if(position == Enums.TabPosition.Meal) {
            profileFragment.isScreenShow(false);
            mealFragment.isScreenShow(true);


        } else if(position == Enums.TabPosition.Statistics) {
            profileFragment.isScreenShow(false);
            mealFragment.isScreenShow(false);

        }

    }

    @Override
    public void onBackPressed() {
        Fragment fragment;

        if(currentTabPosition == Enums.TabPosition.Profile) {
            fragment = profileFragment;
        } else if(currentTabPosition == Enums.TabPosition.Meal){
            fragment = mealFragment;
        } else {
            fragment = statisticsFragment;
        }

        if(fragment.getChildFragmentManager().getBackStackEntryCount() == 0) {
            super.onBackPressed();
        } else {
            fragment.getChildFragmentManager().popBackStack();
        }
    }

}
