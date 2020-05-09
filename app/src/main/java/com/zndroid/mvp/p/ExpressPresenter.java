package com.zndroid.mvp.p;

import android.text.TextUtils;
import android.view.View;

import com.zndroid.mvp.m.ExpressBody;
import com.zndroid.mvp.m.ExpressModelFactory;
import com.zndroid.mvp.m.IModel;
import com.zndroid.mvp.p.impl.BasePresenter;
import com.zndroid.mvp.v.LoginView;
import com.zndroid.network.ResposeResult;

/**
 * @name:LoginPresenter
 * @author:lazy
 * @email:luzhenyuxfcy@sina.com
 * @date : 2020/4/21 22:19
 * @version:
 * @description:
 */
public class ExpressPresenter extends BasePresenter<LoginView> {
    public void initExpress() {
        if (isAttached())
            getView().getLoginButton().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String type = getView().getUsernameEditText().getText().toString();
                    String postId = getView().getPasswordEditText().getText().toString();

                    if (TextUtils.isEmpty(postId) || TextUtils.isEmpty(type)) {
                        getView().showToast("您的输入为空");
                        return;
                    }

                    login(type, postId);
                }
            });
    }

    private void login(String s, String s1) {
        if (isAttached()) {
            getView().showProgressBar();

            ExpressModelFactory expressModelFactory = new ExpressModelFactory();
            ExpressBody body = new ExpressBody();
            body.setType(s);
            body.setPostId(s1);

            expressModelFactory
                    .createModel()
                    .observe(body, new IModel.CallBack<ResposeResult, String>() {
                        @Override
                        public void onSuccess(ResposeResult resposeResult) {
                            StringBuilder stringBuilder = new StringBuilder();
                            if (resposeResult.getData() != null) {
                                for (ResposeResult.DataBean b :
                                        resposeResult.getData()) {
                                    stringBuilder.append(b.getContext() + "\n");
                                }
                            }

                            getView().showResult(stringBuilder.toString());
                        }

                        @Override
                        public void onFailed(String s) {
                            getView().showToast(s);
                        }

                        @Override
                        public void onCompleted() {
                            getView().closeProgressBar();
                        }
                    });
        }
    }
}
