package com.leet.leet.screen.account.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.leet.leet.R;
import com.leet.leet.utils.database.entities.user.UserProfileEntity;


/**
 * Created by YasuhiraChiba on 2017/10/31.
 */

public class AccountView implements AccountViewInterface, View.OnClickListener  {

    private View mRootView;
    /*
    private AccountViewListener mListner;

    private TextView tvEmail;
    private Button btLogout;

    private EditText etName;
    private EditText etGender;
    private EditText etAge;
    private Button btSetDataToDB;
*/

    public AccountView(LayoutInflater inflater, ViewGroup container) {
        mRootView = inflater.inflate(R.layout.view_profile, container, false);

        initialize();
    }

    private void initialize() {
        /*
        tvEmail = (TextView)mRootView.findViewById(R.id.account_tv_email);
        btLogout = (Button)mRootView.findViewById(R.id.account_bt_logout);

        etName = (EditText) mRootView.findViewById(R.id.account_et_name);
        etGender = (EditText) mRootView.findViewById(R.id.account_et_gender);
        etAge = (EditText) mRootView.findViewById(R.id.account_et_age);
        btSetDataToDB = (Button)mRootView.findViewById(R.id.account_bt_settext);

        btLogout.setOnClickListener(this);
        btSetDataToDB.setOnClickListener(this);
        */
    }



    @Override
    public void setListener(AccountViewListener listener) {
        //this.mListner = listener;
    }

    @Override
    public View getRootView() {
        return mRootView;
    }


    @Override
    public void onClick(View view) {
        /*
        switch (view.getId()){
            case R.id.account_bt_logout:
                mListner.logoutClick();
                break;
            case R.id.account_bt_settext:
                UserProfileEntity tmp = new UserProfileEntity();
                tmp.setName(etName.getText().toString());
                tmp.setAge(Integer.valueOf(etAge.getText().toString()));
                tmp.setGender(etGender.getText().toString());
                break;
        }
        */
    }
}
