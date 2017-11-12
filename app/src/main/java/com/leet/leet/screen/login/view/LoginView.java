package com.leet.leet.screen.login.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.leet.leet.R;
import com.leet.leet.screen.login.view.LoginViewInterface;

/**
 * Created by xinhezhang on 11/05/17.
 */

public class LoginView implements LoginViewInterface, View.OnClickListener  {

    private View rootView;

    private LoginViewListener mListener;

    // edit text
    private EditText username;
    private EditText password;

    // button
    private Button login;
    private Button guest;
    private Button signup;

    public LoginView(LayoutInflater inflater, ViewGroup container) {
        rootView = inflater.inflate(R.layout.view_login, container, false);

        initialize();
    }

    private void initialize() {
        username = rootView.findViewById(R.id.etUsername);
        password = rootView.findViewById(R.id.etPassword);

        login = rootView.findViewById(R.id.btLogin);
        guest = rootView.findViewById(R.id.btGuest);
        signup = rootView.findViewById(R.id.btGotoSignup);
    }

    @Override
    public void setListener(LoginViewListener listener) {
        this.mListener = listener;
    }

    @Override
    public View getRootView() {
        return rootView;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btLogin:
                mListener.login(username.getText().toString(), password.getText().toString());
                break;
            case R.id.btGuest:
                mListener.guestLogin();
                break;
            case R.id.btGotoSignup:
                mListener.gotoSignup();
                break;
        }
    }
}