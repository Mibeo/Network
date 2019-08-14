package com.zbj.library.type;

/**
 * Created by bingjia.zheng on 2019/8/14.
 */

/**
 * 网络类型
 */
public enum NetType {
    //有网络，包括：WIFI/Gprs
    AUTO,

    //WIFI网络
    WIFI,

    //主要用于PC / 笔记本电脑 / PDA上网设备
    CMNET,

    //手机上网
    CMWAP,

    //没有网络
    NONE,

}
