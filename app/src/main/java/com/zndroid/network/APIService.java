package com.zndroid.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @name:APIServicer
 * @author:lazy
 * @email:luzhenyuxfcy@sina.com
 * @date : 2020/4/22 11:49
 * @version:
 * @description:
 */
public class APIService {
    private static APIService instance = null;
    private static API api;
    private APIService(){
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .connectTimeout(5_000, TimeUnit.SECONDS)
                .readTimeout(5_000, TimeUnit.SECONDS)
                .writeTimeout(5_000, TimeUnit.SECONDS)
                .build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(API.class);
    }

    public static API getAPI() {
        if (instance == null) {
            synchronized (APIService.class) {
                if (instance == null)
                    instance = new APIService();
            }
        }

        return api;
    }
}
