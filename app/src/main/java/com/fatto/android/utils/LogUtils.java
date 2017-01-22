package com.fatto.android.utils;

import android.util.Log;

/**
 * TODO logcat 打印工具类
 *
 * @author fattoliu
 * @version V 1.0
 * @date 17/1/16 22:56.
 */

public class LogUtils {

    /**
     * TAG 标签
     */
    private static final String TAG = "FATTO_APP_PROJECT";

    /**
     * 信息 logcat
     *
     * @param log
     */
    public static void LOGI(String log) {
        Log.i(TAG, log);
    }

    /**
     * 调试 logcat
     *
     * @param log
     */
    public static void LOGD(String log) {
        Log.d(TAG, log);
    }

    /**
     * 错误 logcat
     *
     * @param log
     */
    public static void LOGE(String log) {
        Log.e(TAG, log);
    }

    /**
     * 警告 logcat
     *
     * @param log
     */
    public static void LOGW(String log) {
        Log.w(TAG, log);
    }


}
