package com.zbj.library.listener;

import com.zbj.library.type.NetType;

/**
 * Created by bingjia.zheng on 2019/8/14.
 */

public interface NetChangeObserver {
    void onConnect(NetType netType);
    void onDisconnect();
}
