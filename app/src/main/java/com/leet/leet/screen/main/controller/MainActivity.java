package com.leet.leet.screen.main.controller;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.leet.leet.R;
import com.leet.leet.common.Enums;
import com.leet.leet.screen.account.controller.AccountFragment;
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
import com.leet.leet.screen.main.model.MainModel;
import com.leet.leet.screen.main.view.MainView;
import com.leet.leet.screen.statistics.controller.StatisticsFragment;
import com.leet.leet.screen.statistics.screen.daily.controller.StatisticsDailyFragment;
import com.leet.leet.screen.signup.controller.SignupActivity;
import com.leet.leet.screen.start.controller.StartActivity;
import com.leet.leet.utils.authentication.FirebaseAuthManager;
import com.leet.leet.utils.database.FirebaseDBUserDataHelper;

import static com.leet.leet.utils.authentication.FirebaseAuthManager.isGuest;
import static java.security.AccessController.getContext;


public class MainActivity extends AppCompatActivity implements MainViewInterface.MainViewListener {

    private MainView mView;
    private MainModel mModel;

    Fragment[] fragments;
    ProfileFragment profileFragment;
    MealFragment mealFragment;
    StatisticsFragment statisticsFragment;

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

}
