package com.leet.leet.screen.profile.view;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.EditText;

import android.widget.Button;
import android.widget.Spinner;
import android.widget.ViewSwitcher;


import com.leet.leet.R;
import com.leet.leet.utils.database.entities.user.UserGoalEntity;
import com.leet.leet.utils.database.entities.user.UserInfoEntity;
import com.leet.leet.utils.database.entities.user.UserProfileEntity;

/**
 * Created by YasuhiraChiba on 2017/11/05.
 */

public class ProfileView implements ProfileViewInterface, View.OnClickListener {
    EditText price;
    EditText calorie;
    EditText carbs;
    EditText protein;
    EditText fat;
    EditText weight;
    EditText email;
    EditText name;
    EditText age;
    Spinner gender;

    ProfileViewListener mListner;

    Spinner feet;
    Spinner inch;

    boolean goalsEdit = false;
    boolean accEdit = false;

    Button goals_edit, goals_save, acc_edit, acc_save, Recommended;
    ViewSwitcher goals_to_acc_vs, acc_vs, goals_vs;



    private View mRootView;

    public ProfileView(LayoutInflater inflater, ViewGroup container) {
        mRootView = inflater.inflate(R.layout.viewswitcher_test, container, false);
        initialize();
    }

    private void initialize() {
        price = ((EditText)this.getRootView().findViewById(R.id.Price));
        calorie = ((EditText)this.getRootView().findViewById(R.id.Calorie));
        carbs = ((EditText)this.getRootView().findViewById(R.id.Carbs));
        protein = ((EditText)this.getRootView().findViewById(R.id.Protein));
        fat = ((EditText)this.getRootView().findViewById(R.id.Fat));
        weight = ((EditText)this.getRootView().findViewById(R.id.Weight));
        email = ((EditText)this.getRootView().findViewById(R.id.Email));
        name = ((EditText)this.getRootView().findViewById(R.id.Name));
        age = ((EditText)this.getRootView().findViewById(R.id.Age));

        feet = ((Spinner)this.getRootView().findViewById(R.id.Feet));
        inch = ((Spinner)this.getRootView().findViewById(R.id.Inch));
        gender = ((Spinner)this.getRootView().findViewById(R.id.Gender));

        goals_save = (Button) this.getRootView().findViewById(R.id.goals_save);
        goals_save.setOnClickListener(this);
        acc_save = (Button) this.getRootView().findViewById(R.id.acc_save);
        Recommended = (Button) this.getRootView().findViewById(R.id.Recommended);
        acc_save.setOnClickListener(this);

        // Set up profile page viewswitchers
        goals_to_acc_vs = (ViewSwitcher) this.getRootView().findViewById(R.id.goals_to_acc_vs);
        setProfileEdit(false);
        setGoalsEdit(false);
        setGoalsEdit(false);
        setProfileEdit(false);
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

    public void setUserInfoDefaults(UserInfoEntity acc_info) {
        email.setText((acc_info.getEmail()));
        name.setText((acc_info.getName()));
        gender.setSelection(0);
        age.setText((String.valueOf(acc_info.getAge())));
        weight.setText((String.valueOf(acc_info.getWeight())));
        feet.setSelection(0);
        inch.setSelection(0);
    }

    private UserInfoEntity createUserInfoEntity(){
        String name = this.name.getText().toString();
        String email = this.email.getText().toString();
        String gender = this.gender.getSelectedItem().toString();
        float weight = Float.valueOf(this.weight.getText().toString());
        float feet = Float.valueOf(this.feet.getSelectedItem().toString());
        float inch = Float.valueOf(this.inch.getSelectedItem().toString());
        int age = Integer.valueOf(this.age.getText().toString());
        return new UserInfoEntity(name, gender, email, age, weight, feet, inch, null);
    }

    private UserGoalEntity createUserGoalEntity(){
        float price = Float.valueOf(this.price.getText().toString());
        float calorie = Float.valueOf(this.calorie.getText().toString());
        float carbs = Float.valueOf(this.carbs.getText().toString());
        float protein = Float.valueOf(this.protein.getText().toString());
        float fat = Float.valueOf(this.fat.getText().toString());
        return new UserGoalEntity(calorie, price, fat, carbs, protein);
    }

    private void setProfileEdit(boolean b){
        name.setEnabled(b);
        email.setEnabled(b);
        age.setEnabled(b);
        gender.setEnabled(b);
        feet.setEnabled(b);
        inch.setEnabled(b);
        weight.setEnabled(b);
    }

    private void setGoalsEdit(boolean b){
        price.setEnabled(b);
        calorie.setEnabled(b);
        carbs.setEnabled(b);
        fat.setEnabled(b);
        protein.setEnabled(b);
    }


    @Override
    public void swithcViews() {
        goals_to_acc_vs.showNext();
    }

    @Override
    public void setListener(ProfileViewListener listener) {
        mListner = listener;
    }

    public void setInitialData(UserProfileEntity profileEntity){
        setUserGoalDefaults(profileEntity.getGoals());
        setUserInfoDefaults(profileEntity.getInfo());
    }

    @Override
    public void onClick(View v) {
        Log.i("hello", "onclick");
        switch (v.getId()){
            case R.id.Recommended:
                //UserGoalEntity rec = mListner.getRecommended();

                break;
            case R.id.acc_save:
                mListner.saveInfoEntity(createUserInfoEntity());
                if(accEdit == false) {
                    acc_save.setText("Save");
                    setProfileEdit(true);
                    accEdit = true;
                }
                else {
                    acc_save.setText("Edit");
                    mListner.saveInfoEntity(createUserInfoEntity());
                    setProfileEdit(false);
                    accEdit = false;
                }
                break;
            case R.id.goals_save:
                mListner.saveGoalEntity(createUserGoalEntity());
                if(goalsEdit == false){
                    goals_save.setText("Save");
                    Recommended.setVisibility(View.VISIBLE);
                    setGoalsEdit(true);
                    goalsEdit = true;
                }
                else {
                    goals_save.setText("Edit");
                    mListner.saveGoalEntity(createUserGoalEntity());
                    Recommended.setVisibility(View.GONE);
                    setGoalsEdit(false);
                    goalsEdit = false;
                }
                break;

        }
    }
}

