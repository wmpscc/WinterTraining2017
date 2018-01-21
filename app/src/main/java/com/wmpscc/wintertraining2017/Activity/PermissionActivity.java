package com.wmpscc.wintertraining2017.Activity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.wmpscc.wintertraining2017.R;
import com.wmpscc.wintertraining2017.Utils.RequestPermissions;

import java.util.ArrayList;
import java.util.List;

public class PermissionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);
    }

    public void onClick(View v){
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
//                != PackageManager.PERMISSION_GRANTED){
//
//            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA},1);
//        }else{
//            Toast.makeText(this,"已经同意申请权限",Toast.LENGTH_SHORT).show();
//
//        }


//        List<String> permission = new ArrayList<>();
//        if (ContextCompat.checkSelfPermission(this,Manifest.permission.CAMERA)
//                != PackageManager.PERMISSION_GRANTED){
//            permission.add(Manifest.permission.CAMERA);
//        }
//        if (ContextCompat.checkSelfPermission(this,Manifest.permission.RECORD_AUDIO)
//                != PackageManager.PERMISSION_GRANTED){
//            permission.add(Manifest.permission.RECORD_AUDIO);
//        }
//        if (!permission.isEmpty()){
//            ActivityCompat.requestPermissions(this,permission.toArray(new String[permission.size()]),1);
//        }

        RequestPermissions.requestPermissions(this, new String[]{Manifest.permission.CAMERA, Manifest.permission.RECORD_AUDIO},
                new RequestPermissions.OnPermissionsRequestionListenr() {
                    @Override
                    public void onGranted() {
                        Toast.makeText(PermissionActivity.this, "所有权限已同意",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onDenied(List<String> deniedList) {
                        for (String s: deniedList) {
                            Toast.makeText(PermissionActivity.this, s + "被拒绝",Toast.LENGTH_SHORT).show();
                        }

                    }
                });


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        RequestPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults);


//        if (requestCode == 1){
//            if (grantResults.length > 0){
//                List<String> deniedPermissions = new ArrayList<>();
//
//                for (int i = 0; i < permissions.length; i++) {
//                    if (grantResults[i] != PackageManager.PERMISSION_GRANTED){
//                        deniedPermissions.add(permissions[i]);
//                    }
//                }
//
//                if (deniedPermissions.isEmpty()){
//                    Toast.makeText(this,"已经同意申请权限",Toast.LENGTH_SHORT).show();
//                }else{
//                    for (String deniedPermission: deniedPermissions) {
//                        Toast.makeText(this,deniedPermission + "被拒绝",Toast.LENGTH_SHORT).show();
//
//                    }
//                }
//
//            }
//        }
    }
}
