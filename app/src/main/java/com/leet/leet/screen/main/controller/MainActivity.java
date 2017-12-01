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
import com.leet.leet.screen.account.controller.AccountFragment;
import com.leet.leet.screen.main.model.MainModel;
import com.leet.leet.screen.main.view.MainView;
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


public class MainActivity extends AppCompatActivity {

    private MainView mView;
    private MainModel mModel;

    private TextView message;
    protected Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mModel = new MainModel();
        mView = new MainView(LayoutInflater.from(this), null);

        Fragment[] fragments = new Fragment[3];
        MealFragment mealFragment = new MealFragment();
        ProfileFragment profileFragment = new ProfileFragment();

        fragments[0] = profileFragment;
        fragments[1] = mealFragment;
        fragments[2] = new StatisticsFragment();

        mView.setupTabs(fragments,mModel.tabTitles,1,getSupportFragmentManager());
        //mView.setupTabs(fragments,mModel.tabTitles,getSupportFragmentManager());

        setContentView(mView.getRootView());

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        invalidateOptionsMenu();
        setSupportActionBar(toolbar);

        if (isGuest()) {
            TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
            LinearLayout tab = (LinearLayout) tabLayout.getChildAt(0);
            for (int i = 0; i < tab.getChildCount(); i++) {
                // disable the tabs
                //tab.getChildAt(i).setClickable(false);
                //tab.getChildAt(i).setEnabled(false);
            }
            tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    // when user click on "profile" or "statistics" tab
                    // it will go to a new page ask user to login or signup
                    if (tab.getPosition() == 0 || tab.getPosition() == 2) {
                        Toast.makeText(getApplicationContext(), "Please login first", Toast.LENGTH_SHORT).show();
                        gotoSignup();
                    }
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });
            //Toast.makeText(this, "Please login first", Toast.LENGTH_SHORT).show();
        }
    }

    private void gotoSignup() {
        startActivity(new Intent(this, SignupActivity.class));
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
