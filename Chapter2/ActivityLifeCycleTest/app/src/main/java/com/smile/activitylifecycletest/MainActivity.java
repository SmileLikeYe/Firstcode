package com.smile.activitylifecycletest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import java.util.jar.Manifest;

public class MainActivity extends Activity {
    public static final String LOGTAG = "MainAcitvity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOGTAG, "onCreate");
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        Button start_normal_activity = (Button) findViewById(R.id.start_normal_activity);
        Button start_dialog_activity = (Button) findViewById(R.id.start_dialog_activity);
        start_normal_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NormalActivity.class);
                Bundle b =  new Bundle();
                b.putString("bundle_key","bundle_value");
                intent.putExtra("intent_key", b);
                startActivity(intent);
            }
        });
        start_dialog_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DialogActivity.class);
                startActivity(intent);
            }
        });
     }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOGTAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOGTAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOGTAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOGTAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOGTAG, "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOGTAG, "onRestart");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
