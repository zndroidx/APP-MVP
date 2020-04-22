package com.zndroid.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @name:API
 * @author:lazy
 * @email:luzhenyuxfcy@sina.com
 * @date : 2020/4/22 11:39
 * @version:
 * @description:
 */
public interface API {
    String BASE_URL = "http://www.kuaidi100.com/";

    @GET("/query")
    Call<ResposeResult> queryExpress(@Query("type") String type, @Query("postid") String postid);
}
