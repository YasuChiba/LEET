package com.leet.leet.screen.meal.screens.sort.view;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.leet.leet.R;

import java.util.ArrayList;

/**
 * Created by YasuhiraChiba on 2017/11/29.
 */

public class MealSortView implements MealSortDialogViewInterface,AdapterView.OnItemSelectedListener{
    private View mRootView;
    private MealSortDialogViewListener mListener;

    //Spinners from xml file
    private Spinner priceSpinner;
    private Spinner calorieSpinner;
    private Spinner proteinSpinner;
    private Spinner carbsSpinner;
    private Spinner totFatSpinner;
    private Spinner satFatSpinner;
    private Spinner sodiumSpinner;
    private Spinner cholesterolSpinner;
    private Spinner fiberSpinner;
    private Spinner sugarSpinner;

    //used to store index of range within string array of each spinner
    private int price_Range;
    private int calorie_Range;
    private int carbs_Range;
    private int totalFat_Range;
    private int satFat_Range;
    private int protein_Range;
    private int sodium_Range;
    private int cholesterol_Range;
    private int fiber_Range;
    private int sugar_Range;

    public MealSortView(LayoutInflater inflater,MealSortDialogViewListener listener, int priceRange,
                        int calorieRange, int carbsRange, int totalFatRange, int satFatRange,
                        int proteinRange, int sodiumRange, int cholRange, int fiberRange,
                        int sugarRange) {
        mRootView = inflater.inflate(R.layout.dialog_view_meal_sort, null);
        this.mListener = listener;

        //this is done so that the view has the last selected ranges
        price_Range = priceRange;
        calorie_Range = calorieRange;
        protein_Range = proteinRange;
        carbs_Range = carbsRange;
        totalFat_Range = totalFatRange;
        satFat_Range = satFatRange;
        sodium_Range = sodiumRange;
        cholesterol_Range = cholRange;
        fiber_Range = fiberRange;
        sugar_Range = sugarRange;

        initialize();

    }

    private void initialize() {
        priceSpinner = mRootView.findViewById(R.id.meal_sort_price_spinner);
        priceSpinner.setSelection(price_Range);//sets the original spinner value, in this case it's the last value
        priceSpinner.setOnItemSelectedListener(this); //sets listener for any changes to spinner value

        calorieSpinner = mRootView.findViewById(R.id.meal_sort_calories_spinner);
        calorieSpinner.setSelection(calorie_Range);
        calorieSpinner.setOnItemSelectedListener(this);

        proteinSpinner = mRootView.findViewById(R.id.meal_sort_protein_spinner);
        proteinSpinner.setSelection(protein_Range);
        proteinSpinner.setOnItemSelectedListener(this);

        carbsSpinner = mRootView.findViewById(R.id.meal_sort_carbs_spinner);
        carbsSpinner.setSelection(carbs_Range);
        carbsSpinner.setOnItemSelectedListener(this);

        totFatSpinner = mRootView.findViewById(R.id.meal_sort_total_fat_spinner);
        totFatSpinner.setSelection(totalFat_Range);
        totFatSpinner.setOnItemSelectedListener(this);

        satFatSpinner = mRootView.findViewById(R.id.meal_sort_sat_fat_spinner);
        satFatSpinner.setSelection(satFat_Range);
        satFatSpinner.setOnItemSelectedListener(this);

        sodiumSpinner = mRootView.findViewById(R.id.meal_sort_sodium_spinner);
        sodiumSpinner.setSelection(sodium_Range);
        sodiumSpinner.setOnItemSelectedListener(this);

        cholesterolSpinner = mRootView.findViewById(R.id.meal_sort_cholesterol_spinner);
        cholesterolSpinner.setSelection(cholesterol_Range);
        cholesterolSpinner.setOnItemSelectedListener(this);

        fiberSpinner = mRootView.findViewById(R.id.meal_sort_fiber_spinner);
        fiberSpinner.setSelection(fiber_Range);
        fiberSpinner.setOnItemSelectedListener(this);

        sugarSpinner = mRootView.findViewById(R.id.meal_sort_sugar_spinner);
        sugarSpinner.setSelection(sugar_Range);
        sugarSpinner.setOnItemSelectedListener(this);
    }//end of initialize()


    @Override
    public View getRootView() {
        return mRootView;
    }

    @Override
    /**
     * Purpose - When a spinner's value is changed this is called and the selected range is
     *           updated in the model
     */
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch(adapterView.getId()) {
            case R.id.meal_sort_price_spinner:
                mListener.priceSelected(i);
                break;
            case R.id.meal_sort_calories_spinner:
                mListener.calorieSelected(i);
                break;
            case R.id.meal_sort_carbs_spinner:
                mListener.carbsSelected(i);
                break;
            case R.id.meal_sort_cholesterol_spinner:
                mListener.cholesterolSelected(i);
                break;
            case R.id.meal_sort_fiber_spinner:
                mListener.fiberSelected(i);
                break;
            case R.id.meal_sort_total_fat_spinner:
                mListener.totalFatSelected(i);
                break;
            case R.id.meal_sort_sat_fat_spinner:
                mListener.satFatSelected(i);
                break;
            case R.id.meal_sort_protein_spinner:
                mListener.proteinSelected(i);
                break;
            case R.id.meal_sort_sodium_spinner:
                mListener.sodiumSelected(i);
                break;
            case R.id.meal_sort_sugar_spinner:
                mListener.sugarSelected(i);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {}
}
