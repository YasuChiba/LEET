package com.leet.leet.screen.main.view;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.leet.leet.R;
import com.leet.leet.screen.main.MainViewViewPagerAdapter;


/**
 * Created by YasuhiraChiba on 2017/10/31.
 */

public class MainView implements MainViewInterface, ViewPager.OnPageChangeListener {

    private View mRootView;
    private MainViewListener mListener;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    View tab1;
    View tab2;
    View tab3;

    public MainView(LayoutInflater inflater, ViewGroup container, MainViewListener listener) {
        mRootView = inflater.inflate(R.layout.view_main, container, false);
        this.mListener = listener;
        initialize(inflater);
    }

    private void initialize(LayoutInflater inflater) {
        tabLayout = (TabLayout)mRootView.findViewById(R.id.tab_layout);
        viewPager = (ViewPager)mRootView.findViewById(R.id.view_pager);

        tab1 = inflater.inflate(R.layout.tab, null);
        tab2 = inflater.inflate(R.layout.tab, null);
        tab3 = inflater.inflate(R.layout.tab, null);


    }

    public void setupTabs(Fragment[] fragments, String[] tabTitles,int defaultIndex, FragmentManager fm) {
        MainViewViewPagerAdapter viewPagerAdapter = new MainViewViewPagerAdapter(fm, fragments, tabTitles);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.addOnPageChangeListener(this);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setBackgroundColor(Color.parseColor("#e00e0e"));

        tabLayout.getTabAt(0).setCustomView(tab1);
        tabLayout.getTabAt(1).setCustomView(tab2);
        tabLayout.getTabAt(2).setCustomView(tab3);

        ((ImageView)tab1.findViewById(R.id.tab_icon)).setImageResource(R.drawable.tab_profile_icon);
        ((ImageView)tab2.findViewById(R.id.tab_icon)).setImageResource(R.drawable.tab_meal_icon);
        ((ImageView)tab3.findViewById(R.id.tab_icon)).setImageResource(R.drawable.tab_stat_icon);

        ((TextView)tab1.findViewById(R.id.tab_textview)).setText("Profile");
        ((TextView)tab2.findViewById(R.id.tab_textview)).setText("Meal");
        ((TextView)tab3.findViewById(R.id.tab_textview)).setText("Stats");

        tabLayout.getTabAt(defaultIndex).select();
    }

    @Override
    public View getRootView() {
        return mRootView;
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

        if(position == 0) {
            ((TextView)tab1.findViewById(R.id.tab_textview)).setVisibility(View.VISIBLE);
            ((TextView)tab2.findViewById(R.id.tab_textview)).setVisibility(View.GONE);
            ((TextView)tab3.findViewById(R.id.tab_textview)).setVisibility(View.GONE);
        } else if(position == 1) {
            ((TextView)tab1.findViewById(R.id.tab_textview)).setVisibility(View.GONE);
            ((TextView)tab2.findViewById(R.id.tab_textview)).setVisibility(View.VISIBLE);
            ((TextView)tab3.findViewById(R.id.tab_textview)).setVisibility(View.GONE);
        } else if(position == 2) {
            ((TextView)tab1.findViewById(R.id.tab_textview)).setVisibility(View.GONE);
            ((TextView)tab2.findViewById(R.id.tab_textview)).setVisibility(View.GONE);
            ((TextView)tab3.findViewById(R.id.tab_textview)).setVisibility(View.VISIBLE);
        }


        mListener.tabChanged(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
