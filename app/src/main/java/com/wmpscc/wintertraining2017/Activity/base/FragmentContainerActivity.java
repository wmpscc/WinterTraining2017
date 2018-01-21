package com.wmpscc.wintertraining2017.Activity.base;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by wmpscc on 2018/1/21.
 */

public abstract class FragmentContainerActivity  extends AppCompatActivity{

    @LayoutRes
    protected abstract int getLayoutResId();

    @IdRes
    protected abstract int getFragmentContainerId();

    protected abstract Fragment creatFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());

        FragmentManager fg = getSupportFragmentManager();
        Fragment fragment = fg.findFragmentById(getFragmentContainerId());
        if (null == fragment) {     // !null表示已经存在一个fragment，不需要再创建一个fragment
            fg.beginTransaction().add(getFragmentContainerId(), creatFragment()).commit();


        }

    }
}
