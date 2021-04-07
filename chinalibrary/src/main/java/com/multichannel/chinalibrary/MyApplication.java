package com.multichannel.chinalibrary;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

/**
 * @author: ${zhuxingchong}
 * @date: 2021/3/29
 * @description $desc$
 */
public class MyApplication extends Application {
    private final String TAG = getClass().getSimpleName();
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"onCreate 我是中国版本");
        Toast.makeText(this,"我是中国版本",Toast.LENGTH_LONG).show();
    }

}
