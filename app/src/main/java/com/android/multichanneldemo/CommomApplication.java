package com.android.multichanneldemo;

import android.app.Application;
import android.util.Log;

import com.android.base.AppContext;
import com.android.base.BaseFlags;
import com.github.moduth.blockcanary.BlockCanary;
import com.squareup.leakcanary.LeakCanary;

/**
 * @author: ${zhuxingchong}
 * @date: 2021/3/31
 * @description $desc$
 */
public class CommomApplication extends Application {
    private final String TAG = getClass().getSimpleName();
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"onCreate 公共applicaion");
        //耗时检测初始化
        BlockCanary.install(this, new AppContext()).start();
        //内存泄漏初始化
        LeakCanary.install(this);
    }
}
