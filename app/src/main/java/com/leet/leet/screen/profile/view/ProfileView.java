package com.leet.leet.screen.profile.view;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.leet.leet.R;

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

   ProfileViewListener mListner;

   Spinner feet;
   Spinner inch;




    private View mRootView;

    public ProfileView(LayoutInflater inflater, ViewGroup container) {
        mRootView = inflater.inflate(R.layout.view_profile, container, false);
        initialize();


    }
    public void setToDefault(){
        price.setText(String.valueOf(0));
        calorie.setText(String.valueOf(0));
        carbs.setText(String.valueOf(0));
        protein.setText(String.valueOf(0));
        fat.setText(String.valueOf(0));
        feet.setSelection(0);
        inch.setSelection(0);
        weight.setText(String.valueOf(0));
        email.setText("");
        name.setText("");
    }

    private void initialize() {
        price = ((EditText)this.getRootView().findViewById(R.id.Price));
        calorie = ((EditText)this.getRootView().findViewById(R.id.Calorie));
        carbs = ((EditText)this.getRootView().findViewById(R.id.Carbs));
        protein = ((EditText)this.getRootView().findViewById(R.id.Protein));
        fat = ((EditText)this.getRootView().findViewById(R.id.Fat));
        feet = ((Spinner)this.getRootView().findViewById(R.id.Feet));
        inch = ((Spinner)this.getRootView().findViewById(R.id.Inch));
        weight = ((EditText)this.getRootView().findViewById(R.id.Weight));
        email = ((EditText)this.getRootView().findViewById(R.id.Email));
        name = ((EditText)this.getRootView().findViewById(R.id.Name));

    }
    @Override
    public View getRootView() {
        return mRootView;
    }

    @Override
    public void setListener(ProfileViewListener listener) {
        mListner = listener;
    }

    @Override
    public void onClick(View v) {
        Log.i("hello", "onclick");
        switch (v.getId()){

            case R.id.Recommended:
                setToDefault();
                break;
            case R.id.Save:
                mListner.save(price.getText().toString(),
                        calorie.getText().toString(),
                        carbs.getText().toString(),
                        protein.getText().toString(),
                        fat.getText().toString(),
                        feet.getSelectedItem().toString(),
                        inch.getSelectedItem().toString(),
                        weight.getText().toString(),
                        email.getText().toString(),
                        name.getText().toString());
                break;
        }
    }
}
