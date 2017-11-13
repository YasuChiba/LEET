package com.leet.leet.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

/**
 * Created by YasuhiraChiba on 2017/10/31.
 */

public class DialogManager {

    public interface DialogTappListener {
        void okButtonTapped();
    }

    public static void simpleDialog(Context context, String title, String message, final DialogTappListener listener) {
        new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(listener != null) {
                            listener.okButtonTapped();
                        }
                    }
                })
                .show();
    }
}
