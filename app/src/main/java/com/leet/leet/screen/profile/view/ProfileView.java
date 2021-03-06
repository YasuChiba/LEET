package com.leet.leet.screen.profile.view;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.app.AlertDialog;

import android.support.v7.widget.Toolbar;
import android.text.InputFilter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.EditText;

import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ViewSwitcher;


import com.leet.leet.R;
import com.leet.leet.common.ContextManager;
import com.leet.leet.utils.authentication.FirebaseAuthManager;
import com.leet.leet.utils.database.entities.user.UserGoalEntity;
import com.leet.leet.utils.database.entities.user.UserInfoEntity;
import com.leet.leet.utils.database.entities.user.UserProfileEntity;

/**
 * Created by YasuhiraChiba on 2017/11/05.
 */

public class ProfileView implements ProfileViewInterface, View.OnClickListener{
    EditText price;
    EditText calorie;
    EditText carbs;
    EditText protein;
    EditText fat;
    TextView email;
    EditText name;
    EditText age;
    Spinner gender;

    ProfileViewListener mListner;

    Spinner feet;
    Spinner inch;

    boolean goalsEdit = false;
    boolean accEdit = false;

    Button goals_save, acc_save, Recommended, delete;
    ViewSwitcher goals_to_acc_vs;
    ImageButton cancel_goals;



    private View mRootView;
    public ProfileView() {}
    public ProfileView(LayoutInflater inflater, ViewGroup container) {
        mRootView = inflater.inflate(R.layout.viewswitcher_test, container, false);
        initialize();
    }

    /**
     * initializing all the fields that are in the screen currently
     */
    private void initialize() {
        price = ((EditText)this.getRootView().findViewById(R.id.Price));

        calorie = ((EditText)this.getRootView().findViewById(R.id.Calorie));

        carbs = ((EditText)this.getRootView().findViewById(R.id.Carbs));

        protein = ((EditText)this.getRootView().findViewById(R.id.Protein));

        fat = ((EditText)this.getRootView().findViewById(R.id.Fat));

        email = this.getRootView().findViewById(R.id.Email);
        name = ((EditText)this.getRootView().findViewById(R.id.Name));
        age = ((EditText)this.getRootView().findViewById(R.id.Age));

        gender = ((Spinner)this.getRootView().findViewById(R.id.Gender));

        goals_save = (Button) this.getRootView().findViewById(R.id.goals_save);
        goals_save.setOnClickListener(this);
        acc_save = (Button) this.getRootView().findViewById(R.id.acc_save);
        Recommended = (Button) this.getRootView().findViewById(R.id.Recommended);
        Recommended.setOnClickListener(this);
        acc_save.setOnClickListener(this);
        delete = (Button)this.getRootView().findViewById(R.id.Delete);
        delete.setOnClickListener(this);
        cancel_goals = this.getRootView().findViewById(R.id.cancel_goals);
        cancel_goals.setOnClickListener(this);


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

    /**
     * set the default UserGoalEntity that is retrieved from the database
     * @param goals
     */
    public void setUserGoalDefaults(UserGoalEntity goals) {
        ((EditText) mRootView.findViewById(R.id.Price)).setText((String.valueOf(goals.getPrice())));
        ((EditText) mRootView.findViewById(R.id.Calorie)).setText((String.valueOf(goals.getCalorie())));
        ((EditText) mRootView.findViewById(R.id.Fat)).setText((String.valueOf(goals.getFat())));
        ((EditText) mRootView.findViewById(R.id.Carbs)).setText((String.valueOf(goals.getCarbs())));
        ((EditText) mRootView.findViewById(R.id.Protein)).setText((String.valueOf(goals.getProtein())));
    }

    /**
     * set the default userinfoentity that is retrieved from the database
     * @param acc_info
     */
    public void setUserInfoDefaults(UserInfoEntity acc_info) {
        email.setText(FirebaseAuthManager.getEmail());
        name.setText((acc_info.getName()));
        String compareValue = acc_info.getGender();
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getRootView().getContext(), R.array.whatGender, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gender.setAdapter(adapter);
        if (!compareValue.equals(null)) {
            int spinnerPosition = adapter.getPosition(compareValue);
            gender.setSelection(spinnerPosition);
        }

        age.setText((String.valueOf(acc_info.getAge())));

    }

    /**
     * creating the userinfo entity
     * @return
     */
    private UserInfoEntity createUserInfoEntity(){
        String name = this.name.getText().toString();
        String gender = this.gender.getSelectedItem().toString();
        int age = 0;
        try {age = Integer.valueOf(this.age.getText().toString()); }
        catch (Exception e) { this.age.setText("0"); }
        return new UserInfoEntity(name, gender, age, null);
    }

    /**
     * creating the user goal entity
     * @return
     */
    private UserGoalEntity createUserGoalEntity(){
        float price = 0;
        float calorie = 0;
        float carbs = 0;
        float protein = 0;
        float fat = 0;
        if(!this.price.getText().toString().isEmpty()){price = Float.valueOf(this.price.getText().toString());}
        if(!this.calorie.getText().toString().isEmpty()){calorie = Float.valueOf(this.calorie.getText().toString());}
        if(!this.carbs.getText().toString().isEmpty()){ carbs = Float.valueOf(this.carbs.getText().toString());}
        if(!this.protein.getText().toString().isEmpty()){ protein = Float.valueOf(this.protein.getText().toString());}
        if(!this.fat.getText().toString().isEmpty()){fat = Float.valueOf(this.fat.getText().toString());}
        return new UserGoalEntity(calorie, price, fat, carbs, protein);
    }

    /**
     * depending on if you are in save or edit state, disable or enable the entries
     * @param b
     */
    private void setProfileEdit(boolean b){
        name.setEnabled(b);
        age.setEnabled(b);
        gender.setEnabled(b);
    }
    /**
     * depending on if you are in save or edit state, disable or enable the entries
     * @param b
     */
    private void setGoalsEdit(boolean b){
        price.setEnabled(b);
        calorie.setEnabled(b);
        carbs.setEnabled(b);
        fat.setEnabled(b);
        protein.setEnabled(b);
    }

    private void showDeleteDialog() {
        AlertDialog deleteAlert = new AlertDialog.Builder(this.getRootView().getContext()).create();
        deleteAlert.setTitle("Delete account");
        deleteAlert.setMessage("Are you sure you want to delete your account?");
        deleteAlert.setButton(DialogInterface.BUTTON_POSITIVE,"Confirm", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                mListner.deleteAcc();
            }
        });
        deleteAlert.setButton(DialogInterface.BUTTON_NEGATIVE,"Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        deleteAlert.show();
    }

