package com.wmpscc.wintertraining2017.Utils;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wmpscc on 2018/1/21.
 */

public class RequestPermissions {

    private static final int PERMISSION_REQUEST_CODE = 10;
    private static OnPermissionsRequestionListenr sListenr;
    public static void requestPermissions(Activity activity, String[] permissions,
                                          OnPermissionsRequestionListenr listenr){
        sListenr= listenr;
        List<String> permissionList = new ArrayList<>();
        for (int i = 0; i < permissions.length; i++) {
            if (ContextCompat.checkSelfPermission(activity, permissions[i])
                    != PackageManager.PERMISSION_GRANTED){
                permissionList.add(permissions[i]);
            }
        }

        if (!permissionList.isEmpty()){
            ActivityCompat.requestPermissions(activity, permissionList.toArray(new String[permissionList.size()]),
                    PERMISSION_REQUEST_CODE);
        }else{
            listenr.onGranted();
        }
    }


    public interface OnPermissionsRequestionListenr{
        // 权限被同意时调用
        public void onGranted();

        //被拒绝时调用
        public void onDenied(List<String> deniedList);
    }

    public static void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == PERMISSION_REQUEST_CODE){
            if (grantResults.length > 0){
                List<String> deniedPermissions = new ArrayList<>();

                for (int i = 0; i < permissions.length; i++) {
                    if (grantResults[i] != PackageManager.PERMISSION_GRANTED){
                        deniedPermissions.add(permissions[i]);
                    }
                }

                if (deniedPermissions.isEmpty()){
                   sListenr.onGranted();
                }else{
                    sListenr.onDenied(deniedPermissions);

                }

            }
        }
    }



}
