package com.android.base;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import com.github.moduth.blockcanary.BlockCanaryContext;

public class AppContext extends BlockCanaryContext {
    private static final String TAG = "AppContext";

    @Override
    public String provideQualifier() {
        String qualifier = "";
        try {
            PackageInfo info = provideContext().getPackageManager()
                    .getPackageInfo(provideContext().getPackageName(), 0);
            qualifier += info.versionCode + "_" + info.versionName + "_YYB";
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, "provideQualifier exception"+e);
        }
        return qualifier;
    }

    @Override
    public int provideBlockThreshold() {
        //阻塞时间超过多少秒发通知
        return 100;
    }

    @Override
    public boolean displayNotification() {
        return true;
    }

    @Override
    public boolean stopWhenDebugging() {
        return false;
    }
}