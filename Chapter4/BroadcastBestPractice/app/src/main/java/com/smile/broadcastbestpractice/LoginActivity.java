package com.smile.broadcastbestpractice;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends BaseActivity {

    private SharedPreferences sp;

    private SharedPreferences.Editor editor;

    private TextView account;

    private TextView password;

    private Button login;

    private CheckBox rememberPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //初始化变量
        sp = LoginActivity.this.getSharedPreferences("data", MODE_PRIVATE);
        editor = sp.edit();
        account = (TextView) findViewById(R.id.account);
        password= (TextView) findViewById(R.id.password);
        rememberPassword = (CheckBox) findViewById(R.id.remember_password);
        login = (Button) findViewById(R.id.login);
        //填充用户名，密码
        String accountText = sp.getString("account", "");
        String passwordText = sp.getString("password", "");
        account.setText(accountText);
        password.setText(passwordText);
        if ("".equals(accountText)){
            rememberPassword.setChecked(false);
        }else {
            rememberPassword.setChecked(true);
        }


        //点击登录，
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if ("admin".equals(account.getText().toString()) & "1234".equals(password.getText().toString())) {
                        if (rememberPassword.isChecked()) {
                            editor.putString("account", account.getText().toString());
                            editor.putString("password", password.getText().toString());
                        }else {
                            editor.clear();
                        }
                        editor.commit();
                        MainActivity.startAction(LoginActivity.this);
                    } else {
                        Toast.makeText(LoginActivity.this, "admin\n1234\n拿好不谢^^", Toast.LENGTH_LONG).show();
                    }
                }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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
