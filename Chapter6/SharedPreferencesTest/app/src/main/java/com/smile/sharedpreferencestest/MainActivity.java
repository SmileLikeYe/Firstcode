package com.smile.sharedpreferencestest;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MainActivity extends Activity {

    private Button create;
    private Button begin;
    private TextView show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        create = (Button) findViewById(R.id.create_story);
        begin = (Button) findViewById(R.id.begin_story);
        show = (TextView) findViewById(R.id.show_story);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = MainActivity.this.getSharedPreferences("data", Context.MODE_PRIVATE).edit();
                editor.putString("hero", "HX");
                editor.putString("heroine", "YYC");
                editor.putBoolean("isLoved", true);
                Set plots = new HashSet();
                plots.add("hero falled in love with heroine.");
                plots.add("heronie said she didn't have any love feeling about hero.");
                plots.add("hero becomes a hero to me ,to her, to world.");
                editor.putStringSet("plots", plots);
                editor.commit();
                Log.d("gggg", "OKOKOKOK");
            }
        });

        begin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences("data", Context.MODE_PRIVATE);
                String hero = sp.getString("hero", "NONE");
                String heroine = sp.getString("heroine", "NONE");
                Boolean isLoved = sp.getBoolean("isLoved", false);
                Set plots;
                plots = sp.getStringSet("plots", null);
                if (isLoved) {
                    show.setText(hero + " Loved " + heroine + " so much.\n");
                    Iterator it = plots.iterator();
                    while (it.hasNext()) {
                        Object ob = it.next();
                        show.append(ob.toString() + "\n");
                        Log.d("gggg", ob.toString());
                    }
                    Log.d("gggg", "love");
                }else {
                    show.setText("Sorry, no love here.");
                    Log.d("gggg", "no love");
                }

            }
        });

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
