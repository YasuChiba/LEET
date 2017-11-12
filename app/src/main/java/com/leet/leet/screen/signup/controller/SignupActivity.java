package com.leet.leet.screen.signup.controller;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.leet.leet.R;
import com.leet.leet.screen.login.controller.LoginActivity;
import com.leet.leet.screen.signup.SignupInterface;
import com.leet.leet.screen.signup.model.SignupModel;
import com.leet.leet.screen.signup.view.SignupView;
import com.leet.leet.screen.signup.view.SignupViewInterface;

/**
 * Created by xinhezhang on 11/11/17.
 */

public class SignupActivity extends AppCompatActivity implements SignupViewInterface.SignupViewListener, SignupInterface {

    private SignupView mView;
    private SignupModel mModel;
    private SignupInterface mListener;

    private final int MIN_LENGTH = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mModel = new SignupModel();
        mView = new SignupView(LayoutInflater.from(this), null);

        setContentView(mView.getRootView());
        mView.setListener(this);
        /*
        Button back = (Button) findViewById(R.id.btGotoSignup);

        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                // TODO
            }
        });
        */
    }

    @Override
    public void signup(String username, String password) {
        // TODO
    }

    @Override
    public boolean checkPassword(String password, String password2) {
        if (password.length() < MIN_LENGTH) {
            return false;
        }
        return password.equals(password2);
    }

    @Override
    public void dialog(View view) {
        AlertDialog alertDialog = new AlertDialog.Builder(view.getContext()).create();
        alertDialog.setTitle("Error");
        alertDialog.setMessage("Passwords not match");
        alertDialog.setButton("OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //dismiss the dialog
                    }
                }
        );
        alertDialog.show();
    }
}