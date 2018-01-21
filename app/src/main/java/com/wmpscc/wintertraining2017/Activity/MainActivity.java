package com.wmpscc.wintertraining2017.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.wmpscc.wintertraining2017.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_dialog_activity:
                startActivity(new Intent(this,DialogActivity.class));
                break;
            case R.id.bt_lucky:
                startActivity(new Intent(this,LearnForActivity.class));
                break;
            case R.id.bt_fragment_activity:
                startActivity(new Intent(this,LearnFragmentActivity.class));
                break;
            case R.id.bt_view_pager_activity:
                startActivity(new Intent(this,ViewPagerActivity.class));
                break;
            case R.id.bt_permission_activity:
                startActivity(new Intent(this, PermissionActivity.class));
                break;
            case R.id.bt_menu_activity:
                startActivity(new Intent(this, MenuActivity.class));
                break;
                case R.id.bt_recycleView_activity:
                startActivity(new Intent(this, RecycleViewActivity.class));
                break;


        }
    }
}
