package com.zndroid.mvp.m;

import com.zndroid.mvp.m.impl.ModelFactory;

/**
 * @name:ExpressModelFactory
 * @author:lazy
 * @email:luzhenyuxfcy@sina.com
 * @date : 2020/4/22 12:49
 * @version:
 * @description:TODO
 */
public class ExpressModelFactory extends ModelFactory<ExpressModel> {
    @Override
    public ExpressModel createModel() {
        return new ExpressModel();
    }
}
