package com.pro4gao.controller;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * ViewPager的适配器
 * <p>
 * Created by wangchenlong on 16/1/8.
 */
public class PagerAdapter extends FragmentPagerAdapter {

    private static final String[] TITLES = {
            "已安装",
            "未安装"
    };

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override public Fragment getItem(int position) {
        if (position == 0) {
         //   return new StartFragment(); // 已安装页
        } else {
           // return new StoreFragment(); // 想要安装页
        }
        return null;
    }

    @Override public int getCount() {
        return TITLES.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES[position];
    }
}
