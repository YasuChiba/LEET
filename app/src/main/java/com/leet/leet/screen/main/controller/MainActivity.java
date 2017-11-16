package com.leet.leet.screen.main.controller;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;

import com.leet.leet.screen.account.controller.AccountFragment;
import com.leet.leet.screen.main.model.MainModel;
import com.leet.leet.screen.main.view.MainView;
<<<<<<< HEAD
import com.leet.leet.screen.meal.MealViewInterface;
import com.leet.leet.screen.meal.screen.meal_fragment.controller.MealFragment;
=======
import com.leet.leet.screen.statistics.controller.StatisticsFragment;
import com.leet.leet.screen.statistics.screen.daily.controller.StatisticsDailyFragment;
>>>>>>> ae42e1f135f660c01a2017597b82be0e183f774e


public class MainActivity extends AppCompatActivity implements MealViewInterface {

    private MainView mView;
    private MainModel mModel;

    private Fragment[] fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mModel = new MainModel();
        mView = new MainView(LayoutInflater.from(this), null);


<<<<<<< HEAD
        AccountFragment accountFragment = new AccountFragment();
        MealFragment mealFragment = new MealFragment();


        //accountFragment.setupFragment(this);
       // MenuSearchFragment menuSearchFragment = new MenuSearchFragment();
        fragments = new Fragment[1];
       // fragments[0] = menuSearchFragment;
        fragments[0] = mealFragment;

=======
       // AccountFragment accountFragment = new AccountFragment();
     //   accountFragment.setupFragment(this);
       // MenuSearchFragment menuSearchFragment = new MenuSearchFragment();
        fragments = new Fragment[1];
       // fragments[0] = menuSearchFragment;
      //  fragments[0] = accountFragment;
        fragments[0] = new StatisticsFragment();
>>>>>>> ae42e1f135f660c01a2017597b82be0e183f774e

        mView.setupTabs(fragments,mModel.tabTitles,getSupportFragmentManager());

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
    @Override
    public void goToMenuPage(){
        ///////////code this part
    }

}
