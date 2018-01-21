package com.wmpscc.wintertraining2017.Activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wmpscc.wintertraining2017.Adapter.ViewPagerAdapter;
import com.wmpscc.wintertraining2017.R;
import com.wmpscc.wintertraining2017.fragment.TestFourFragment;
import com.wmpscc.wintertraining2017.fragment.TestOneFragment;
import com.wmpscc.wintertraining2017.fragment.TestThreeFragment;
import com.wmpscc.wintertraining2017.fragment.TestTwoFragment;

public class ViewPagerActivity extends AppCompatActivity {


    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private ViewPagerAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        mViewPager = findViewById(R.id.view_pager);
        mTabLayout = findViewById(R.id.tab_layout);

        String[] titles = {"one","Two","Three", "Four"};
        mAdapter = new ViewPagerAdapter(getSupportFragmentManager(), titles);
        mAdapter.addFragment(new TestOneFragment());
        mAdapter.addFragment(new TestTwoFragment());
        mAdapter.addFragment(new TestThreeFragment());
        mAdapter.addFragment(new TestFourFragment());

        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.setCurrentItem(0);

    }
}
