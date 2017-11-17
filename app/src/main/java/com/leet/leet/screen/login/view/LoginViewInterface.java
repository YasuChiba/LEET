package com.leet.leet.screen.login.view;

import com.leet.leet.common.ViewBaseInterface;

/**
 * Created by xinhezhang on 11/05/17.
 */

public interface LoginViewInterface extends ViewBaseInterface {

    interface LoginViewListener {
        void gotoSignup();
        void login(final String email, final String password);
        void guestLogin();
    }

    void setListener(LoginViewListener listener);
}

