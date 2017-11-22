package com.leet.leet.screen.meal.screens.addCustomMeal.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.leet.leet.R;

import static java.security.AccessController.getContext;

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

        mListener.addMealClick();
    }

    //Getter methods for all private member variables of this class
    //These getters are used by the controller in getting paramaters to pass into the model
    public String getPriceVal() {
            return price.getText().toString();
    }
    public String getCalVal() {
        return (calories.getText().toString());
    }
    public String getCarbsVal() {
        return (carbs.getText().toString());
    }
    public String getTotalFatVal() {
        return (totalFat.getText().toString());
    }
    public String getSatFatVal() {
        return (saturatedFat.getText().toString());
    }
    public String getProteinVal() {
        return (protein.getText().toString());
    }
    public String getSodiumVal() {
        return (sodium.getText().toString());
    }
    public String getCholesterolVal() {
        return (cholesterol.getText().toString());
    }
    public String getDietaryFiberVal() {
        return (dietaryFiber.getText().toString());
    }
    public String getSugarVal() {
        return (sugar.getText().toString());
    }
    public String getMealName() {
        return name.getText().toString();
    }

    //setter methods
    public void setNameVal(String input){
        name.setText(input);
    }
    public void setPriceVal(String input){
        price.setText(input);
    }
    public void setCalVal(String input){
        calories.setText(input);
    }
    public void setCarbsVal(String input){
        carbs.setText(input);
    }
    public void setTotalFatVal(String input){
        totalFat.setText(input);
    }
    public void setSatFatVal(String input){
        saturatedFat.setText(input);
    }
    public void setProteinVal(String input){
        protein.setText(input);
    }
    public void setSodiumVal(String input){
        sodium.setText(input);
    }
    public void setSugarVal(String input){
        sugar.setText(input);
    }
    public void setCholesterolVal(String input){
        cholesterol.setText(input);
    }
    public void setFiberVal(String input){
        dietaryFiber.setText(input);
    }


}//end of class