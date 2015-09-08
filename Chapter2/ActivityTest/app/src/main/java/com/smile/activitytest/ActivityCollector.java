package com.smile.activitytest;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by smile on 9/1/15.
 *
 */
/**
 * 这个类设计出来是给BaseActivity用的，作为统一管理
 * 同时其中的finishAll() 也会提供给某个Activity的退出Button使用，
 * 这有有个问题，就是这里的addActivity() removeActivity() 其实是只能给BaseActivity使用的
 * 但是这里的设计是，其他Activity也能使用，也就是说这个类是多方多层使用的
 * 当然也可是在BaseActivity里面加个finishAll的方法 这样ActivityColletor就只服务于BaseAcitivty
 * 那问题来了， 如何指定某个类只能供某个特定的类调用捏？
 */

public class ActivityCollector {
    public static List<Activity> activities = new ArrayList<Activity>();

    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    public static void removeAcitvity(Activity activity) {
        activities.remove(activity);
    }

    public static void finishAll() {
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }

    public static int getActivtyCount() {
        return activities.size();
    }


}
