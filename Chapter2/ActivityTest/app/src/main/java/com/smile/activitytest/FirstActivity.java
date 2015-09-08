package com.smile.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by smile on 8/31/15.
 */
public class FirstActivity extends BaseActivity {
    protected static final String LOGTAG = "FirstActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //隐藏ActionBar
//        getActionBar().hide();
//        getActionBar().setDisplayShowTitleEnabled(false);
//        getActionBar().setDisplayShowHomeEnabled(false);
        //打印当前类的包名 + 类名@内存地址
//        Log.d(LOGTAG, this.toString());
        //打印当前栈的任务ID
//        Log.d(LOGTAG, "Task id is " + getTaskId());
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.first_layout);

        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //出现提示框
//                finish();
//                Toast.makeText(FirstActivity.this, "You Click Button 1!", Toast.LENGTH_SHORT).show();
                //显示跳转到SecondActivity
//                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                //隐式跳转到SecondAcitivity
//                Intent intent = new Intent("com.smile.activitytest.ACTION_START");
//                intent.addCategory("com.smile.activitytest.MY_CATEGORY");
                //跳转到ACTION_VIEW
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("http://www.baidu.com"));
                //跳转到自身
//                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
//                startActivityForResult(intent, 1); //这里开了这个方法 就不要用startActivity();

                //调用SecondeActivity提供的跳转方法
                SecondActivity.actionStart(FirstActivity.this, "User1", "1234");

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(FirstActivity.this, "You Click Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(FirstActivity.this, "You Click Remove", Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOGTAG, "Task id is " + getTaskId());
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    Log.d(LOGTAG, data.getStringExtra("data return"));
                }
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOGTAG, "onRestart");
    }
}