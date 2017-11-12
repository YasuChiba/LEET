package com.leet.leet.screen.main.controller;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;

import com.leet.leet.screen.main.model.MainModel;
import com.leet.leet.screen.main.view.MainView;
import com.leet.leet.screen.profile.controller.ProfileFragment;


public class MainActivity extends AppCompatActivity {

    private MainView mView;
    private MainModel mModel;

    private Fragment[] fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mModel = new MainModel();
        mView = new MainView(LayoutInflater.from(this), null);


        ProfileFragment profileFragment = new ProfileFragment();
       // MenuSearchFragment menuSearchFragment = new MenuSearchFragment();
        fragments = new Fragment[1];
       // fragments[0] = menuSearchFragment;
        fragments[0] = profileFragment;

        mView.setupTabs(fragments,mModel.tabTitles,getSupportFragmentManager());

        setContentView(mView.getRootView());
    }




}
