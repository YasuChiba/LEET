package com.leet.leet.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.leet.leet.R;
import com.rey.material.app.Dialog;
import com.rey.material.app.DialogFragment;
import com.rey.material.app.SimpleDialog;
import com.rey.material.widget.EditText;

import static com.rey.material.R.attr.isLightTheme;

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

    public static void showMealSortDialog(FragmentManager fm) {
        Dialog.Builder builder = null;
        builder = new SimpleDialog.Builder(R.style.SimpleDialogLight){

            @Override
            protected void onBuildDone(Dialog dialog) {
                dialog.layoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            }

            @Override
            public void onPositiveActionClicked(DialogFragment fragment) {
               // EditText et_pass = (EditText)fragment.getDialog().findViewById(R.id.custom_et_password);
                //Toast.makeText(mActivity, "Connected. pass=" + et_pass.getText().toString(), Toast.LENGTH_SHORT).show();
                super.onPositiveActionClicked(fragment);
            }
        };

        builder.title("Search")
                .positiveAction("OK")
                .contentView(R.layout.dialog_view_meal_sort);

        DialogFragment fragment = DialogFragment.newInstance(builder);
        fragment.show(fm, null);
    }
}
