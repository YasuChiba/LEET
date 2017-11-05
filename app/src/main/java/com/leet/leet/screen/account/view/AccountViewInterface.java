package com.leet.leet.screen.account.view;


import com.leet.leet.common.ViewBaseInterface;

/**
 * Created by YasuhiraChiba on 2017/10/31.
 */

public interface AccountViewInterface extends ViewBaseInterface {

    interface AccountViewListener {
          void logoutClick();
    }

    void setListener(AccountViewListener listener);
}
