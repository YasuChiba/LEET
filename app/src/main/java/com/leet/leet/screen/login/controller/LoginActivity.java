package com.leet.leet.screen.login.controller;

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

    // message
    String WRONG_EMAIL = "Wrong email";
    String EMPTY_EMAIL = "Email cannot be empty";
    String SHORT_PASSWORD = "Password must be at least 6 digits";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mModel = new LoginModel();
        mView = new LoginView(LayoutInflater.from(this), null);

        setContentView(mView.getRootView());
        mView.setListener(this);

        // login
        Button login = (Button) findViewById(R.id.btLogin);
        final EditText email = (EditText) findViewById(R.id.etEmail);
        email.setHint("leet@gmail.com");
        final EditText password = (EditText) findViewById(R.id.etPassword);
        password.setHint("At least 6 digits");
        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                login(email.getText().toString(), password.getText().toString());
            }
        });

        // go to signup
        Button signup = (Button) findViewById(R.id.btGotoSignup);
        signup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                gotoSignup();
            }
        });
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
     * @param password
     * @return true/false
     */
    @Override
    public boolean checkPassword(String password) {
        Log.d("LOGIN", "checkPassword===============================================================");
        // corner cases
        if (password == null || password.length() < 6) {
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
    public void login(String email, String password) {
        Log.d("LOGIN", "login===============================================================");
        if (checkEmail(email) && checkPassword(password)) {
            // TODO
            Toast.makeText(this, "200", Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(this, "400", Toast.LENGTH_SHORT).show();
    }

    /**
     * guest login, handled by firebase
     */
    @Override
    public void guestLogin() {
        // TODO
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

}