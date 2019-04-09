package com.biao.retrofit;

import android.app.Application;
import android.content.Context;

/**
 * Created by benxiang on 2019/4/9.
 */

public class MyApplication extends Application {
    private static Context context = null;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
