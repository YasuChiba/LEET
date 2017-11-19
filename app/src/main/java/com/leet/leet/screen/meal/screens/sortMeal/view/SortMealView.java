package com.leet.leet.screen.meal.screens.sortMeal.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.leet.leet.R;

/**
 * Created by k3vn19 on 11/19/2017.
 *
 * This class acts as the View for the Sort Menu Options Page.
 */

public class SortMealView implements SortMealInterface, View.OnClickListener  {

    //components of view_sort_options.xml
    private TextView priceMin;
    private TextView caloriesMin;
    private TextView carbsMin;
    private TextView fatMin;
    private TextView proteinMin;
    private TextView sugarMin;
    private TextView priceMax;
    private TextView caloriesMax;
    private TextView carbsMax;
    private TextView fatMax;
    private TextView proteinMax;
    private TextView sugarMax;
    private Button sortSubmit;

    private View mRootView;
    private SortMealListener mListener;

    //constructor
    public SortMealView(LayoutInflater inflater, ViewGroup container) {
        mRootView = inflater.inflate(R.layout.view_sort_options, container, false);

        initialize();
    } //end of constructor

    //Purpose - link the global variables to the components of the view_sort_options.xml file
    public void initialize(){
        priceMin = (TextView) mRootView.findViewById(R.id.price_min);
        caloriesMin = (TextView) mRootView.findViewById(R.id.calories_min);
        carbsMin = (TextView) mRootView.findViewById(R.id.carbs_min);
        fatMin = (TextView) mRootView.findViewById(R.id.fat_min);
        proteinMin = (TextView) mRootView.findViewById(R.id.protein_min);
        sugarMin = (TextView) mRootView.findViewById(R.id.sugar_min);
        priceMax = (TextView) mRootView.findViewById(R.id.price_max);
        caloriesMax = (TextView) mRootView.findViewById(R.id.calories_max);
        carbsMax = (TextView) mRootView.findViewById(R.id.carbs_max);
        fatMax = (TextView) mRootView.findViewById(R.id.fat_max);
        proteinMax = (TextView) mRootView.findViewById(R.id.protein_max);
        sugarMax = (TextView) mRootView.findViewById(R.id.sugar_max);

        sortSubmit = (Button) mRootView.findViewById(R.id.sortButton);
        sortSubmit.setOnClickListener(this);
    }

    @Override
    public void setListener(SortMealListener listener) {
        this.mListener = listener;
    }

    @Override
    public View getRootView() {
        return mRootView;
    }

    @Override
    public void onClick(View view) {
        //sort the search results
        mListener.sort();
    } //end of onClick


    //getter methods for price min and max
    public int getPriceMin(){
        if(!(priceMin.getText().length() > 0)){
            return -1;
        }
        return Integer.parseInt(priceMin.getText().toString());
    }
    public int getPriceMax(){
        if(!(priceMax.getText().length() > 0)){
            return -1;
        }
        return Integer.parseInt(priceMax.getText().toString());
    }

    //getter methods for calories min and max
    public int getCaloriesMin(){
        if(!(caloriesMin.getText().length() > 0)){
            return -1;
        }
        return Integer.parseInt(caloriesMin.getText().toString());
    }
    public int getCaloriesMax(){
        if(!(caloriesMax.getText().length() > 0)){
            return -1;
        }
        return Integer.parseInt(caloriesMax.getText().toString());
    }

    //getter methods for carbs min and max
    public int getCarbsMin(){
        if(!(carbsMin.getText().length() > 0)){
            return -1;
        }
        return Integer.parseInt(carbsMin.getText().toString());
    }
    public int getCarbsMax(){
        if(!(carbsMax.getText().length() > 0)){
            return -1;
        }
        return Integer.parseInt(carbsMax.getText().toString());
    }

    //getter methods for fat min and max
    public int getFatMin(){
        if(!(fatMin.getText().length() > 0)){
            return -1;
        }
        return Integer.parseInt(fatMin.getText().toString());
    }
    public int getFatMax(){
        if(!(fatMax.getText().length() > 0)){
            return -1;
        }
        return Integer.parseInt(fatMax.getText().toString());
    }

    //getter methods for protein min and max
    public int getProteinMin(){
        if(!(proteinMin.getText().length() > 0)){
            return -1;
        }
        return Integer.parseInt(proteinMin.getText().toString());
    }
    public int getProteinMax(){
        if(!(proteinMax.getText().length() > 0)){
            return -1;
        }
        return Integer.parseInt(proteinMax.getText().toString());
    }

    //getter methods for sugar min and max
    public int getSugarMin(){
        if(!(sugarMin.getText().length() > 0)){
            return -1;
        }
        return Integer.parseInt(sugarMin.getText().toString());
    }
    public int getSugarMax(){
        if(!(sugarMax.getText().length() > 0)){
            return -1;
        }
        return Integer.parseInt(sugarMax.getText().toString());
    }

} //end of class
