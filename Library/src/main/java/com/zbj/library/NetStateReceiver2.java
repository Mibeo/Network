package com.zbj.library;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.zbj.library.listener.NetChangeObserver;
import com.zbj.library.type.NetType;
import com.zbj.library.utils.Constants;
import com.zbj.library.utils.NetworkUtils;

/**
 * Created by bingjia.zheng on 2019/8/14.
 */

public class NetStateReceiver2 extends BroadcastReceiver {
    private NetType netType;
    private NetChangeObserver listener;

    public NetStateReceiver2() {
        netType = NetType.NONE;
    }

    public void setListener(NetChangeObserver listener) {
        this.listener = listener;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent == null || intent.getAction() == null) {
            Log.e(Constants.LOG_TAG, "异常……");
            return;
        }
        //处理广播事件
        if (intent.getAction().equalsIgnoreCase(Constants.ANDROID_NET_CHANGE_ACTION)) {
            Log.e(Constants.LOG_TAG, "网络发生了变更……");
            netType = NetworkUtils.getNetType();//赋值网络的类型
            if (NetworkUtils.isNetworkAvailable()) {
                Log.e(Constants.LOG_TAG, "网络连接成功");
                if (listener != null) {
                    listener.onConnect(netType);
                }
            } else {
                Log.e(Constants.LOG_TAG, "网络连接失败");
                if (listener != null) {
                    listener.onDisconnect();
                }
            }
        }
    }
}
