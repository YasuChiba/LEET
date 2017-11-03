package com.leet.leet.common;

import android.view.View;

/**
 * Created by YasuhiraChiba on 2017/10/31.
 */

public interface ViewBaseInterface {
    /**
     * Get the root Android View which is used internally by this MVC View for presenting data
     * to the user.<br>
     * The returned Android View might be used by an MVC Controller in order to query or alter the
     * properties of either the root Android View itself, or any of its child Android View's.
     * @return root Android View of this MVC View
     */
    public View getRootView();

}
