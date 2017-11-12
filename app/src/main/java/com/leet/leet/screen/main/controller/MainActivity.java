package com.leet.leet.screen.main.controller;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;

import com.leet.leet.screen.account.AccountInterface;
import com.leet.leet.screen.account.controller.AccountFragment;
import com.leet.leet.screen.main.model.MainModel;
import com.leet.leet.screen.main.view.MainView;
import com.leet.leet.screen.meal.model.MealModel;
import com.leet.leet.screen.meal.controller.MealFragment;


public class MainActivity extends AppCompatActivity implements AccountInterface {

    private MainView mView;
    private MainModel mModel;

    private Fragment[] fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mModel = new MainModel();
        mView = new MainView(LayoutInflater.from(this), null);


        AccountFragment accountFragment = new AccountFragment();
        MealFragment mealFragment = new MealFragment();
        MealFragment.setupFragement(new )

        accountFragment.setupFragment(this);
       // MenuSearchFragment menuSearchFragment = new MenuSearchFragment();
        fragments = new Fragment[1];
       // fragments[0] = menuSearchFragment;
        fragments[0] = accountFragment;

        mView.setupTabs(fragments,mModel.tabTitles,getSupportFragmentManager());

        setContentView(mView.getRootView());

    }


    @Override
    public void backToLogin() {
/*
        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        */

    }

}
