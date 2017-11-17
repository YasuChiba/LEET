package com.leet.leet.screen.profile.view;

import com.leet.leet.common.ViewBaseInterface;
import com.leet.leet.utils.database.entities.user.UserGoalEntity;
import com.leet.leet.utils.database.entities.user.UserInfoEntity;
import com.leet.leet.utils.database.entities.user.UserProfileEntity;

/**
 * Created by YasuhiraChiba on 2017/11/05.
 */

public interface ProfileViewInterface extends ViewBaseInterface {

    public void setUserGoalDefaults(UserGoalEntity goals);
    public void setUserInfoDefaults(UserInfoEntity acc_info);

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

