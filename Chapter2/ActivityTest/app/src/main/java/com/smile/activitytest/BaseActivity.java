package com.smile.activitytest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by smile on 9/1/15.
 */
public class BaseActivity extends Activity{
    protected static final String LOGTAG = "BaseActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOGTAG, getClass().getSimpleName());
        ActivityCollector.addActivity(this);
        Log.d(LOGTAG,"activity count: " + ActivityCollector.getActivtyCount());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeAcitvity(this);
    }
}
