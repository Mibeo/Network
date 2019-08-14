package com.zbj.library.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.zbj.library.NetworkManager;
import com.zbj.library.type.NetType;

/**
 * Created by bingjia.zheng on 2019/8/14.
 */

public class NetworkUtils {
    /**
     * 网络是否可用
     */
    public static boolean isNetworkAvailable() {
        ConnectivityManager connMar = (ConnectivityManager) NetworkManager.getDefault().getApplication()
                .getSystemService(Context.COMPANION_DEVICE_SERVICE);
        if (connMar == null) {
            return false;
        }
        //返回所有网络信息
        @SuppressLint("MissingPermission") NetworkInfo[] info = connMar.getAllNetworkInfo();
        if (info != null) {
            for (NetworkInfo anInfo : info) {
                if (anInfo.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 获取当前的网络类型 -1：没有网络， 1：WIFI网络 ， 2：wap网络 3,：net网络
     */
    public static NetType getNetType() {
        ConnectivityManager connMgr = (ConnectivityManager) NetworkManager.getDefault().getApplication()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connMgr == null) return NetType.NONE;
        //获取当前激活的网络连接信息
        @SuppressLint("MissingPermission") NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo == null) {
            return NetType.NONE;
        }
        int nType = networkInfo.getType();
        if (nType == ConnectivityManager.TYPE_MOBILE) {
            if (networkInfo.getExtraInfo().toLowerCase().equals("cmnet")) {
                return NetType.CMNET;
            } else {
                return NetType.CMWAP;
            }
        } else if (nType == ConnectivityManager.TYPE_WIFI) {
            return NetType.WIFI;
        }
        return NetType.NONE;

    }
}
