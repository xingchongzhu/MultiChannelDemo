package com.android.multichanneldemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.base.SecondActivity;
import com.android.chanel.CommonToolImpl;
import com.data.multichanneldemo.R;

import java.com.android.base.FeatureFlags;

/**
 * @author: ${朱行冲}
 * @date: 2021/3/30
 * @description 验证多渠道打包，模拟内存泄漏koom上报内存泄漏
 */
public class MainActivity extends Activity implements View.OnClickListener{
    private static final String TAG = "KOOM";
    private Handler mainHandler;
    FeatureFlags featureFlags;
    private Button reportButton;
    private TextView reportText;
    private CommonToolImpl mCommonToolImpl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        mCommonToolImpl = new CommonToolImpl();
        featureFlags = new FeatureFlags();

        Button button = findViewById(R.id.button);
        button.setOnClickListener(this);

        featureFlags.setButtonLabel(button);

        reportButton = findViewById(R.id.btn_report_leak);
        reportText = findViewById(R.id.tv_report_status);

        findViewById(R.id.btn_report_leak).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                featureFlags.clickButton(this,SecondActivity.class);
                break;
            case R.id.btn_report_leak:
                //reportButton.setVisibility(View.GONE);
                reportText.setVisibility(View.VISIBLE);
                mCommonToolImpl.makeLeak(MainActivity.this);
                testReport();
                break;
            default:
                break;
        }
    }

    public void testReport() {
        mCommonToolImpl.triggerReport();
    }
}
