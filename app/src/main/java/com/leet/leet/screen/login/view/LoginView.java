package com.leet.leet.screen.login.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.leet.leet.R;

/**
 * Created by xinhezhang on 11/05/17.
 */

public class LoginView implements LoginViewInterface, View.OnClickListener  {

    private View rootView;

    private LoginViewListener mListener;

    // edit text
    private EditText email;
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
        // edit text
        email = rootView.findViewById(R.id.etEmail);
        password = rootView.findViewById(R.id.etPassword);

        email.setHint("leet@gmail.com");
        password.setHint("At least 6 characters");

        // button
        login = rootView.findViewById(R.id.btLogin);
        guest = rootView.findViewById(R.id.btGuest);
        signup = rootView.findViewById(R.id.btGotoSignup);

        login.setOnClickListener(this);
        guest.setOnClickListener(this);
        signup.setOnClickListener(this);
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
                mListener.login(email.getText().toString(), password.getText().toString());
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