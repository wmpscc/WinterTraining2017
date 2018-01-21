package com.wmpscc.wintertraining2017.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.wmpscc.wintertraining2017.Adapter.RecycleAdapter;
import com.wmpscc.wintertraining2017.R;
import com.wmpscc.wintertraining2017.bean.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RecycleViewActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);
        //1.初始化
        mRecyclerView = findViewById(R.id.recycle_view);
        //2.设置布局
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //3.初始化adapter
        List<User> userList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            userList.add(new User("username", random.nextInt(101)));
        }
        RecycleAdapter adapter = new RecycleAdapter(userList);
        mRecyclerView.setAdapter(adapter);


        adapter.setOnItemClickListenr(new RecycleAdapter.OnItemClickListenr() {
            @Override
            public void onCLick(User user) {
                Toast.makeText(RecycleViewActivity.this, user.toString(),Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_recycleview, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.vertical:
                mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
                break;
            case R.id.horizontal:
                mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false ));
                break;
            case R.id.two_columns:
                mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
