package com.smile.uisizetest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity {
    public ListView msgListView;
    public EditText inputText;
    public Button send;
    public ArrayList<Msg> msgs = new ArrayList<Msg>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        msgListView = (ListView) findViewById(R.id.msg_list_view);
        inputText = (EditText) findViewById(R.id.input_text);
        send = (Button) findViewById(R.id.send);
        InitMsgs();
        final MsgAdapter adapter = new MsgAdapter(MainActivity.this, R.layout.msg_item, msgs);
        msgListView.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = inputText.getText().toString();
                if (!"".equals(content)) {
                    Msg msg = new Msg(content, Msg.SEND);
                    msgs.add(msg);
                    adapter.notifyDataSetChanged();
                    msgListView.setSelection(msgs.size());
                    inputText.setText("");
                }
            }
        });



    }

    public void InitMsgs() {
        Msg msg = new Msg("Hi, Nice to meet you!", Msg.RECEIVED);
        msgs.add(msg);
        msg = new Msg("Hi,\n Nice to meet you too.", Msg.SEND);
        msgs.add(msg);
        msg = new Msg("hahhahhhahahhahahahahhahahahhhahhahahhhahahhahahahahhaha,ha",Msg.RECEIVED);
        msgs.add(msg);
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
