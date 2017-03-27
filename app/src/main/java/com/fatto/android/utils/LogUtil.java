package com.fatto.android.utils;

import android.util.Log;

/**
 * TODO logcat 打印工具类
 *
 * @author fattoliu
 * @version V 1.0
 * @date 17/1/16 22:56.
 */

public class LogUtil {

    /**
     * TAG 标签
     */
    private static final String TAG = "FATTO_APP_PROJECT";

    /**
     * 调试/发布 状态标志，发布时改成 false
     */
    private static boolean DEBUG = true;
    
    /**
     * error日志
     * @param msg
     */
    public static void LOGE(String msg) {
        if (DEBUG) {
            if (msg == null || msg.length() == 0)
                return;

            int segmentSize = 3 * 1024;
            long length = msg.length();
            if (length <= segmentSize ) {// 长度小于等于限制直接打印
                Log.e(TAG, msg);
            }else {
                while (msg.length() > segmentSize ) {// 循环分段打印日志
                    String logContent = msg.substring(0, segmentSize );
                    msg = msg.replace(logContent, "");
                    Log.e(TAG, logContent);
                }
                Log.e(TAG, msg);// 打印剩余日志
            }
        }
    }

    /**
     * info日志
     * @param msg
     */
    public static void LOGI(String msg) {
        if (DEBUG) {
            if (msg == null || msg.length() == 0)
                return;

            int segmentSize = 3 * 1024;
            long length = msg.length();
            if (length <= segmentSize ) {// 长度小于等于限制直接打印
                Log.i(TAG, msg);
            }else {
                while (msg.length() > segmentSize ) {// 循环分段打印日志
                    String logContent = msg.substring(0, segmentSize );
                    msg = msg.replace(logContent, "");
                    Log.i(TAG, logContent);
                }
                Log.i(TAG, msg);// 打印剩余日志
            }
        }
    }

    /**
     * wanning日志
     * @param msg
     */
    public static void LOGW(String msg) {
        if (DEBUG) {
            if (msg == null || msg.length() == 0)
                return;

            int segmentSize = 3 * 1024;
            long length = msg.length();
            if (length <= segmentSize ) {// 长度小于等于限制直接打印
                Log.w(TAG, msg);
            }else {
                while (msg.length() > segmentSize ) {// 循环分段打印日志
                    String logContent = msg.substring(0, segmentSize );
                    msg = msg.replace(logContent, "");
                    Log.w(TAG, logContent);
                }
                Log.w(TAG, msg);// 打印剩余日志
            }
        }
    }

    /**
     * debug日志
     * @param msg
     */
    public static void LOGD(String msg) {
        if (DEBUG) {
            if (msg == null || msg.length() == 0)
                return;

            int segmentSize = 3 * 1024;
            long length = msg.length();
            if (length <= segmentSize ) {// 长度小于等于限制直接打印
                Log.d(TAG, msg);
            }else {
                while (msg.length() > segmentSize ) {// 循环分段打印日志
                    String logContent = msg.substring(0, segmentSize );
                    msg = msg.replace(logContent, "");
                    Log.d(TAG, logContent);
                }
                Log.d(TAG, msg);// 打印剩余日志
            }
        }
    }

}
