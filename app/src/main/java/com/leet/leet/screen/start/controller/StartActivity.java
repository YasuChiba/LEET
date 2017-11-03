package com.leet.leet.screen.start.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;

import com.leet.leet.R;
import com.leet.leet.screen.start.model.StartModel;
import com.leet.leet.screen.start.view.StartView;

public class StartActivity extends AppCompatActivity {

    private StartView mView;
    private StartModel mModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //create view and attach to activity
        mView = new StartView(LayoutInflater.from(this), null);
        setContentView(mView.getRootView());

        //create model
        mModel = new StartModel();
    }
}
