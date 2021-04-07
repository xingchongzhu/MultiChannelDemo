package com.android.base;

import android.app.Activity;
import android.os.Bundle;

import com.data.multichanneldemo.R;

/**
 * @author: ${zhuxingchong}
 * @date: 2021/3/31
 * @description $desc$
 */
public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.china_layout);
    }
}
