package com.vondear.rxtools;

/**
 * Created by Vondear on 2017/7/25.
 */

import android.content.Context;
import android.os.Vibrator;

/**
 * 震动帮助类
 * androidManifest.xml中加入 以下权限
 * <uses-permission android:name="android.permission.VIBRATE" />
 */
public class RxVibrateUtils {
    private static Vibrator vibrator;

    /**
     * 简单震动
     * @param context     调用震动的Context
     * @param millisecond 震动的时间，毫秒
     */
    @SuppressWarnings("static-access")
    public static void vibrateOnce(Context context, int millisecond) {
        vibrator = (Vibrator) context.getSystemService(context.VIBRATOR_SERVICE);
        vibrator.vibrate(millisecond);
    }

    /**
     * 复杂的震动
     * @param context 调用震动的Context
     * @param pattern 震动形式
     * @param repeate 震动的次数，-1不重复，非-1为从pattern的指定下标开始重复
     */
    @SuppressWarnings("static-access")
    public static void vibrateComplicated(Context context, long[] pattern, int repeate) {
        vibrator = (Vibrator) context.getSystemService(context.VIBRATOR_SERVICE);
        vibrator.vibrate(pattern, repeate);
    }

    /**
     * 停止震动
     */
    public static void vibrateStop() {
        if (vibrator != null) {
            vibrator.cancel();
        }
    }
}