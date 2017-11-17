package com.leet.leet.screen.profile.view;

import com.leet.leet.common.ViewBaseInterface;
import com.leet.leet.utils.database.entities.user.UserGoalEntity;
import com.leet.leet.utils.database.entities.user.UserProfileEntity;

/**
 * Created by YasuhiraChiba on 2017/11/05.
 */

public interface ProfileViewInterface extends ViewBaseInterface {
<<<<<<< HEAD
    public void setUserGoalDefaults(UserGoalEntity goals);
    public void setUserInfoDefaults(UserProfileEntity acc_info);
=======
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
>>>>>>> 47011931d138e81cdb15b006f48af8ac477d7c87
}

