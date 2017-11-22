package com.leet.leet.screen.start.controller;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.leet.leet.R;
import com.leet.leet.screen.login.controller.LoginActivity;
import com.leet.leet.screen.main.controller.MainActivity;
import com.leet.leet.screen.start.model.StartModel;
import com.leet.leet.screen.start.view.StartView;
import com.leet.leet.utils.authentication.FirebaseAuthCallback;
import com.leet.leet.utils.authentication.FirebaseAuthHelper;
import com.leet.leet.utils.authentication.FirebaseAuthManager;

public class StartActivity extends AppCompatActivity {

    private StartView mView;
    private StartModel mModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //create view and attach to activity
        mView = new StartView(LayoutInflater.from(this), null);
        setContentView(mView.getRootView());

        //create model
        mModel = new StartModel();
    }

    // From LEET-sample
    @Override
    protected void onStart() {
        super.onStart();

        // log out
        //FirebaseAuthManager.logout();

        if (mModel.isLoggedIn()) {
            Toast.makeText(this, FirebaseAuthManager.getEmail(), Toast.LENGTH_SHORT).show();
            Toast.makeText(this, FirebaseAuthManager.getUserId(), Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
    }
}
