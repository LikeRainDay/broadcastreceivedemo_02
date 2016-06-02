package com.example.houshuai.broadcastreceivedemo_02;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private LocalBroadcastManager manager;
    private BroadcastReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         *structure the manager
         */
        manager = LocalBroadcastManager.getInstance(this);
        receiver = new BroadcastReceiver();

        IntentFilter filter=new IntentFilter();
        filter.addAction("aa,bb,cc");
        filter.addCategory(Intent.CATEGORY_DEFAULT);
        /**
         * register broadcastreceiver
         */
        manager.registerReceiver(receiver,filter);
    }
/**
 * click the  button
 */
    public void show_something(View view) {
        Intent intent = new Intent("aa,bb,cc");
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.putExtra("something","Welcome to American " );
        manager.sendBroadcast(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        manager.unregisterReceiver(receiver);
    }
}
