package com.zndroid.mvp.v;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;


/**
 * @name:LoginView
 * @author:lazy
 * @email:luzhenyuxfcy@sina.com
 * @date : 2020/4/21 21:58
 * @version:
 * @description:
 */
public interface LoginView extends IView {
    EditText getUsernameEditText();
    EditText getPasswordEditText();
    Button getLoginButton();
    ProgressBar getProgressBar();
    void showToast(String msg);
    void login();
}
