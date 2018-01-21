package com.wmpscc.wintertraining2017.Activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.wmpscc.wintertraining2017.R;

import java.util.Random;

public class LuckyActivity extends AppCompatActivity {

    private  static final String EXTRA_LUCKY = "lucky";
    private TextView tvLuckNumber;
    public static Intent newIntent(Context context, int lucky){
        Intent intent = new Intent(context, LuckyActivity.class);
        intent.putExtra(EXTRA_LUCKY, lucky);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lucky);
        tvLuckNumber = findViewById(R.id.tv_test_lucky_number);

        int base = getIntent().getIntExtra(EXTRA_LUCKY, 0);
        Random random = new Random();
        int lucky = base + random.nextInt(101);
        tvLuckNumber.setText(""+lucky);

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("lucky", tvLuckNumber.getText().toString());
        setResult(Activity.RESULT_OK, intent);

        super.onBackPressed();
    }
}
