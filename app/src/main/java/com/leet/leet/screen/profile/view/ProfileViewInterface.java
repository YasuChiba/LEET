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
    public void setInitialData(UserProfileEntity profileEntity);
    public void switchViews();


    interface ProfileViewListener{
        void saveInfoEntity(UserInfoEntity info);
        void saveGoalEntity(UserGoalEntity goal);
        void deleteAcc();
        void setRecommended();
    }
    void setListener(ProfileViewListener listener);

}

