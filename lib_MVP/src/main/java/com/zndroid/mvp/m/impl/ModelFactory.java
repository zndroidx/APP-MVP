package com.zndroid.mvp.m.impl;

import com.zndroid.mvp.m.IModel;
import com.zndroid.mvp.m.IModelFactory;

/**
 * @name:ModelFactory
 * @author:lazy
 * @email:luzhenyuxfcy@sina.com
 * @date : 2020/4/21 17:26
 * @version:
 * @description:
 */
public abstract class ModelFactory<M extends IModel> implements IModelFactory {
    public abstract M createModel();
}
