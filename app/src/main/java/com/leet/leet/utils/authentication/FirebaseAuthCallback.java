package com.leet.leet.utils.authentication;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

/**
 * Created by YasuhiraChiba on 2017/11/05.
 */

public interface FirebaseAuthCallback {
    public void onComplete(boolean isSuccess, String message);
}
