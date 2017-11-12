package com.leet.leet.screen.signup.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.leet.leet.R;

/**
 * Created by xinhezhang on 11/11/17.
 */

public class SignupView implements SignupViewInterface, View.OnClickListener {

    private View rootView;

    private SignupViewInterface.SignupViewListener mListener;

    // edit text
    private EditText username;
    private EditText password;
    private EditText confirmPassword;

    // button
    private Button signup;
    private Button back;

    public SignupView(LayoutInflater inflater, ViewGroup container) {
        rootView = inflater.inflate(R.layout.view_signup, container, false);

        initialize();
    }

    private void initialize() {
        username = rootView.findViewById(R.id.etUsername);
        password = rootView.findViewById(R.id.etPassword);
        confirmPassword = rootView.findViewById(R.id.etConfirmPassword);

        signup = rootView.findViewById(R.id.btSignup);
        back = rootView.findViewById(R.id.btBack);
    }


    @Override
    public void setListener(SignupViewInterface.SignupViewListener listener) {
        this.mListener = listener;
    }

    @Override
    public View getRootView() {
        return rootView;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btSignup:
                if (!mListener.checkPassword(password.getText().toString(), confirmPassword.getText().toString())) {
                    mListener.dialog(view);
                    break;
                }
                mListener.signup(username.getText().toString(), password.getText().toString());
                break;
            case R.id.btBack:
                mListener.gotoLogin();
                break;
        }
    }
}
