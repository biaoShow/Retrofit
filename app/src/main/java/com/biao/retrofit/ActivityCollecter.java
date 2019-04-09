package com.biao.retrofit;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by benxiang on 2019/4/9.
 */

public class ActivityCollecter {
    private static List<Activity> activities = new ArrayList<>();

    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    public static void removeAllActivity() {
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {
                activities.remove(activity);
                activity.finish();
            }
        }
    }

}
