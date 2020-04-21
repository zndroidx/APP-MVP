package com.zndroid.mvp;

/**
 * @name:MVPAPI
 * @author:lazy
 * @email:luzhenyuxfcy@sina.com
 * @date : 2020/4/19 14:29
 * @version:
 * @description:
 */
public class MVPAPI {
    String description =
            "MVP，全称 Model-View-Presenter。它是从 MVC中演变过来的，它的基本思想是相通的；" +
            "在MVP中，View更加专注于处理数据的可视化以及用户交互，让Model专注于数据的处理，" +
            "而Presenter则，提供 View 与 Model 之间数据的纽带，用于交互与数据传输。其优缺点如下：" +
                    "优点：\n" +
                    "    减低耦合，实现了 Model 与View 的真正分离，修改 View 而不影响 Model" +
                    "    模块职责分明，层次分明，便于维护，多人开发首选。" +
                    "    Presenter 可以服用，一个 Presenter可以用于多个 View，不用去改 Presenter" +
                    "    利于单元测试。模块分明，那么我们编写单元测试就变得很方便了，而不用特别是特别搭平台，人工模拟用户操作等等耗时耗力的事情。" +
                    "缺点：\n" +
                    "   对于小工程，额外多出来的代码量，和额外的代码复杂度，毕竟那么多 interface ，但对于它的有点来说，完全可以接受。";

}
