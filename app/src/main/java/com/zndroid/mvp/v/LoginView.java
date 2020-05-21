package com.zndroid.mvp.v;


/**
 * @name:LoginView
 * @author:lazy
 * @email:luzhenyuxfcy@sina.com
 * @date : 2020/4/21 21:58
 * @version:
 * @description:
 */
public interface LoginView extends IView {
    void showResult(String s);
    void showProgressBar();
    void closeProgressBar();
    void showToast(String msg);
}
