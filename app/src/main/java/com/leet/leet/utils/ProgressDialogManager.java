package com.leet.leet.utils;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by YasuhiraChiba on 2017/10/25.
 */

public class ProgressDialogManager {

    private static ProgressDialog progressDialog;

    public static void showProgressDialog(Context context) {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(context);
            progressDialog.setMessage("loading");
            progressDialog.setIndeterminate(true);
            progressDialog.show();
        }
    }

    public static void hideProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }
}
