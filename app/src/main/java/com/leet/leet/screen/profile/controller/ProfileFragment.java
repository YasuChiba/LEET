package com.leet.leet.screen.profile.controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ViewSwitcher;

import com.leet.leet.R;
import com.leet.leet.screen.profile.model.ProfileModel;
import com.leet.leet.screen.profile.view.ProfileView;
import com.leet.leet.screen.profile.view.ProfileViewInterface;

/**
 * Created by YasuhiraChiba on 2017/11/05.
 */

public class ProfileFragment extends Fragment implements ProfileViewInterface.ProfileViewListener{

    private ProfileViewInterface mView;
    private ProfileModel mModel;

    Button goals_edit, goals_save, acc_edit, acc_save, goals_to_acc;
    ViewSwitcher goals_to_acc_vs, acc_vs, goals_vs;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mModel = new ProfileModel();
        mView = new ProfileView(inflater, container);

        mView.setUserInfoDefaults(mModel.getUserInfoData());

        // Set up profile page buttons
        goals_to_acc = mView.getRootView().findViewById(R.id.goals_to_acc_butt);
        goals_edit = mView.getRootView().findViewById(R.id.goals_edit);
        goals_save = mView.getRootView().findViewById(R.id.goals_save);
        acc_edit = mView.getRootView().findViewById(R.id.acc_edit);
        acc_save = mView.getRootView().findViewById(R.id.acc_save);

        // Set up profile page viewswitchers
        goals_to_acc_vs = mView.getRootView().findViewById(R.id.goals_to_acc_vs);
        acc_vs = mView.getRootView().findViewById(R.id.acc_vs);
        goals_vs = mView.getRootView().findViewById(R.id.goals_vs);


        acc_save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mModel.saveUserInfoData((ProfileView) mView);
                acc_vs.showNext();
                // Code here executes on main thread after user presses button
            }
        });

        goals_to_acc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                goals_to_acc_vs.showNext();
            }
        });
        goals_edit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                goals_vs.showNext();
            }
        });
        goals_save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                goals_vs.showNext();
            }
        });
        acc_edit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                acc_vs.showNext();
            }
        });


        mView.setListener(this);

        return mView.getRootView();


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
