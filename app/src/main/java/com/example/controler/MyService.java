package com.example.controler;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.Nullable;

public class MyService extends Service {
    DynamicReceiver dynamicReceiver;

    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        IntentFilter in = new IntentFilter();
        in.addAction("system.control");
        dynamicReceiver = new DynamicReceiver();
        registerReceiver(dynamicReceiver, in);
        Log.e("MyService", "registerReceiver");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(dynamicReceiver);
        Log.e("MyService", "unregisterReceiver");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}