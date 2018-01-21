package com.wmpscc.wintertraining2017.Activity;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wmpscc.wintertraining2017.Activity.base.FragmentContainerActivity;
import com.wmpscc.wintertraining2017.R;
import com.wmpscc.wintertraining2017.fragment.TestOneFragment;

public class LearnFragmentActivity extends FragmentContainerActivity {

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_learn_fragment;
    }

    @Override
    protected int getFragmentContainerId() {
        return R.id.container;
    }

    @Override
    protected Fragment creatFragment() {
        return new TestOneFragment();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_fragment);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, new TestOneFragment()).commit();
    }


}
