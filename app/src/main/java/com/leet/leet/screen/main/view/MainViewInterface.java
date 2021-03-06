package com.leet.leet.screen.main.view;

import com.leet.leet.common.Enums;
import com.leet.leet.common.ViewBaseInterface;

/**
 * Created by YasuhiraChiba on 2017/10/31.
 */

public interface MainViewInterface extends ViewBaseInterface {

    interface MainViewListener {
        void tabChanged(Enums.TabPosition position);
    }

}
