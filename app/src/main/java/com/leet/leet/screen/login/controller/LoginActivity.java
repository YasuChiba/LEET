package com.leet.leet.screen.login.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.leet.leet.screen.login.LoginInterface;
import com.leet.leet.screen.login.model.LoginModel;
import com.leet.leet.screen.login.view.LoginView;
import com.leet.leet.screen.login.view.LoginViewInterface;
import com.leet.leet.screen.main.controller.MainActivity;
import com.leet.leet.screen.signup.controller.SignupActivity;
import com.leet.leet.utils.DialogManager;
import com.leet.leet.utils.ProgressDialogManager;
import com.leet.leet.utils.authentication.FirebaseAuthManager;


/**
 * Created by xinhezhang on 11/11/17.
 */

public class LoginActivity extends AppCompatActivity implements LoginViewInterface.LoginViewListener, LoginInterface, OnCompleteListener {

    private LoginView mView;
    private LoginModel mModel;
    private LoginInterface mListener;

    // minimum length of valid password
    private static final int MIN_LENGTH = 6;

    // message
    final String WRONG_EMAIL = "Wrong email";
    final String EMPTY_EMAIL = "Email cannot be empty";
    final String SHORT_PASSWORD = "Password must be at least 6 digits";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mModel = new LoginModel();
        mView = new LoginView(LayoutInflater.from(this), null);

        setContentView(mView.getRootView());
        mView.setListener(this);
    }

    /**
     * Check if user input email is valid or not
     * check null, empty, match email pattern
     *
     * @param email user input email
     * @return true/false
     */
    @Override
    public boolean checkEmail(final String email) {
        Log.d("LOGIN", "checkEmail===============================================================");
        // corner cases
        if (email == null || email.equals("")) {
            Toast.makeText(this, EMPTY_EMAIL, Toast.LENGTH_SHORT).show();
            return false;
        }
        // using built-in function
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, WRONG_EMAIL, Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    /**
     * Check if user input password is valid or not
     * check null, at least 6 digits
     *
     * @param password user input password
     * @return true/false
     */
    @Override
    public boolean checkPassword(final String password) {
        Log.d("LOGIN", "checkPassword===============================================================");
        // corner cases
        if (password == null || password.length() < MIN_LENGTH) {
            Toast.makeText(this, SHORT_PASSWORD, Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    /**
     * user login email and password, send to firebase
     * @param email user input email
     * @param password user input password
     */
    @Override
    public void login(final String email, final String password) {
        Log.d("LOGIN", "login===============================================================");
        if (checkEmail(email) && checkPassword(password)) {
            Toast.makeText(this, "200", Toast.LENGTH_SHORT).show();

            // connect to firebase, from LEET-sample
            ProgressDialogManager.showProgressDialog(this);
            FirebaseAuthManager.signIn(email, password, this);
        } else {
            Toast.makeText(this, "404", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * guest login, handled by firebase
     */
    @Override
    public void guestLogin() {
        Log.d("LOGIN", "guestLogin===============================================================");
        // connect to firebase
        ProgressDialogManager.showProgressDialog(this);
        FirebaseAuthManager.signInAnonymously(this);
        Toast.makeText(this, "200", Toast.LENGTH_SHORT).show();
    }

    /**
     * go to signup page
     */
    @Override
    public void gotoSignup() {
        Log.d("LOGIN", "gotoSignup===============================================================");
        Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
        startActivity(intent);
    }

    /**
     * onComplete Listener, from LEET-sample
     *
     * @param task
     */
    @Override
    public void onComplete(@NonNull Task task) {
        ProgressDialogManager.hideProgressDialog();
        if (!task.isSuccessful()){
            DialogManager.simpleDialog(this, "FAIL", task.getException().getMessage(), new DialogManager.DialogTappListner() {
                @Override
                public void okButtonTapped() {
                    // dismiss
                }
            });
        } else {
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    }
}