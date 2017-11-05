package com.leet.leet.screen.profile.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leet.leet.R;

/**
 * Created by YasuhiraChiba on 2017/11/05.
 */

public class ProfileView implements ProfileViewInterface {

    private View mRootView;

    public ProfileView(LayoutInflater inflater, ViewGroup container) {
        mRootView = inflater.inflate(R.layout.view_profile, container, false);
        initialize();
    }

    private void initialize() {

    }

    @Override
    public View getRootView() {
        return mRootView;
    }
}
