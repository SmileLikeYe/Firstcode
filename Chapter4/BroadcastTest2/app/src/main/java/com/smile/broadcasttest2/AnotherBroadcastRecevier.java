package com.smile.broadcasttest2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by smile on 9/7/15.
 */
public class AnotherBroadcastRecevier extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Receive Cc's Second Call",Toast.LENGTH_LONG).show();
    }
}
