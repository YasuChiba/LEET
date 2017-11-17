package com.leet.leet.screen.signup.view;

import android.view.View;

import com.leet.leet.common.ViewBaseInterface;

/**
 * Created by xinhezhang on 11/11/17.
 */

public interface SignupViewInterface extends ViewBaseInterface {

    interface SignupViewListener {
        void gotoLogin();
        void signup(final String email, final String password, final String confirmPassword);
    }

    void setListener(SignupViewListener listener);
}
