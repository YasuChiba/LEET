package com.leet.leet.screen.main.view;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leet.leet.R;
import com.leet.leet.screen.main.MainViewViewPagerAdapter;
import android.graphics.Color;

/**
 * Created by YasuhiraChiba on 2017/10/31.
 */

public class MainView implements MainViewInterface {

    private View mRootView;

    private TabLayout tabLayout;
    private ViewPager viewPager;

    public MainView(LayoutInflater inflater, ViewGroup container) {
        mRootView = inflater.inflate(R.layout.view_main, container, false);
        initialize();
    }

    private void initialize() {
        tabLayout = (TabLayout)mRootView.findViewById(R.id.tab_layout);
        viewPager = (ViewPager)mRootView.findViewById(R.id.view_pager);
    }

    public void setupTabs(Fragment[] fragments, String[] tabTitles,int defaultIndex, FragmentManager fm) {
        MainViewViewPagerAdapter viewPagerAdapter = new MainViewViewPagerAdapter(fm, fragments, tabTitles);
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setBackgroundColor(Color.parseColor("#FFA500"));
        tabLayout.getTabAt(defaultIndex).select();
    }

    @Override
    public View getRootView() {
        return mRootView;
    }
}
