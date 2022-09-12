package com.example.controler;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    DynamicReceiver dynamicReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 申请勿扰模式权限
        Button button = findViewById(R.id.send_bt);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDoNotDisturb();
            }
        });
        // 注册动态广播
        Button bt = findViewById(R.id.reg_bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentFilter in = new IntentFilter();
                in.addAction("system.control");
                dynamicReceiver = new DynamicReceiver();
                registerReceiver(dynamicReceiver, in);
                Log.e("MainActivity", "registerReceiver");
            }
        });

        // 启动service
        Button sbt = findViewById(R.id.sr_bt);
        sbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , MyService.class);
                startService(intent);
                Log.e("MainActivity", "startService");
            }
        });

    }


    private void getDoNotDisturb(){
        NotificationManager notificationManager =
                (NotificationManager) getApplication().getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N && !notificationManager.isNotificationPolicyAccessGranted()) {
            Intent intent = new Intent(android.provider.Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS);
            startActivity(intent);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(dynamicReceiver);
        Log.e("MyService", "unregisterReceiver");
    }
}