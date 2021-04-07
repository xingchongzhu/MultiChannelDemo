package com.android.chanel;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.android.base.CommonToolInterface;

/**
 * @author: ${zhuxingchong}
 * @date: 2021/4/1
 * @description $desc$
 */
public class CommonToolImpl extends CommonToolInterface {

    @Override
    public void makeLeak(Context context) {
        Log.d(TAG,"makeLeak no op");
    }

    @Override
    public void triggerReport(){
        Log.d(TAG,"triggerReport no op");
    }
}
