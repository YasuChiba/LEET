package com.leet.leet.screen.profile.view;

import com.leet.leet.common.ViewBaseInterface;

/**
 * Created by YasuhiraChiba on 2017/11/05.
 */

public interface ProfileViewInterface extends ViewBaseInterface {
    interface ProfileViewListener{
        void save( String price,
                String calorie,
                String carbs,
                String protein,
                String fat,
                String feet,
                String inches,
                String weight,
                String email,
                String name);
    }
    void setListener(ProfileViewListener listener);
}
