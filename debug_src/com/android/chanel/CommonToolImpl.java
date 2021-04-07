package com.android.chanel;

import android.content.Context;
import android.util.Log;

import com.android.base.CommonToolInterface;
import com.kwai.koom.demo.leaked.LeakMaker;
import com.kwai.koom.javaoom.KOOM;
import com.kwai.koom.javaoom.KOOMProgressListener;

/**
 * @author: ${zhuxingchong}
 * @date: 2021/4/1
 * @description $desc$
 */
public class CommonToolImpl extends CommonToolInterface<String> {

    @Override
    public void makeLeak(Context context) {
        LeakMaker.makeLeak(context);
    }

    @Override
    public void triggerReport(){
        KOOM.getInstance().manualTrigger();
        KOOM.getInstance().setProgressListener(this::changeStatusText);
    }

    private void changeStatusText(KOOMProgressListener.Progress progress) {
        chanStatusTextInMain(progress);
    }

    private void chanStatusTextInMain(KOOMProgressListener.Progress progress) {
        String text = "";
        switch (progress) {
            case HEAP_DUMP_START:
                text = "heap dump started";
                break;
            case HEAP_DUMPED:
                text = "heap dump ended";
                break;
            case HEAP_DUMP_FAILED:
                text = "heap dump failed";
                break;
            case HEAP_ANALYSIS_START:
                text = "heap analysis start";
                break;
            case HEAP_ANALYSIS_DONE:
                text = "heap analysis done, please check report in " + KOOM.getInstance().getReportDir();
                break;
            case HEAP_ANALYSIS_FAILED:
                text = "heap analysis failed";
                break;
            default:
                break;
        }
        Log.d(TAG,"chanStatusText "+text);
    }
}
