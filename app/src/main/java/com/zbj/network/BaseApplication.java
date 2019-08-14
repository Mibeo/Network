package com.zbj.network;

import android.app.Application;

import com.zbj.library.NetworkManager;

/**
 * Created by bingjia.zheng on 2019/8/14.
 */

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        NetworkManager.getDefault().init(this);
//        NetworkManager.getDefault().register(this);
    }
}
