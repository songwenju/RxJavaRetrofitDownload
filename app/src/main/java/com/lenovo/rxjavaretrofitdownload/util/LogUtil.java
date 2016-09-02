package com.lenovo.rxjavaretrofitdownload.util;

import android.util.Log;

/**
 * Log工具类
 */
public class LogUtil {
    //控制项目是否显示log
    private static boolean isShowLog = true;
    private static String mSign = "swj_rx_";

    public static void i(String tag, String msg){
        if (isShowLog){
            Log.i(mSign +tag,msg);
        }
    }

    public static void i(Object tag, String msg){
        if (isShowLog){
            Log.i(mSign +tag.getClass().getSimpleName(),msg);
        }
    }
    public static void d(String tag, String msg){
        if (isShowLog){
            Log.d(mSign +tag, msg);
        }
    }

    public static void d(Object tag, String msg){
        if (isShowLog){
            Log.d(mSign +tag.getClass().getSimpleName(), msg);
        }
    }
    public static void w(String tag, String msg){
        if (isShowLog){
            Log.w(mSign +tag, msg);
        }
    }

    public static void w(Object tag, String msg){
        if (isShowLog){
            Log.w(mSign +tag.getClass().getSimpleName(), msg);
        }
    }
    public static void e(String tag, String msg){
        if (isShowLog){
            Log.e(mSign +tag, msg);
        }
    }

    public static void e(Object tag, String msg){
        if (isShowLog){
            Log.e(mSign +tag.getClass().getSimpleName(), msg);
        }
    }
}
