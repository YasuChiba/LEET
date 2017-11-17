package com.leet.leet.screen.meal.screens.addCustomMeal.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.leet.leet.R;

/**
 * Created by k3vn19 on 11/15/2017.
 */

//is to be used to get the input from the screen
public class AddCustomMealView implements CustomMealInterface, View.OnClickListener {

    //components of screen to get values from
    private EditText name;
    private EditText price;
    private EditText calories;
    private EditText carbs;
    private EditText totalFat;
    private EditText saturatedFat;
    private EditText protein;
    private EditText sodium;
    private EditText cholesterol;
    private EditText dietaryFiber;
    private EditText sugar;
    private Button addMeal;

    private View mRootView;
    private CustomMealListener mListener;

    public AddCustomMealView(LayoutInflater inflater, ViewGroup container) {
        mRootView = inflater.inflate(R.layout.view_add_custom_meal, container, false);

        initialize();
    } //end of constructor

    //Purpose - link the global variables to the components of the .xml file
    private void initialize() {
        name = (EditText) mRootView.findViewById(R.id.name_value);
        price = (EditText) mRootView.findViewById(R.id.price_value);
        calories = (EditText) mRootView.findViewById(R.id.calories_value);
        carbs = (EditText) mRootView.findViewById(R.id.carbs_value);
        totalFat = (EditText) mRootView.findViewById(R.id.total_fat_value);
        saturatedFat = (EditText) mRootView.findViewById(R.id.sat_fat_value);
        protein = (EditText) mRootView.findViewById(R.id.protein_value);
        sodium = (EditText) mRootView.findViewById(R.id.sodium_value);
        cholesterol = (EditText) mRootView.findViewById(R.id.cholesterol_value);
        dietaryFiber = (EditText) mRootView.findViewById(R.id.fiber_value);
        sugar = (EditText) mRootView.findViewById(R.id.sugar_value);
        addMeal = (Button) mRootView.findViewById(R.id.button_add_meal);

        addMeal.setOnClickListener(this);
    } //end of initialize

    @Override
    public void setListener(CustomMealListener listener) {
        this.mListener = listener;
    }

    @Override
    public View getRootView() {
        return mRootView;
    }

    @Override
    public void onClick(View view) {
        if (name.getText().length() > 0 && price.getText().length() > 0
                && calories.getText().length() > 0 && carbs.getText().length() > 0
                && totalFat.getText().length() > 0 && saturatedFat.getText().length() > 0
                && protein.getText().length() > 0 && sodium.getText().length() > 0
                && sugar.getText().length() > 0 && cholesterol.getText().length() > 0
                && dietaryFiber.getText().length() > 0) {
            mListener.addMealClick();
        }
    } //end of onClick

    //Getter methods for all private member variables of this class
    //These getters are used by the controller in getting paramaters to pass into the model
    public int getPriceVal() {
        return Integer.parseInt(price.getText().toString());
    }

    public int getCalVal() {
        return Integer.parseInt(calories.getText().toString());
    }

    public int getCarbsVal() {
        return Integer.parseInt(carbs.getText().toString());
    }

    public int getTotalFatVal() {
        return Integer.parseInt(totalFat.getText().toString());
    }

    public int getSatFatVal() {
        return Integer.parseInt(saturatedFat.getText().toString());
    }

    public int getProteinVal() {
        return Integer.parseInt(protein.getText().toString());
    }

    public int getSodiumVal() {
        return Integer.parseInt(sodium.getText().toString());
    }

    public int getCholesterolVal() {
        return Integer.parseInt(cholesterol.getText().toString());
    }

    public int getDietaryFiberVal() {
        return Integer.parseInt(dietaryFiber.getText().toString());
    }

    public int getSugarVal() {
        return Integer.parseInt(sugar.getText().toString());
    }

    public String getMealName() {
        return name.getText().toString();
    }

}//end of class