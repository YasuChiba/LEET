package com.leet.leet.screen.meal.screens.ResultView.controller;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.leet.leet.R;
import com.leet.leet.common.Enums;
import com.leet.leet.screen.meal.screens.ResultView.MealResultListener;
import com.leet.leet.screen.meal.screens.ResultView.model.MealResultModel;
import com.leet.leet.screen.meal.screens.ResultView.view.ResultViewInterface;
import com.leet.leet.screen.meal.screens.ResultView.view.ResultView;
import com.leet.leet.screen.meal.screens.sort.MealSortDialogInterface;
import com.leet.leet.screen.meal.screens.sort.controller.MealSortDialogFragment;
import com.leet.leet.utils.DialogManager;
import com.leet.leet.utils.database.FirebaseDBCallaback;

/**
 * Created by Sam on 11/19/2017.
 */

public class ResultControllerFragment extends Fragment implements ResultViewInterface.MealResultViewListener,MealSortDialogInterface {

    MealResultModel model;
    ResultView resultView;
    private MealResultListener mListner;

    //This flag is true when MealFragment screen is shown
    private boolean isScreenShow = false;


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


    //Since Fragment cannot implement constructor with our original arguments, we should create this kind of method
    public void setupFragment(Enums.RestaurantName restaurantName,MealResultListener listener) {
        model = new MealResultModel();
        model.setCurrentRestaurantName(restaurantName);
        this.mListner = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        resultView = new ResultView(inflater, container,this);
        this.setMenuToListView();
        resultView.setupMealTimeSpinner(model.getMealTimeList(),model.getCurrentMealTime().getIndex());
        setHasOptionsMenu(true);
        return resultView.getRootView();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        if(isScreenShow) {
            inflater.inflate(R.menu.meal_search_result_view_menu, menu);
        }
       // super.onCreateOptionsMenu(menu,inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menu_search:
                MealSortDialogFragment dialogFragment = new MealSortDialogFragment();
                //pass parameters for spinners here
                dialogFragment.setupFragment(this, price_Range, calorie_Range,carbs_Range, totalFat_Range,
                        satFat_Range, protein_Range, sodium_Range, cholesterol_Range, fiber_Range, sugar_Range);
                dialogFragment.show(getFragmentManager(), "fragment_dialog");
                break;
        }

        return true;
    }

    private void setMenuToListView() {
        model.getMenu(new FirebaseDBCallaback<Boolean>() {
            @Override
            public void getData(Boolean data) {
                resultView.setupListView(model.getMenuEntityList());
            }
        });
    }

    @Override
    public void listTap(int i) {
        mListner.moveToDetailFragment(model.getMenuEntityList().get(i-1));
    }

    @Override
    public void mealTimeSelected(Enums.MealTime time) {
        model.setCurrentMealTime(time);
        setMenuToListView();
    }

    @Override
    public void dialogOkButtonTap(int priceRange, int calorieRange, int proteinRange, int carbsRange,
                                  int totFatRange, int satFatRange, int sodiumRange, int cholRange,
                                  int fiberRange, int sugarRange) {
        //record range values to eventually pass back
        price_Range = priceRange;
        calorie_Range = calorieRange;
        protein_Range = proteinRange;
        carbs_Range = carbsRange;
        totalFat_Range = totFatRange;
        satFat_Range = satFatRange;
        sodium_Range = sodiumRange;
        cholesterol_Range = cholRange;
        fiber_Range = fiberRange;
        sugar_Range = sugarRange;

        model.sort(priceRange, calorieRange, proteinRange, carbsRange, totFatRange, satFatRange,
                sodiumRange, cholRange, fiberRange, sugarRange);
        resultView.setupListView(model.getMenuEntityList());
    }

    public void isScreenShow(boolean isScreenShow) {
        this.isScreenShow = isScreenShow;
    }
}
