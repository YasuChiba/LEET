package com.leet.leet.screen.profile.controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ViewSwitcher;

import com.leet.leet.R;
import com.leet.leet.screen.profile.model.ProfileModel;
import com.leet.leet.screen.profile.view.ProfileView;
import com.leet.leet.screen.profile.view.ProfileViewInterface;
import com.leet.leet.utils.database.FirebaseDBCallaback;
import com.leet.leet.utils.database.entities.user.UserGoalEntity;
import com.leet.leet.utils.database.entities.user.UserInfoEntity;
import com.leet.leet.utils.database.entities.user.UserProfileEntity;

/**
 * Created by YasuhiraChiba on 2017/11/05.
 */

public class ProfileFragment extends Fragment implements ProfileViewInterface.ProfileViewListener{

    private ProfileViewInterface mView;
    private ProfileModel mModel;
    private Menu menu;
    private boolean inProfile = false;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mView = new ProfileView(inflater, container);
        mView.setListener(this);
        mModel = new ProfileModel();
        setHasOptionsMenu(true);

        mModel.getUserData(new FirebaseDBCallaback<UserProfileEntity>() {
            @Override
            public void getData(UserProfileEntity data) {
                mView.setInitialData(data);
            }
        });
        return mView.getRootView();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu, menu);
        this.menu = menu;
        super.onCreateOptionsMenu(menu,inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.logout:
                return true;
            case R.id.edit:
                mView.swithcViews();
                updateMenuTitles();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void updateMenuTitles() {
        MenuItem edit = menu.findItem(R.id.edit);
        if (inProfile) {
            edit.setTitle(R.string.editProfile);
            inProfile = false;
        } else {
            edit.setTitle(R.string.editGoals);
            inProfile = true;
        }
    }

    @Override
    public void saveInfoEntity(UserInfoEntity info) {
        mModel.saveInfo(info);
    }

    @Override
    public void saveGoalEntity(UserGoalEntity goal) {
        mModel.saveGoals(goal);
    }
}

