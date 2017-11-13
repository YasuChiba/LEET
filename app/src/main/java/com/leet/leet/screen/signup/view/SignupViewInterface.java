package com.leet.leet.screen.signup.view;

import android.view.View;

import com.leet.leet.common.ViewBaseInterface;

/**
 * Created by xinhezhang on 11/11/17.
 */

public interface SignupViewInterface extends ViewBaseInterface {

    interface SignupViewListener {
        void gotoLogin();
        boolean checkEmail(String email);
        boolean checkPassword(String password, String confirmPassword);
        void signup(String email, String password, String confirmPassword);
        void dialog(View view);
    }

    void setListener(SignupViewListener listener);
}
