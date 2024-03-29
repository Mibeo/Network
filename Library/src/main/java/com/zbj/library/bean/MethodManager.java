package com.zbj.library.bean;

import com.zbj.library.type.NetType;

import java.lang.reflect.Method;

/**
 * Created by bingjia.zheng on 2019/8/14.
 */
//保存符合要求的网络监听注解方法，封装类
public class MethodManager {
    //参数类型：NetType netType
    private Class<?> type;

    //网络类型，netType = NetType.AUTO
    private NetType netType;

    //需要执行的方法 network()
    private Method method;

    public MethodManager(Class<?> type, NetType netType, Method method) {
        this.type = type;
        this.netType = netType;
        this.method = method;
    }

    public Class<?> getType() {
        return type;
    }

    public void setType(Class<?> type) {
        this.type = type;
    }

    public NetType getNetType() {
        return netType;
    }

    public void setNetType(NetType netType) {
        this.netType = netType;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }
}
