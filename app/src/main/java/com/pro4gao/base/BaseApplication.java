package com.pro4gao.base;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatDelegate;

import com.morgoo.droidplugin.PluginHelper;

public class BaseApplication extends Application {
	static {
		AppCompatDelegate.setDefaultNightMode(
				AppCompatDelegate.MODE_NIGHT_NO);
	}
	private static Context context;
	private static Handler handler;
	private static int mainThreadId;
	private static Looper mainThreadLooper;
	private static Thread mainThread;
	private static BaseApplication mBaseApp;
	private boolean isNightMode;

	@Override
	public void onCreate() {
		super.onCreate();
		this.context = getApplicationContext();
		// 这里必须在super.onCreate方法之后，顺序不能变
		PluginHelper.getInstance().applicationOnCreate(getBaseContext());
		handler = new Handler();
		this.mainThreadId = android.os.Process.myTid();
		this.mainThreadLooper = getMainLooper();
		this.mainThread = Thread.currentThread();
	}

	public static Context getContext() {
		return context;
	}

	public static Handler getHandler() {
		return handler;
	}

	public static int getMainThreadId() {
		return mainThreadId;
	}

	public static Looper getMainThreadLooper() {
		return mainThreadLooper;
	}

	public static Thread getMainThread() {
		return mainThread;
	}


	public boolean isNightMode() {
		return false;
	}

	public void setIsNightMode(boolean isNightMode) {
		this.isNightMode = isNightMode;
	}

	@Override
	protected void attachBaseContext(Context base) {
		PluginHelper.getInstance().applicationAttachBaseContext(base);
		super.attachBaseContext(base);
	}
}
