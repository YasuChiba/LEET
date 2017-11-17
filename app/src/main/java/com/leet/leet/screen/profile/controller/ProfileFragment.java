package com.leet.leet.screen.profile.controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.leet.leet.R;
import com.leet.leet.screen.account.model.AccountModel;
import com.leet.leet.screen.account.view.AccountView;
import com.leet.leet.screen.profile.model.ProfileModel;
import com.leet.leet.screen.profile.view.ProfileView;
import com.leet.leet.screen.profile.view.ProfileViewInterface;

/**
 * Created by YasuhiraChiba on 2017/11/05.
 */

public class ProfileFragment extends Fragment implements ProfileViewInterface.ProfileViewListener{

    private ProfileView mView;
    private ProfileModel mModel;
    private Menu menu;
    private boolean inProfile = false;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mModel = new ProfileModel();
        mView = new ProfileView(inflater, container);
        mView.setListener(this);
        setHasOptionsMenu(true);
        return mView.getRootView();


    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        Log.d("", "wroking");
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
    public void save( String price,
                      String calorie,
                      String carbs,
                      String protein,
                      String fat,
                      String feet,
                      String inches,
                      String weight,
                      String email,
                      String name) {
        mModel.saveProfileData(price, calorie, carbs, protein, fat, feet, inches, weight, email, name);

    }
}
