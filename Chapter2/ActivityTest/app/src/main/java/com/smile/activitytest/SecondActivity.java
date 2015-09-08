package com.smile.activitytest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;

/**
 * Created by smile on 8/31/15.
 */
public class SecondActivity extends BaseActivity {
    protected static final String LOGTAG = "SecondActivity";


    /**

     * The actionStart method of the SecondActivity.

     * This method is called when an Activity wants to skip to SecondActivty.

     *

     * @param context

     * The start Activity of intent

     * @param param1

     * username

     * @param param2

     * password

     * @throws ServletException

     * if an error occurred

     */
    public static void actionStart(Context context, String param1, String param2) {
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra("param1", param1);
        intent.putExtra("param2", param2);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Log.d(LOGTAG, this.toString());
//        Log.d(LOGTAG, "Task id is " + getTaskId());
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.second_layout);


        Button button = (Button) findViewById(R.id.button_2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //传值到上一个Activity
//                Intent intent = new Intent();
//                intent.putExtra("data return", "Hello FirstActivity By onClick");
//                Log.d(LOGCAT, "Click Buton 2");
//                setResult(RESULT_OK, intent);
//                finish();
                //跳转到FirstActivity
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOGTAG, "Task id is " + getTaskId());
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("data return", "Hello FirstActivity By onBackPressed");
        Log.d(LOGTAG, "OnBackPressed()");
        setResult(RESULT_OK,intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOGTAG, "onDestroy");
    }
}
