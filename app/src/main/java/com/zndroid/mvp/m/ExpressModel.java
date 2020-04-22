package com.zndroid.mvp.m;

import com.zndroid.network.APIService;
import com.zndroid.network.ResposeResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @name:ExpressModel
 * @author:lazy
 * @email:luzhenyuxfcy@sina.com
 * @date : 2020/4/22 12:54
 * @version:
 * @description:
 */
public class ExpressModel implements IModel<ExpressBody> {
    @Override
    public void observe(ExpressBody params, CallBack callBack) {
        Call<ResposeResult> call = APIService.getAPI().queryExpress(params.getType(), params.getPostId());
        call.enqueue(new Callback<ResposeResult>() {
            @Override
            public void onResponse(Call<ResposeResult> call, Response<ResposeResult> response) {
                callBack.onCompleted();
                if (response.isSuccessful())
                    callBack.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<ResposeResult> call, Throwable t) {
                callBack.onCompleted();
                callBack.onFailed(t.getCause());
            }
        });
    }
}
