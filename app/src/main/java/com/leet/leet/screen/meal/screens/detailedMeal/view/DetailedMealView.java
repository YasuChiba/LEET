package com.leet.leet.screen.meal.screens.detailedMeal.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.leet.leet.R;

/**
 * Created by k3vn19 on 11/16/2017.
 *
 * Purpose - This class is to be used as the View for the Deatiled Menu page.
 */

public class DetailedMealView implements DetailedMealInterface, View.OnClickListener  {

    //declaration of components of view_detailed_meal.xml
    private TextView name;
    private TextView price;
    private TextView calories;
    private TextView carbs;
    private TextView totalFat;
    private TextView saturatedFat;
    private TextView protein;
    private TextView sodium;
    private TextView cholesterol;
    private TextView dietaryFiber;
    private TextView sugar;
    private TextView servingSize;
    private TextView allergens;
    private Button bAddMeal;

    private View mRootView;
    private DetailedMealListener mListener;
    private boolean isFromMeal;

    //if this view is called from Meal Result, isFromResultView should be true.
    //if called from statistics page, should be false.
    public DetailedMealView(LayoutInflater inflater, ViewGroup container,boolean isFromResultView) {
        mRootView = inflater.inflate(R.layout.view_detailed_meal, container, false);
        this.isFromMeal = isFromResultView;
        initialize();
    } //end of constructor

    //Purpose - link the global variables to the components of the .xml file
    public void initialize(){
        name = (TextView) mRootView.findViewById(R.id.meal_name);
        price = (TextView) mRootView.findViewById(R.id.price_value);
        calories = (TextView) mRootView.findViewById(R.id.calories_value);
        carbs = (TextView) mRootView.findViewById(R.id.carbs_value);
        totalFat = (TextView) mRootView.findViewById(R.id.total_fat_value);
        saturatedFat = (TextView) mRootView.findViewById(R.id.sat_fat_value);
        protein = (TextView) mRootView.findViewById(R.id.protein_value);
        sodium = (TextView) mRootView.findViewById(R.id.sodium_value);
        cholesterol = (TextView) mRootView.findViewById(R.id.cholesterol_value);
        dietaryFiber = (TextView) mRootView.findViewById(R.id.dietary_fiber_value);
        sugar = (TextView) mRootView.findViewById(R.id.sugar_value);
        servingSize = (TextView)mRootView.findViewById(R.id.serving_size_value);
        allergens = (TextView)mRootView.findViewById(R.id.allergens_value);
        bAddMeal = (Button) mRootView.findViewById(R.id.button_add_meal);

        bAddMeal.setOnClickListener(this);

        if(isFromMeal) {
            bAddMeal.setText("ADD MEAL");
        } else {
            bAddMeal.setText("DELETE MEAL");
        }
    }

    @Override
    public void setListener(DetailedMealListener listener) {
        this.mListener = listener;
    }

    @Override
    public View getRootView() {
        return mRootView;
    }

    @Override
    public void onClick(View view) {
        if(isFromMeal) {
            mListener.addMealClick();
        } else {
            mListener.deleteMealClick();
        }
    } //end of onClick

    //setter methods for TextView's
    public void setMealName(String input){ this.name.setText(input);}
    public void setPrice(float input){ this.price.setText(Float.toString(input));}
    public void setCalories(float input){ this.calories.setText(Float.toString(input));}
    public void setCarbs(float input){ this.carbs.setText(Float.toString(input));}
    public void setTotalFat(float input){ this.totalFat.setText(Float.toString(input));}
    public void setSaturatedFat(float input){ this.saturatedFat.setText(Float.toString(input));}
    public void setProtein(float input){ this.protein.setText(Float.toString(input));}
    public void setSodium(float input){ this.sodium.setText(Float.toString(input));}
    public void setCholesterol(float input){ this.cholesterol.setText(Float.toString(input));}
    public void setDietaryFiber(float input){ this.dietaryFiber.setText(Float.toString(input));}
    public void setSugar(float input){ this.sugar.setText(Float.toString(input));}
    public void setServingSize(String input){ this.servingSize.setText(input);}
    // TODO-public void setAllergens(List<String> input){ this.allergens.setText(input);}
    //for the allergens I don't know what the setText should be. Can't just set a List object.
    //Might have to iterate through the contents and concatenate the strings
} //end of class