    /**
     * switching the views for the view switcher
     */
    @Override
    public void switchViews() {
        goals_to_acc_vs.showNext();
    }
    @Override
    public void setListener(ProfileViewListener listener) {
        mListner = listener;
    }

    /**
     * setting the initial data passed in from the firebase
     * @param profileEntity
     */
    public void setInitialData(UserProfileEntity profileEntity){
        if(profileEntity == null || profileEntity.getInfo() == null || profileEntity.getGoals() == null) {
            return;
        }
        setUserGoalDefaults(profileEntity.getGoals());
        setUserInfoDefaults(profileEntity.getInfo());
    }

    @Override
    public void onClick(View v) {
        Log.i("hello", "onclick");
        switch (v.getId()){
            case R.id.cancel_goals:
                mListner.discardGoalChanges();
                goals_save.setText("Edit");
                setGoalsEdit(false);
                goalsEdit = false;
                Recommended.setVisibility(View.GONE);
                cancel_goals.setVisibility(View.GONE);
                break;
            case R.id.Recommended:
                mListner.setRecommended();
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
                if(goalsEdit == false){
                    goals_save.setText("Save");
                    Recommended.setVisibility(View.VISIBLE);
                    cancel_goals.setVisibility(View.VISIBLE);
                    setGoalsEdit(true);
                    goalsEdit = true;
                }
                else {
                    goals_save.setText("Edit");
                    mListner.saveGoalEntity(createUserGoalEntity());
                    Recommended.setVisibility(View.GONE);
                    cancel_goals.setVisibility(View.GONE);
                    setGoalsEdit(false);
                    goalsEdit = false;
                }
                break;
            case R.id.Delete:
                Log.d("delete", "===============================");
                showDeleteDialog();
                break;
        }
    }
}

