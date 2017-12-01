package com.leet.leet.screen.main.controller;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.leet.leet.R;
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
        fragments[0] = profileFragment;
        fragments[1] = mealFragment;
        fragments[2] = statisticsFragment;

        mView.setupTabs(fragments,mModel.tabTitles,1,getSupportFragmentManager());
        setContentView(mView.getRootView());

        invalidateOptionsMenu();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public void tabChanged(int position) {

    }
}
