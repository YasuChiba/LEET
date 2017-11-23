package com.leet.leet.utils.authentication;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by YasuhiraChiba on 2017/10/31.
 */



public class FirebaseAuthManager {

    private static FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    public static void signIn(String email, String password, OnCompleteListener<AuthResult> complteListner) {
        if(complteListner != null) {
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(complteListner);
        } else {
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password);
        }
    }

    public static void signUpNewUser(String email, String password, OnCompleteListener<AuthResult> complteListner) {
        if(complteListner != null) {
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(complteListner);
        } else {
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password);
        }
    }

    /**
     * sign in anonymously using firebase built-in function
     */
    public static void signInAnonymously(OnCompleteListener<AuthResult> complteListner) {
        if(complteListner != null) {
            FirebaseAuth.getInstance().signInAnonymously().addOnCompleteListener(complteListner);
        } else {
            FirebaseAuth.getInstance().signInAnonymously();
        }
    }

    public static void logout() {
        FirebaseAuth.getInstance().signOut();
    }

    public static boolean isLoggedIn() {
        return (FirebaseAuth.getInstance().getCurrentUser() != null);
    }

    public static String getUserId() {
        return FirebaseAuth.getInstance().getCurrentUser().getUid();
    }

    public static String getEmail() {
        return FirebaseAuth.getInstance().getCurrentUser().getEmail();
    }
}
