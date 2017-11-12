package com.leet.leet.screen.profile.controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.leet.leet.R;
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
    Button saveButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mModel = new ProfileModel();
        mView = new ProfileView(inflater, container);
        saveButton = mView.getRootView().findViewById(R.id.Save);

        saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mModel.saveProfileData(mView);
                // Code here executes on main thread after user presses button
            }
        });
        return mView.getRootView();


    }



}
