package com.android.base;

import android.content.Context;

import java.util.function.Consumer;

/**
 * @author: ${zhuxingchong}
 * @date: 2021/4/1
 * @description $desc$
 */
public abstract class CommonToolInterface<T> {
    protected final String TAG = getClass().getSimpleName();
    public abstract void makeLeak(Context context);
    public abstract void triggerReport();
}
