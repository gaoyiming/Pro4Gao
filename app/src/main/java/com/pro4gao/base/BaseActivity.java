package com.pro4gao.base;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;

import com.pro4gao.manager.AppManager;

/**
 * Created by gao on 2015/12/9.
 */
public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    public int activityState;

    // 是否允许全屏
    private boolean mAllowFullScreen = false;

    public abstract void initWidget();

    public abstract void widgetClick(View v);

    public void setAllowFullScreen(boolean allowFullScreen) {
        this.mAllowFullScreen = allowFullScreen;
    }

    @Override
    public void onClick(View v) {
        widgetClick(v);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 竖屏锁定
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        if (mAllowFullScreen) {
            requestWindowFeature(Window.FEATURE_NO_TITLE); // 取消标题
        }
        AppManager.getAppManager().addActivity(this);
        initWidget();
    }

    public void intent2Activity(Class clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

}
