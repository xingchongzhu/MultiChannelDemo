package java.com.android.base;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.base.BaseFlags;
import com.data.multichanneldemo.BuildConfig;

import androidx.core.util.Consumer;

/**
 * @author: ${zhuxingchong}
 * @date: 2021/3/25
 * @description $desc$
 */
public final class FeatureFlags extends BaseFlags<Class> {
    private String TAG = getClass().getSimpleName();

    public FeatureFlags() {
        super();
        channel = new Consumer() {
            @Override
            public void accept(Object o) {
                if(o instanceof Button){
                    ((Button)o).setText("点击进入中国界面");
                }
                Log.d(TAG,"我是国内版本 "+o);
            }
        };
    }

    @Override
    public void clickButton(Context content, Class className) {
        Intent intent = new Intent(content,className);
        content.startActivity(intent);
        Log.d(TAG,"isDevVersion FLAVOR = "+BuildConfig.FLAVOR+" channel = "+channel);
    }

}
