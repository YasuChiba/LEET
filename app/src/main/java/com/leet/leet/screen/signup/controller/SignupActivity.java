package com.leet.leet.screen.signup.controller;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

    // minimum length of valid password
    private final int MIN_LENGTH = 6;

    // message
    String WRONG_EMAIL = "Wrong email";
    String EMPTY_EMAIL = "Email cannot be empty";
    String SHORT_PASSWORD = "Password must be at least 6 digits";
    String NOT_MATCH_PASSWORD = "Password not match";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mModel = new SignupModel();
        mView = new SignupView(LayoutInflater.from(this), null);

        setContentView(mView.getRootView());
        mView.setListener(this);


        // signup
        Button singup = (Button) findViewById(R.id.btSignup);
        final EditText email = (EditText) findViewById(R.id.etEmail);
        email.setHint("leet@gmail.com");
        final EditText password = (EditText) findViewById(R.id.etPassword);
        password.setHint("At least 6 digits");
        final EditText confirmPassword = (EditText) findViewById(R.id.etConfirmPassword);
        confirmPassword.setHint("Confirm password");
        singup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                signup(email.getText().toString(), password.getText().toString(), confirmPassword.getText().toString());
            }
        });

        // go to login page
        Button back = (Button) findViewById(R.id.btBack);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                gotoLogin();
            }
        });
    }

    @Override
    public void gotoLogin() {
        Log.d("SIGNUP", "gotoLogin===============================================================");
        Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    /**
     * Check if user input email is valid or not
     * check null, empty, match email pattern
     *
     * @param email
     * @return true/false
     */
    @Override
    public boolean checkEmail(String email) {
        Log.d("SIGNUP", "checkEmail===============================================================");
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
     * check null, at least 6 digits (or preset value)
     *
     * @param password
     * @return true/false
     */
    @Override
    public boolean checkPassword(String password, String confirmPassword) {
        Log.d("SIGNUP", "checkPassword===============================================================");
        // corner cases
        if (password == null || confirmPassword == null || !password.equals(confirmPassword)) {
            Toast.makeText(this, NOT_MATCH_PASSWORD, Toast.LENGTH_SHORT).show();
            return false;
        }
        if (password.length() < MIN_LENGTH) {
            Toast.makeText(this, SHORT_PASSWORD, Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    /**
     * user login email and password, send to firebase
     * @param email
     * @param password
     */
    @Override
    public void signup(String email, String password, String confirmPassword) {
        Log.d("SIGNUP", "signup===============================================================");
        if (checkEmail(email) && checkPassword(password, confirmPassword)) {
            // TODO
            Toast.makeText(this, "200", Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(this, "400", Toast.LENGTH_SHORT).show();
    }


    /**
     * Display dialog message
     * @param view
     */
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