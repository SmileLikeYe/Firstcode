package com.smile.broadcastbestpractice;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by smile on 9/8/15.
 */
public class ActivityCollector {

    public static List<BaseActivity> activities = new ArrayList<BaseActivity>();

    public ActivityCollector() {
        activities = new ArrayList<BaseActivity>();
    }

    public static void addActivity(BaseActivity activity) {
        if (activity != null) {
            activities.add(activity);
            Log.d("CCDEBUG",activity.getClass().getName());
        }
    }

    public static void removeActivity(BaseActivity activity) {
        if (activity != null) {
            activities.remove(activity);
        }
    }

    public static void destroyAll() {
        if (activities.isEmpty()) {
            return;
        }else {
            for (BaseActivity activity : activities) {
                if (!activity.isFinishing()) {
                    activity.finish();
                }
            }
        }
    }
}
