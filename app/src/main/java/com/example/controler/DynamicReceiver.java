package com.example.controler;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.util.Log;

public class DynamicReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("DynamicReceiver", "onReceive");
        // 动态广播
        String keyCode = intent.getStringExtra("keyCode");
        AudioManager audioManager = (AudioManager)context.getSystemService(Context.AUDIO_SERVICE);
        switch (keyCode) {
            case "mute":
                Log.e("DynamicReceiver", "执行 mute指令");
                audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
                break;
            case "cancelMute":
                Log.e("DynamicReceiver", "执行 cancelMute指令");
                audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                break;
            default:
                Log.e("DynamicReceiver", "错误指令指令");
                break;
        }
    }
}