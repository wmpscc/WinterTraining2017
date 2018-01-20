package com.wmpscc.wintertraining2017;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wmpscc on 2018/1/20.
 */

public class ActivityCollector {    // 管理activity栈
    private List<Activity> mActivities = new ArrayList<>();

    public void add(Activity activity){
        mActivities.add(activity);
    }
    public void remove(Activity activity){
        mActivities.remove(activity);
    }
    public void finishAll()
    {
        for (Activity temp : mActivities) {
            temp.finish();
        }
    }

}
