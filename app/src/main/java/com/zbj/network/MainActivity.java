package com.zbj.network;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.zbj.library.NetworkManager;
import com.zbj.library.annotation.Network;
import com.zbj.library.listener.NetChangeObserver;
import com.zbj.library.type.NetType;
import com.zbj.library.utils.Constants;

public class MainActivity extends AppCompatActivity /*implements NetChangeObserver*/ {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        NetworkManager.getDefault().setListener(this);
        NetworkManager.getDefault().register(this);
    }

    @Network(netType = NetType.AUTO)
    public void network(NetType netType) {
        switch (netType) {
            case WIFI:
                Log.e(Constants.LOG_TAG, "WIFI");
                break;
            case CMNET:
            case CMWAP:
                Log.e(Constants.LOG_TAG, netType.name());
                break;
            case NONE:
                Log.e(Constants.LOG_TAG, "没有网络");
                break;
        }
    }

    @Network(netType = NetType.AUTO)
    public void network2(NetType netType) {

    }

  /*  @Override
    public void onConnect(NetType netType) {
        Log.e(Constants.LOG_TAG, netType.name());
    }

    @Override
    public void onDisconnect() {
        Log.e(Constants.LOG_TAG, "onDisconnect");
    }*/
    }
