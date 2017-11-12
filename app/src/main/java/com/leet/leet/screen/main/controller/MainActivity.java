package com.leet.leet.screen.main.controller;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;

import com.leet.leet.screen.login.LoginInterface;
import com.leet.leet.screen.login.controller.LoginActivity;
import com.leet.leet.screen.main.model.MainModel;
import com.leet.leet.screen.main.view.MainView;
import com.leet.leet.screen.signup.controller.SignupActivity;


public class MainActivity extends AppCompatActivity {

    private MainView mView;
    private MainModel mModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mModel = new MainModel();
        mView = new MainView(LayoutInflater.from(this), null);

        //mView.setupTabs(fragments,mModel.tabTitles,getSupportFragmentManager());

        setContentView(mView.getRootView());

        // go to login page
        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);

    }
}
