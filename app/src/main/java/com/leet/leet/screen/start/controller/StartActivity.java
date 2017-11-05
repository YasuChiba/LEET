package com.leet.leet.screen.start.controller;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.leet.leet.R;
import com.leet.leet.screen.start.model.StartModel;
import com.leet.leet.screen.start.view.StartView;
import com.leet.leet.utils.authentication.FirebaseAuthCallback;
import com.leet.leet.utils.authentication.FirebaseAuthHelper;

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

        FirebaseAuthHelper.signIn("test@gmail.com", "testtest", new FirebaseAuthCallback() {
            @Override
            public void onComplete(boolean isSuccess, String message) {
                if(isSuccess) {
                    mModel.getMenu();
                    mModel.setUserProfile();
                    mModel.addCustomMenu();
                } else {
                    Log.d("",message);
                }
            }
        });
    }
}
