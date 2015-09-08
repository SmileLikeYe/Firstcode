package com.smile.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by smile on 9/7/15.
 */
public class BootCompeltedReveiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Cc boots Smile love heart", Toast.LENGTH_SHORT).show();
    }


}
