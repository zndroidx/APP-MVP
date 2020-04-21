package com.zndroid.mvp.m;

/**
 * @name:IModel
 * @author:lazy
 * @email:luzhenyuxfcy@sina.com
 * @date : 2020/4/19 16:28
 * @version:
 * @description:
 */
public interface IModel<P> {
    interface CallBack<T, F> {
        void onSuccess(T t);
        void onFailed(F f);
        void onCompleted();
    }

    IModel observe(P params, CallBack callBack);
}
