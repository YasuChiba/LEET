package com.leet.leet.screen.account.controller;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leet.leet.screen.account.AccountInterface;
import com.leet.leet.screen.account.model.AccountModel;
import com.leet.leet.screen.account.view.AccountView;
import com.leet.leet.screen.account.view.AccountViewInterface;


/**
 * A simple {@link Fragment} subclass.
 */
public class AccountFragment extends Fragment implements AccountViewInterface.AccountViewListener {

    private AccountView mView;
    private AccountModel mModel;

    private AccountInterface mListner; //controller handles the events, right?

    public AccountFragment() {
    }

    public void setupFragment(AccountInterface listner) {
        this.mListner = listner;
    }

    @Override //what is this?
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mModel = new AccountModel();

        mView = new AccountView(inflater, container);
        mView.setListener(this);
        //   mView.setText(mModel.getEmail());


        return mView.getRootView();
    }

    @Override
    public void logoutClick() {


        mListner.backToLogin();
    }


}
