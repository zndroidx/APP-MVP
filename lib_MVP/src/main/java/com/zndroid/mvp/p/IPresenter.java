package com.zndroid.mvp.p;

import com.zndroid.mvp.v.IView;

/**
 * @name:IPresenter
 * @author:lazy
 * @email:luzhenyuxfcy@sina.com
 * @date : 2020/4/19 16:13
 * @version:
 * @description:
 */
public interface IPresenter<V extends IView> {
    void attachView(V view);
    void detachView();
    V getView();
}
