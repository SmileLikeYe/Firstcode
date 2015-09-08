package com.smile.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by smile on 9/7/15.
 */
public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Receive Cc's First Call", Toast.LENGTH_LONG).show();
        Log.d("MyBroadcastReceiver", "Smile receive Cc's Call");
        abortBroadcast();
    }

}
