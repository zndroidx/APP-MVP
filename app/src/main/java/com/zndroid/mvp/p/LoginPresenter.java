package com.zndroid.mvp.p;

import com.zndroid.mvp.p.impl.BasePresenter;
import com.zndroid.mvp.v.LoginView;

/**
 * @name:LoginPresenter
 * @author:lazy
 * @email:luzhenyuxfcy@sina.com
 * @date : 2020/4/21 22:19
 * @version:
 * @description:
 */
public class LoginPresenter extends BasePresenter<LoginView> {
    public void login(String s, String toString) {
        if (isAttached())
            getView().showToast("1234");
    }
}
