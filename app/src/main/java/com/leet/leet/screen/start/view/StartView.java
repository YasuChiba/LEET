package com.leet.leet.screen.start.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leet.leet.R;


/**
 * Created by YasuhiraChiba on 2017/10/31.
 */

public class StartView implements StartViewInterface {

    private View mRootView;

    public StartView(LayoutInflater inflater, ViewGroup container) {
        mRootView = inflater.inflate(R.layout.view_start, container, false);

        initialize();
    }

    private void initialize() {

    }


    @Override
    public View getRootView() {
        return mRootView;
    }


}
