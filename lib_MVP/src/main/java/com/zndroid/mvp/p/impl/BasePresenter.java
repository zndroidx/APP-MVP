package com.zndroid.mvp.p.impl;

import com.zndroid.mvp.p.IPresenter;
import com.zndroid.mvp.v.IView;

import java.lang.ref.WeakReference;

/**
 * @name:BasePresenter
 * @author:lazy
 * @email:luzhenyuxfcy@sina.com
 * @date : 2020/4/19 16:19
 * @version:
 * @description:
 */
public class BasePresenter<V extends IView> implements IPresenter<V> {
    private WeakReference<V> viewReference;

    @Override
    public void attachView(V view) {
        viewReference = new WeakReference<V>(view);
    }

    @Override
    public void detachView() {
        if (null != viewReference)
            viewReference.clear();
    }

    @Override
    public V getView() {
        return viewReference.get();
    }

    protected boolean isAttached() {
        return viewReference.get() != null;
    }

}
