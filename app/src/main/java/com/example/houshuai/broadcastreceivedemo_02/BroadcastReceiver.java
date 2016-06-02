package com.example.houshuai.broadcastreceivedemo_02;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by HouShuai on 2016/6/2.
 */

public class BroadcastReceiver extends android.content.BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,intent.getStringExtra("something"),Toast.LENGTH_LONG).show();

    }
}
