package com.smile.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by smile on 8/31/15.
 */
public class ThirdActivity extends BaseActivity {
    protected static final String LOGTAG = "ThirdActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Log.d(LOGTAG, "Task id is " + getTaskId());
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.third_layout);

        Button button = (Button) findViewById(R.id.button_3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到拨号盘
//                Intent intent = new Intent(Intent.ACTION_DIAL);
//                intent.setData(Uri.parse("tel:10086"));
//                startActivity(intent);
                //退出 必须放在finishAll()的前面，不然不会执行
                Log.d(LOGTAG, "You quit");
                ActivityCollector.finishAll();

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOGTAG, "Task id is " + getTaskId());
    }
}
