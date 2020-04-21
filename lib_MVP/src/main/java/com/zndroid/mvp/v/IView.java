package com.zndroid.mvp.v;

import android.app.Activity;
import android.content.Context;

/**
 * @name:IView
 * @author:lazy
 * @email:luzhenyuxfcy@sina.com
 * @date : 2020/4/19 14:35
 * @version:
 * @description: we always get 'Activity or Context'
 */
public interface IView {
    Context getMContext();
    Activity getMActivity();
}
