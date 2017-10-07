package com.bdpqchen.topmessage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.bdpqchen.topmessage.reminder.Reminder;
import com.liuguangqiang.cookie.CookieBar;
import com.wizchen.topmessage.TopMessage;
import com.wizchen.topmessage.TopMessageManager;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        Button cookie = findViewById(R.id.cookie);
        cookie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("delayTest", String.valueOf(System.currentTimeMillis()));
                new Reminder.Builder(MainActivity.this)
//                        .setMessage("消息正文消息正文消息正文消息正文消息正文消息正")
                        .setMessage("消息正文消息正文消息正文消息正")
//                        .setBackgroundColor(R.color.default_bg_color)
                        .setMessageTexiSize(17)
                        .setAction("撤销", new Reminder.OnActionClickListener() {
                            @Override
                            public void onClick(View view) {
                                Log.d("action clicked", "撤销");
                            }
                        })
                        .show();
            }
        });

        Button top = findViewById(R.id.cookie2);
        top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TopMessageManager.showSuccess("这是一天消息");
            }
        });


    }
}
