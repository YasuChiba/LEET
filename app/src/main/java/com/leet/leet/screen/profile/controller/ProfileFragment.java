package com.leet.leet.screen.profile.controller;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.leet.leet.R;
import com.leet.leet.screen.login.controller.LoginActivity;
import com.leet.leet.screen.profile.model.ProfileModel;
import com.leet.leet.screen.profile.view.ProfileView;
import com.leet.leet.screen.profile.view.ProfileViewInterface;
import com.leet.leet.screen.signup.controller.SignupActivity;
import com.leet.leet.utils.database.FirebaseDBCallaback;
import com.leet.leet.utils.database.entities.user.UserGoalEntity;
import com.leet.leet.utils.database.entities.user.UserInfoEntity;
import com.leet.leet.utils.database.entities.user.UserProfileEntity;

import static com.leet.leet.utils.authentication.FirebaseAuthManager.isGuest;

/**
 * Created by YasuhiraChiba on 2017/11/05.
 */

/**
 * controller for the profile fragment
 */
public class ProfileFragment extends Fragment implements ProfileViewInterface.ProfileViewListener{

    private ProfileViewInterface mView;
    private ProfileModel mModel;
    private boolean inProfile = false;
    private boolean isScreenShow = false;
    private Menu menu;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = new ProfileView(inflater, container);
        mView.setListener(this);
        mModel = new ProfileModel();
        setHasOptionsMenu(true); //creates the options
        mModel.getUserData(new FirebaseDBCallaback<UserProfileEntity>() {
            @Override
            public void getData(UserProfileEntity data) {
                mView.setInitialData(data);
            }
        });

        return mView.getRootView();
    }

    /**
     * creating the options menu
     * @param menu
     * @param inflater
     */
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        if(isScreenShow) {
            inflater.inflate(R.menu.profile_view_menu, menu);
            this.menu = menu;

        }

       // super.onCreateOptionsMenu(menu,inflater);
    }

    /**
     * when the user clicks one of the opions in the menu
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.logout:
                mModel.logout();
                Intent logInIntent = new Intent(getActivity(), LoginActivity.class);
                startActivity(logInIntent);
                return true;
            case R.id.edit:
                mView.switchViews();
                updateMenuTitles(item);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     *alter the option menu when clicked
     * @param edit
     */
    private void updateMenuTitles(MenuItem edit) {
        if (inProfile) {
            edit.setTitle(R.string.editProfile);
            inProfile = false;
        } else {
            edit.setTitle(R.string.editGoals);
            inProfile = true;
        }
    }

    /**
     *Saving the user info entity
     * @param info
     */
    @Override
    public void saveInfoEntity(UserInfoEntity info) {
        mModel.saveInfo(info);
    }

    /**
     * saving the goal entitiy
     * @param goal
     */
    @Override
    public void saveGoalEntity(UserGoalEntity goal) {
        mModel.saveGoals(goal);
    }

    @Override
    public void deleteAcc() {
        mModel.deleteAccount();
        Intent logInIntent = new Intent(getActivity(), LoginActivity.class);
        startActivity(logInIntent);
    }

    /**
     * setting recommended settings by retrieving the data from firebase
     */
    @Override
    public void setRecommended() {
        mModel.getUserRecommended(new FirebaseDBCallaback<UserProfileEntity>() {
            @Override
            public void getData(UserProfileEntity data) {
                mView.setUserGoalDefaults(data.getGoals());
            }
        });
    }


    @Override
    public void discardGoalChanges() {
        mModel.getUserData(new FirebaseDBCallaback<UserProfileEntity>() {
            @Override
            public void getData(UserProfileEntity data) {
                mView.setUserGoalDefaults(data.getGoals());
            }
        });
    }

    @Override
    public void discardProfileChanges() {
        mModel.getUserData(new FirebaseDBCallaback<UserProfileEntity>() {
            @Override
            public void getData(UserProfileEntity data) {
                mView.setUserInfoDefaults(data.getInfo());
            }
        });
    }

    public void isScreenShow(boolean isScreenShow) {
        this.isScreenShow = isScreenShow;
    }
}

