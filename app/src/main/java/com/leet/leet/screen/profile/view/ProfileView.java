package com.leet.leet.screen.profile.view;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.leet.leet.R;
import com.leet.leet.utils.database.entities.user.UserGoalEntity;
import com.leet.leet.utils.database.entities.user.UserProfileEntity;

import org.w3c.dom.Text;

/**
 * Created by YasuhiraChiba on 2017/11/05.
 */

public class ProfileView implements ProfileViewInterface {

    private View mRootView;

    public ProfileView(LayoutInflater inflater, ViewGroup container) {
        mRootView = inflater.inflate(R.layout.viewswitcher_test, container, false);
        initialize();

    }

    private void initialize() {
    }
    @Override
    public View getRootView() {
        return mRootView;
    }

    public void setUserGoalDefaults(UserGoalEntity goals) {
        ((EditText) mRootView.findViewById(R.id.Price)).setText((String.valueOf(goals.getPrice())));
        ((EditText) mRootView.findViewById(R.id.Calorie)).setText((String.valueOf(goals.getCalorie())));
        ((EditText) mRootView.findViewById(R.id.Fat)).setText((String.valueOf(goals.getFat())));
        ((EditText) mRootView.findViewById(R.id.Carbs)).setText((String.valueOf(goals.getCarbs())));
        ((EditText) mRootView.findViewById(R.id.Protein)).setText((String.valueOf(goals.getProtein())));
    }

    public void setUserInfoDefaults(UserProfileEntity acc_info) {
        ((TextView) mRootView.findViewById(R.id.name_disp)).setText((acc_info.getName()));
        ((TextView) mRootView.findViewById(R.id.gender_disp)).setText((String.valueOf(acc_info.getGender())));
        ((TextView) mRootView.findViewById(R.id.age_disp)).setText((String.valueOf(acc_info.getAge())));
        ((TextView) mRootView.findViewById(R.id.weight_disp)).setText((String.valueOf(acc_info.getWeight())));
        ((TextView) mRootView.findViewById(R.id.height_disp)).setText((String.valueOf(acc_info.getHeight())));
    }
}
