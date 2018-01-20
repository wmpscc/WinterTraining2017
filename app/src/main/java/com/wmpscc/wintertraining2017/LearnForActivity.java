package com.wmpscc.wintertraining2017;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class LearnForActivity extends AppCompatActivity {

    private static final String TAG = "LearnForActivity";   // logt
    private static final String EXTRA_SAVE = "save_lucky";
    private Button btTest;
    private TextView tvNumber;
    private final int REQUEST_FOR_LUCKY = 1;
    private int luckynumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_for);
        btTest = findViewById(R.id.bt_test_lucky);
        tvNumber = findViewById(R.id.tv_lucky_number);

        Log.i(TAG, "onCreat: is called");


        btTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                luckynumber = random.nextInt(101);
                tvNumber.setText("" + luckynumber);
                Intent intent = LuckyActivity.newIntent(LearnForActivity.this, luckynumber);
//                Intent intent = new Intent(LearnForActivity.this, LuckyActivity.class);
//                intent.putExtra("lucky",luckynumber);
                startActivityForResult(intent, REQUEST_FOR_LUCKY);      // activity结束时返回数据
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: is called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: is called");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: is called");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: is called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestory: is called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart: is called");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode != Activity.RESULT_OK)
            return;
        if (requestCode == REQUEST_FOR_LUCKY){
            String lucky = data.getStringExtra("lucky");
            tvNumber.setText(lucky);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstantState: is called");
        String lucky = tvNumber.getText().toString();
        outState.putString(EXTRA_SAVE, lucky);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "onRestoreInstantState: is called");
        tvNumber.setText(savedInstanceState.getString(EXTRA_SAVE));
    }
}
