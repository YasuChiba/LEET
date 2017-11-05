package com.leet.leet.screen.profile.controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leet.leet.screen.account.model.AccountModel;
import com.leet.leet.screen.account.view.AccountView;
import com.leet.leet.screen.profile.model.ProfileModel;
import com.leet.leet.screen.profile.view.ProfileView;

/**
 * Created by YasuhiraChiba on 2017/11/05.
 */

public class ProfileFragment extends Fragment {

    private ProfileView mView;
    private ProfileModel mModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mModel = new ProfileModel();
        mView = new ProfileView(inflater, container);

        return mView.getRootView();
    }
}
