package com.leet.leet.screen.main.controller;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.leet.leet.screen.account.controller.AccountFragment;
import com.leet.leet.screen.main.model.MainModel;
import com.leet.leet.screen.main.view.MainView;
import com.leet.leet.screen.meal.controller.MealFragment;
import com.leet.leet.screen.statistics.controller.StatisticsFragment;
import com.leet.leet.screen.login.LoginInterface;
import com.leet.leet.screen.login.controller.LoginActivity;
import com.leet.leet.screen.main.model.MainModel;
import com.leet.leet.screen.main.view.MainView;
import com.leet.leet.screen.statistics.controller.StatisticsFragment;
import com.leet.leet.screen.statistics.screen.daily.controller.StatisticsDailyFragment;
import com.leet.leet.screen.signup.controller.SignupActivity;
import com.leet.leet.screen.start.controller.StartActivity;
import com.leet.leet.utils.authentication.FirebaseAuthManager;


public class MainActivity extends AppCompatActivity {

    private MainView mView;
    private MainModel mModel;

    private TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mModel = new MainModel();
        mView = new MainView(LayoutInflater.from(this), null);


        MealFragment mealFragment = new MealFragment();

        Fragment[] fragments = new Fragment[2];
        fragments[0] = mealFragment;
        fragments[1] = new StatisticsFragment();

        mView.setupTabs(fragments,mModel.tabTitles,getSupportFragmentManager());
        //mView.setupTabs(fragments,mModel.tabTitles,getSupportFragmentManager());

        setContentView(mView.getRootView());

    }

/*
    @Override
    public void backToLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);

    }
    */

}
