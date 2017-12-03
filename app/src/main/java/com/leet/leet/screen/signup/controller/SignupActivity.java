package com.leet.leet.screen.signup.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.leet.leet.screen.login.controller.LoginActivity;
import com.leet.leet.screen.main.controller.MainActivity;
import com.leet.leet.screen.signup.SignupInterface;
import com.leet.leet.screen.signup.model.SignupModel;
import com.leet.leet.screen.signup.view.SignupView;
import com.leet.leet.screen.signup.view.SignupViewInterface;
import com.leet.leet.utils.DialogManager;
import com.leet.leet.utils.ProgressDialogManager;
import com.leet.leet.utils.authentication.FirebaseAuthManager;
import com.leet.leet.utils.database.FirebaseDBUserDataHelper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.leet.leet.utils.authentication.FirebaseAuthManager.sendEmail;

/**
 * Created by xinhezhang on 11/11/17.
 */

public class SignupActivity extends AppCompatActivity implements SignupViewInterface.SignupViewListener, SignupInterface, OnCompleteListener {

    private SignupView mView;
    private SignupModel mModel;
    private SignupInterface mListener;

    // minimum length of valid password
    private static final int MIN_LENGTH = 6;

    // detectable minimum pattern length
    private static final int PATTERN_LENGTH = 3;

    // message
    final String WRONG_EMAIL = "Wrong email address";
    final String EMPTY_EMAIL = "Email cannot be empty";
    final String SHORT_PASSWORD = "Password must contain minimum " + MIN_LENGTH + " characters";
    final String NOT_MATCH_PASSWORD = "Password not match";
    final String EMPTY_PASSWORD = "Password cannot be empty";
    final String NEED_DIGIT = "You need at least one digit";
    final String NEED_LETTER = "You need at least one letter";
    final String NEED_LOWERCASE = "You need at least one lowercase letter";
    final String NEED_UPPERCASE = "You need at least one uppercase letter";
    final String NEED_SPECIAL = "You need at least one special character";
    final String CONTAINS = "Password cannot be part of your email";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mModel = new SignupModel();
        mView = new SignupView(LayoutInflater.from(this), null);

        setContentView(mView.getRootView());
        mView.setListener(this);
    }

    /**
     * go to login page
     */
    @Override
    public void gotoLogin() {
        Log.d("SIGNUP", "gotoLogin");
        Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    /**
     * user login email and password, send to firebase
     *
     * @param email user input email
     * @param password user input password
     */
    @Override
    public void signup(final String email, final String password, final String confirmPassword) {
        Log.d("SIGNUP", "signup");
        if (checkAll(email, password, confirmPassword)) {
            //Toast.makeText(this, "200", Toast.LENGTH_SHORT).show();

            // connect to firebase, from LEET-sample
            ProgressDialogManager.showProgressDialog(this);
            FirebaseAuthManager.signUpNewUser(email, password, this);

            // send user email verification
            sendEmail();
        } else {
            Log.d("SIGNUP", "signup failed");
            //Toast.makeText(this, "404", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Check user input email, password, confirmed password is valid or not
     *
     * @param email user input email
     * @param password user input password
     * @param confirmPassword user confirmed password
     * @return true/false
     */
    private boolean checkAll(final String email, final String password, final String confirmPassword) {
        return checkEmail(email) && checkPassword(password, confirmPassword) && checkPattern(password) && checkContains(password, email);
    }

    /**
     * Check if user input email is valid or not
     * check null, empty, match email pattern
     *
     * @param email user input email
     * @return true/false
     */
    private boolean checkEmail(final String email) {
        // corner cases
        if (email == null || email.length() == 0) {
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
     * check null, at least 6 digits (or preset value)
     *
     * @param password user input password
     * @param confirmPassword user confirmed password
     * @return true/false
     */
    private boolean checkPassword(final String password, final String confirmPassword) {
        // corner cases
        if (password == null || confirmPassword == null) {
            Toast.makeText(this, EMPTY_PASSWORD, Toast.LENGTH_SHORT).show();
            return false;
        }
        // check password length
        if (password.length() < MIN_LENGTH) {
            Toast.makeText(this, SHORT_PASSWORD, Toast.LENGTH_SHORT).show();
            return false;
        }
        // check password equals confirmed password
        if (!password.equals(confirmPassword)) {
            Toast.makeText(this, NOT_MATCH_PASSWORD, Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    /**
     * Check password pattern
     * at least one digit, lowercase, uppercase, special characters, part of email
     *
     * @param password user input password
     * @return true/false
     */
    private boolean checkPattern(final String password) {
        // check digit
        if (!password.matches(".*[0-9].*")){
            Toast.makeText(this, NEED_DIGIT, Toast.LENGTH_SHORT).show();
            return false;
        }
        // check letter
        if (!password.matches(".*[a-zA-Z].*")) {
            Toast.makeText(this, NEED_LETTER, Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    /**
     * check whether password is part of email for any 3 continue characters
     *
     * @param password user input password
     * @param email user input email
     * @return true/false
     */
    private boolean checkContains(String password, String email) {
        for (int i = 0; i < email.length() - PATTERN_LENGTH; i++) {
            if (password.contains(email.substring(i, i + PATTERN_LENGTH))) {
                Toast.makeText(this, CONTAINS, Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        return true;
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
            DialogManager.simpleDialog(this, "FAIL", task.getException().getMessage(), new DialogManager.DialogTappListener() {
                @Override
                public void okButtonTapped() {
                    // dismiss
                }
            });
        } else {
            FirebaseDBUserDataHelper.setDefaultProfileEntity();
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        }
    }
}