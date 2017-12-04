package com.leet.leet.screen.main.view;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.leet.leet.R;
import com.leet.leet.common.ContextManager;
import com.leet.leet.common.Enums;
import com.leet.leet.screen.main.MainViewViewPagerAdapter;

/**
 * Created by YasuhiraChiba on 2017/10/31.
 */

public class MainView implements MainViewInterface, ViewPager.OnPageChangeListener {

    private View mRootView;
    private MainViewListener mListener;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar toolbar;
    private View tabProfile;
    private View tabMeal;
    private View tabStats;

    public MainView(LayoutInflater inflater, ViewGroup container, MainViewListener listener) {
        mRootView = inflater.inflate(R.layout.view_main, container, false);
        this.mListener = listener;
        initialize(inflater);
    }

    private void initialize(LayoutInflater inflater) {
        tabLayout = (TabLayout)mRootView.findViewById(R.id.tab_layout);
        viewPager = (ViewPager)mRootView.findViewById(R.id.view_pager);
        toolbar = (Toolbar)mRootView.findViewById(R.id.toolbar);

        tabProfile = inflater.inflate(R.layout.tab, null);
        tabMeal = inflater.inflate(R.layout.tab, null);
        tabStats = inflater.inflate(R.layout.tab, null);


    }

    public void setupTabs(Fragment[] fragments, String[] tabTitles,int defaultIndex, FragmentManager fm) {
        MainViewViewPagerAdapter viewPagerAdapter = new MainViewViewPagerAdapter(fm, fragments, tabTitles);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.addOnPageChangeListener(this);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setBackgroundColor(ContextCompat.getColor(ContextManager.getInstance().getApplicationContext(),R.color.base_color));

        tabLayout.getTabAt(Enums.TabPosition.Profile.getVal()).setCustomView(tabProfile);
        tabLayout.getTabAt(Enums.TabPosition.Meal.getVal()).setCustomView(tabMeal);
        tabLayout.getTabAt(Enums.TabPosition.Statistics.getVal()).setCustomView(tabStats);

        ((ImageView) tabProfile.findViewById(R.id.tab_icon)).setImageResource(R.drawable.tab_profile_icon);
        ((ImageView) tabMeal.findViewById(R.id.tab_icon)).setImageResource(R.drawable.tab_meal_icon);
        ((ImageView) tabStats.findViewById(R.id.tab_icon)).setImageResource(R.drawable.tab_stat_icon);

        ((TextView) tabProfile.findViewById(R.id.tab_textview)).setText("Setting");
        ((TextView) tabMeal.findViewById(R.id.tab_textview)).setText("Meal");
        ((TextView) tabStats.findViewById(R.id.tab_textview)).setText("Stats");

        tabLayout.getTabAt(defaultIndex).select();
    }

    @Override
    public View getRootView() {
        return mRootView;
    }

    public Toolbar getToolbar() {return toolbar;}


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

        Enums.TabPosition positionEnum = Enums.TabPosition.Meal;

        if(position == Enums.TabPosition.Profile.getVal()) {
            ((TextView) tabProfile.findViewById(R.id.tab_textview)).setVisibility(View.VISIBLE);
            ((TextView) tabMeal.findViewById(R.id.tab_textview)).setVisibility(View.GONE);
            ((TextView) tabStats.findViewById(R.id.tab_textview)).setVisibility(View.GONE);
            positionEnum = Enums.TabPosition.Profile;

        } else if(position == Enums.TabPosition.Meal.getVal()) {
            ((TextView) tabProfile.findViewById(R.id.tab_textview)).setVisibility(View.GONE);
            ((TextView) tabMeal.findViewById(R.id.tab_textview)).setVisibility(View.VISIBLE);
            ((TextView) tabStats.findViewById(R.id.tab_textview)).setVisibility(View.GONE);
            positionEnum = Enums.TabPosition.Meal;

        } else if(position == Enums.TabPosition.Statistics.getVal()) {
            ((TextView) tabProfile.findViewById(R.id.tab_textview)).setVisibility(View.GONE);
            ((TextView) tabMeal.findViewById(R.id.tab_textview)).setVisibility(View.GONE);
            ((TextView) tabStats.findViewById(R.id.tab_textview)).setVisibility(View.VISIBLE);
            positionEnum = Enums.TabPosition.Statistics;

        }


        mListener.tabChanged(positionEnum);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public void setToolbarTitle(String title) {
        ((TextView)toolbar.findViewById(R.id.toolbar_title_textview)).setText(title);
    }
}
