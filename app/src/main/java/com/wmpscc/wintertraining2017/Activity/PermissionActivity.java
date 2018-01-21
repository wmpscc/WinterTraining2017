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

import java.util.ArrayList;
import java.util.List;

public class PermissionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);
    }

    public void onClick(View v){
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA},1);
        }else{
            Toast.makeText(this,"已经同意申请权限",Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1){
            if (grantResults.length > 0){
                List<String> deniedPermissions = new ArrayList<>();

                for (int i = 0; i < permissions.length; i++) {
                    if (grantResults[i] != PackageManager.PERMISSION_GRANTED){
                        deniedPermissions.add(permissions[i]);
                    }
                }

                if (deniedPermissions.isEmpty()){
                    Toast.makeText(this,"已经同意申请权限",Toast.LENGTH_SHORT).show();
                }else{
                    for (String deniedPermission: deniedPermissions) {
                        Toast.makeText(this,deniedPermission + "被拒绝",Toast.LENGTH_SHORT).show();

                    }
                }

            }
        }
    }
}
