package com.leet.leet.screen.login.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.leet.leet.R;
import com.leet.leet.screen.login.LoginInterface;
import com.leet.leet.screen.login.model.LoginModel;
import com.leet.leet.screen.login.view.LoginView;
import com.leet.leet.screen.login.view.LoginViewInterface;
import com.leet.leet.screen.signup.controller.SignupActivity;

/**
 * Created by xinhezhang on 11/11/17.
 */

public class LoginActivity extends AppCompatActivity implements LoginViewInterface.LoginViewListener, LoginInterface {

    private LoginView mView;
    private LoginModel mModel;
    private LoginInterface mListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mModel = new LoginModel();
        mView = new LoginView(LayoutInflater.from(this), null);

        setContentView(mView.getRootView());
        mView.setListener(this);

        Button signup = (Button) findViewById(R.id.btGotoSignup);

        signup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                gotoSignup();
            }
        });
    }

    @Override
    public void login(String username, String password) {
        // TODO
    }

    @Override
    public void guestLogin() {
        // TODO
    }

    @Override
    public void gotoSignup() {
        Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
        startActivity(intent);
    }

}