package com.leet.leet.utils.authentication;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by YasuhiraChiba on 2017/10/31.
 */

public class FirebaseAuthHelper {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;


    public static void signIn(String email, String password, final FirebaseAuthCallback callback) {
        FirebaseAuth.getInstance()
                .signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new CompletionListner(callback));
    }

    public static void createNewUser(String email, String password, final FirebaseAuthCallback callback) {
        FirebaseAuth.getInstance()
                .createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new CompletionListner(callback));
    }

    public static void createAnonymous(final FirebaseAuthCallback callback){
        FirebaseAuth.getInstance()
                .signInAnonymously()
                .addOnCompleteListener(new CompletionListner(callback));
    }

    public static void logout() {
        FirebaseAuth.getInstance().signOut();
    }

    public static boolean isLoggedIn() {
        return (FirebaseAuth.getInstance().getCurrentUser() != null);
    }

    public static String userId() {
        return FirebaseAuth.getInstance().getCurrentUser().getUid();
    }

    public static String getUserId() {
        return FirebaseAuth.getInstance().getCurrentUser().getUid();
    }





    static class CompletionListner implements OnCompleteListener<AuthResult> {

        FirebaseAuthCallback callback;

        CompletionListner(FirebaseAuthCallback callback) {
            this.callback = callback;
        }

        @Override
        public void onComplete(@NonNull Task<AuthResult> task) {
            if(callback != null) {
                if(task.isSuccessful()) {
                    callback.onComplete(task.isSuccessful(), null);
                } else {
                    callback.onComplete(task.isSuccessful(),task.getException().getMessage());
                }
            }
        }
    }
}
