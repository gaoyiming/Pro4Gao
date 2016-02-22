package com.pro4gao.base;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;

import com.pro4gao.R;
import com.pro4gao.manager.AppManager;

/**
 * Created by gao on 2015/12/9.
 */
public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    public int activityState;

    // 是否允许全屏
    private boolean mAllowFullScreen = false;
    public abstract void initWidget();
    public abstract void initData();
    private BaseApplication mBaseApp = null;
    private WindowManager mWindowManager = null;
    private View mNightView = null;
    private ViewGroup.LayoutParams mNightViewParam;
    private boolean mIsAddedView;

    public abstract void widgetClick();

    public void setAllowFullScreen(boolean allowFullScreen) {
        this.mAllowFullScreen = allowFullScreen;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        mBaseApp = (BaseApplication) getApplication();

        if (mBaseApp.isNightMode())
            setTheme(R.style.AppTheme_night);
        else
            setTheme(R.style.AppTheme_day);
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);

        mIsAddedView = false;

        if (mBaseApp.isNightMode()) {
            initNightView();
            mNightView.setBackgroundResource(R.color.night_mask);
        }


        // 竖屏锁定
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        if (mAllowFullScreen) {
            //requestWindowFeature(Window.FEATURE_NO_TITLE); // 取消标题
        }
        AppManager.getAppManager().addActivity(this);
        initWidget();
        initData();
        widgetClick();
    }

    public void intent2Activity(Class clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }
    private void initNightView() {
        if (mIsAddedView == true)
            return;
        mNightViewParam = new LayoutParams(
                LayoutParams.TYPE_APPLICATION,
                LayoutParams.FLAG_NOT_TOUCHABLE | LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSPARENT);

        mWindowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        mNightView = new View(this);
        mWindowManager.addView(mNightView, mNightViewParam);
        mIsAddedView = true;
    }
    public void recreateOnResume() {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                recreate();
            }
        }, 100);
    }
    public void ChangeToDay() {
        mBaseApp.setIsNightMode(false);
       // mNightView.setBackgroundResource(android.R.color.transparent);
    }

    public void ChangeToNight() {
        mBaseApp.setIsNightMode(true);
        initNightView();
        mNightView.setBackgroundResource(R.color.night_mask);
    }
    @Override
    protected void onDestroy() {
        if (mIsAddedView) {
            mBaseApp = null;
            mWindowManager.removeViewImmediate(mNightView);
            mWindowManager = null;
            mNightView = null;
        }
        super.onDestroy();
    }
}
