package com.zndroid.ui.login;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.zndroid.R;
import com.zndroid.mvp.p.LoginPresenter;
import com.zndroid.mvp.v.LoginView;

public class LoginActivity extends AppCompatActivity implements LoginView {
    LoginPresenter loginPresenter = new LoginPresenter();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginPresenter.attachView(this);


        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
        getUsernameEditText().addTextChangedListener(afterTextChangedListener);
        getPasswordEditText().addTextChangedListener(afterTextChangedListener);
        getPasswordEditText().setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {

                }
                return false;
            }
        });

        getLoginButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getProgressBar().setVisibility(View.VISIBLE);

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
