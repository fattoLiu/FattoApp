package com.fatto.android;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * TODO application 类
 *
 * @author fattoliu
 * @version V 1.0
 * @date 17/2/9 09:03.
 */

public class FattoApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // 初始化内存泄漏检测
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }
}
