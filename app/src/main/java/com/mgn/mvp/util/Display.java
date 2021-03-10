package com.mgn.mvp.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by Mi on 2020-10-16
 */
public class Display {

    private static DisplayMetrics init(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = null;
        if (windowManager != null) {
            displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics;
    }

    /**
     * 获取屏幕宽度(单位:px)
     * @param context
     * @return
     */
    public static int getWindowWidthPixels(Context context) {
        return init(context).widthPixels;
    }

    /**
     * 获取屏幕高度(单位:px)
     * @param context
     * @return
     */
    public static int getWindowHeightPixels(Context context) {
        return init(context).heightPixels;
    }

    /**
     * 获取设备分辨率
     * @param context
     * @return
     */
    public static float getDensity(Context context) {
        return init(context).density;
    }

    /**
     * 由单位dp转为px(像素)
     * @param context
     * @param dp
     * @return
     */
    public static int dp2px(Context context,float dp) {
        return (int)(dp * getDensity(context) + 0.5f);
    }

    /**
     * 由单位px(像素)转为dp
     * @param context
     * @param px
     * @return
     */
    public static int px2dp(Context context, float px) {
        return (int)(px / getDensity(context) + 0.5f);
    }
}
