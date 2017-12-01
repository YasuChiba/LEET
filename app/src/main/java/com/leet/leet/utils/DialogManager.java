package com.leet.leet.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.View;

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

    // TODO
    public static void errorDialog(View view) {
        android.app.AlertDialog alertDialog = new android.app.AlertDialog.Builder(view.getContext()).create();
        alertDialog.setTitle("Error");
        alertDialog.setMessage("Passwords not match");
        alertDialog.setButton("OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // dismiss the dialog
                    }
                }
        );
        alertDialog.show();
    }
}
