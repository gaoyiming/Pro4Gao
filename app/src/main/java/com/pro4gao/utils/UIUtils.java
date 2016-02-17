package com.pro4gao.utils;


import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;

import com.pro4gao.base.BaseApplication;

public class UIUtils {
	
	public static Context getContext() {
		return BaseApplication.getContext();
	}
	public static int getMainThreadId(){
		return BaseApplication.getMainThreadId();
	}
	public static Looper getMainThreadLooper(){
		return BaseApplication.getMainThreadLooper();
	}
	public static Thread getMainThread(){
		return BaseApplication.getMainThread();
	}
	public static Handler getHandler(){
		return BaseApplication.getHandler();
	}
	public static Resources getResource(){
		return getContext().getResources();
	}
	public static String getString(int id){
		return getResource().getString(id);
	}
	public static String[] getStringArray(int id){
		return getResource().getStringArray(id);
	}
	public static int dp2Px(int dp){
		float scale = getResource().getDisplayMetrics().density;//dp与px转换比例
		return (int) (dp * scale +0.5);
	}
	public static int px2Dp(int px){
		float scale = getResource().getDisplayMetrics().density;//dp与px转换比例
		return (int) (px / scale +0.5);
	}
	public static boolean isRunInMainThread(){
		return BaseApplication.getMainThreadId() == android.os.Process.myTid();
	}
	public static void runInMainThread(Runnable runnable){
		if (isRunInMainThread()) {
			runnable.run();
		}else {
			getHandler().post(runnable);
		}
	}
	public static ColorStateList getColorStateList(int mTabTextColorResId){
		return getResource().getColorStateList(mTabTextColorResId);
	}
	public static Drawable getDrawable(int mTabBackgroundResId){
		return getResource().getDrawable(mTabBackgroundResId);
	}
	public static View inflate(int id){
		return View.inflate(getContext(), id, null);
	}
	public static int getColor(int id){
		return getResource().getColor(id);
	}
	public static int getDimens(int id) {
		return getResource().getDimensionPixelSize(id);
	}
	public static void removeCallBacks(Runnable runnable){
		getHandler().removeCallbacks(runnable);
	}
	public static void postDelayed(Runnable runnable,long delaytime){
		getHandler().postDelayed(runnable, delaytime);
	}
}
