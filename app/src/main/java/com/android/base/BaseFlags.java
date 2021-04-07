package com.android.base;

import android.content.Context;
import android.util.Log;
import android.widget.Button;

import com.data.multichanneldemo.BuildConfig;

import androidx.core.util.Consumer;

/**
 * @author: ${zhuxingchong}
 * @date: 2021/3/25
 * @description $desc$
 */
public abstract class BaseFlags<T> {
    private String TAG = getClass().getSimpleName();
    protected Consumer<Button> channel = null;

    public BaseFlags() {}

    public void setButtonLabel(Button button){
        if(channel != null){
            channel.accept(button);
        }
    }

    public abstract void clickButton(Context content, T className);
}
