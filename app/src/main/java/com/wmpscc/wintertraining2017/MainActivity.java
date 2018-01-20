package com.wmpscc.wintertraining2017;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

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
        }

    }
}
