package com.wmpscc.wintertraining2017;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_show_dialog:
                showDialog();
                break;
            case R.id.bt_show_list_dialog:
                showListDialog();
                break;
            case R.id.bt_show_single_choose_dialog:
                showSingleChooseDialog();
                break;
            case R.id.bt_show_custom:
                showCustomDialog();
                break;


        }
    }

    private void showCustomDialog() {
        View view = LayoutInflater.from(this).inflate(R.layout.layout_custom, null,false);

        final AlertDialog alertDialog = new AlertDialog.Builder(this).setTitle("Custom Dialog")
                .setView(view)
                .create();
        alertDialog.show();
        final EditText input = view.findViewById(R.id.et_input_text);
        Button ok = view.findViewById(R.id.bt_ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = input.getText().toString();
                Toast.makeText(DialogActivity.this,text,Toast.LENGTH_SHORT).show();
                alertDialog.dismiss();
            }
        });

    }

    private void showSingleChooseDialog() {
        final String[] items = {"篮球","羽毛球","游泳","足球"};
        final String[] item = new String[1];
        item[0] = items[0];
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("选择你的爱好")
                .setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                item[0] = items[which];  // final静态变量初始化后无法修改，使用长度为1的数组来改变值。

            }
        }).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this,"选中：" + item[0],Toast.LENGTH_SHORT).show();
                    }
                }).show();
    }

    private void showListDialog() {
        final String[] items = {"篮球","羽毛球","游泳","足球"};
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("选择你的爱好")
                .setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {    // which对应点击的下标
                        String item = items[which];
                        Toast.makeText(DialogActivity.this,item,Toast.LENGTH_SHORT).show();
                    }
                }).show();

    }

    private void showDialog() {
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("Title text")
                .setMessage("Message")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).setNegativeButton("Cannel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();

    }
}
