package com.android.chanel;

import android.annotation.SuppressLint;
import android.app.Application;
import android.util.Log;

import com.android.base.AppContext;
import com.android.multichanneldemo.CommomApplication;
import com.github.moduth.blockcanary.BlockCanary;
import com.kwai.koom.javaoom.KOOM;
import com.kwai.koom.javaoom.common.KConfig;
import com.kwai.koom.javaoom.common.KLog;
import com.kwai.koom.javaoom.dump.ForkJvmHeapDumper;
import com.squareup.leakcanary.LeakCanary;

import java.io.File;

/**
 * author 朱行冲
 * date 2019/11/19
 * description 添加application 初始化leakcanary内存检测工具
 */
@SuppressLint("Registered")
public class DebugApplication extends CommomApplication {
    private final String TAG = getClass().getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"DebugApplication 我是debug模式可以在此配置一些你想要的调试内容");
        //快手内存监控工具
        KOOM.init(this);
    }

    //Example of how to get report manually.
    public void getReportManually() {
        File reportDir = new File(KOOM.getInstance().getReportDir());
        for (File report : reportDir.listFiles()) {
            //Upload the report or do something else.
        }
    }

    //Example of how to listen report's generate status.
    public void listenReportGenerateStatus() {
        KOOM.getInstance().setHeapReportUploader(file -> {
            //Upload the report or do something else.
            //File is deleted automatically when callback is done by default.
        });
    }

    //Example of how to set custom config.
    public void customConfig() {
        KConfig kConfig = new KConfig.KConfigBuilder()
                .heapRatio(85.0f) //heap occupied ration in percent, 85.0f means use 85% memory of max heap
                .rootDir(this.getCacheDir().getAbsolutePath()) //root dir stores report and hprof files
                .heapOverTimes(3) //heap max times of over heap's used threshold
                .build();
        KOOM.getInstance().setKConfig(kConfig);
    }

    //Example of how to set custom logger.
    public void customLogger() {
        KOOM.getInstance().setLogger(new KLog.KLogger() {
            @Override
            public void i(String TAG, String msg) {
                //get the log of info level
            }

            @Override
            public void d(String TAG, String msg) {
                //get the log of debug level
            }

            @Override
            public void e(String TAG, String msg) {
                //get the log of error level
            }
        });
    }

    //Example of set custom koom root dir.
    public void customRootDir() {
        //Be careful with case when res is false which means dir is not valid.
        boolean res = KOOM.getInstance().setRootDir(this.getCacheDir().getAbsolutePath());
    }

    //Example of dump hprof directly
    public void customDump() {
        //Same with StandardHeapDumper StripHprofHeapDumper
        new ForkJvmHeapDumper().dump("absolute-path");
    }
}
