package com.zndroid.ui.login;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.zndroid.R;
import com.zndroid.mvp.p.ExpressPresenter;
import com.zndroid.mvp.v.LoginView;

public class ExpressActivity extends AppCompatActivity implements LoginView {
    ExpressPresenter loginPresenter = new ExpressPresenter();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginPresenter.attachView(this);

        getLoginButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    @Override
    public EditText getUsernameEditText() {
        return findViewById(R.id.username);
    }

    @Override
    public EditText getPasswordEditText() {
        return findViewById(R.id.password);
    }

    @Override
    public Button getLoginButton() {
        return findViewById(R.id.login);
    }

    @Override
    public ProgressBar getProgressBar() {
        return findViewById(R.id.loading);
    }

    @Override
    public void showResult(String s) {
        if (TextUtils.isEmpty(s)) return;
        ((TextView)findViewById(R.id.result_tv)).setText(s);
    }

    @Override
    public void showProgressBar() {
        getProgressBar().setVisibility(View.VISIBLE);
    }

    @Override
    public void closeProgressBar() {
        getProgressBar().setVisibility(View.GONE);
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void login() {
        loginPresenter.login(getUsernameEditText().getText().toString(), getPasswordEditText().getText().toString());
    }

    @Override
    public Context getMContext() {
        return this.getApplicationContext();
    }

    @Override
    public Activity getMActivity() {
        return this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.detachView();
    }
}
