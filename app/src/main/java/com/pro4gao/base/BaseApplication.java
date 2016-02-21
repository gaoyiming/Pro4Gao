package com.pro4gao.base;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;

public class BaseApplication extends Application {
	
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
}
