package com.leet.leet.screen.signup.view;

import android.view.View;

import com.leet.leet.common.ViewBaseInterface;

/**
 * Created by xinhezhang on 11/11/17.
 */

public interface SignupViewInterface extends ViewBaseInterface {

    interface SignupViewListener {
        boolean checkPassword(String password, String password2);
        void signup(String username, String password);
        void dialog(View view);
    }

    void setListener(SignupViewListener listener);
}
