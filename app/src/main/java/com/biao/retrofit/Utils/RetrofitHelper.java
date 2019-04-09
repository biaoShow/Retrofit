package com.biao.retrofit.Utils;

import android.util.Log;

import com.biao.retrofit.BuildConfig;
import com.biao.retrofit.RetrofitInterface;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by benxiang on 2019/4/9.
 */

public class RetrofitHelper {

    private Retrofit mRetrofit = null;
    private String baseUrl;
    private RetrofitInterface retrofitInterface = null;
    private static RetrofitHelper retrofitHelper = null;
    private static final long DEFAULT_TIME_OUT = 5;
    private static final long CONNECT_TIME_OUT = 12;

    private RetrofitHelper(String url) {
        if (null == url || url.equals("")) {
            this.baseUrl = BuildConfig.HOTEL_BASE_URL;
        } else {
            this.baseUrl = url;
        }
        if (null == mRetrofit) {
            mRetrofit = new Retrofit.Builder()
                    .client(setOkHtttp())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(baseUrl)
                    .build();
        }
    }

    public static RetrofitHelper getInstance(String url) {
        if (null == retrofitHelper) {
            retrofitHelper = new RetrofitHelper(url);
        }
        return retrofitHelper;
    }

    public RetrofitInterface getRetrofitInterface() {
        if (null == retrofitInterface) {
            retrofitInterface = mRetrofit.create(RetrofitInterface.class);
        }
        return retrofitInterface;
    }

    private OkHttpClient setOkHtttp() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(CONNECT_TIME_OUT, TimeUnit.SECONDS);//连接 超时时间
        builder.writeTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS);//写操作 超时时间
        builder.readTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS);//读操作 超时时间
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor(new HttpLogger());
            logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addNetworkInterceptor(logInterceptor);
        }
        builder.retryOnConnectionFailure(true);//错误重连
        return builder.build();
    }

    public class HttpLogger implements HttpLoggingInterceptor.Logger {
        @Override
        public void log(String message) {
            Log.i("HttpLogInfo", message);
        }
    }
}
