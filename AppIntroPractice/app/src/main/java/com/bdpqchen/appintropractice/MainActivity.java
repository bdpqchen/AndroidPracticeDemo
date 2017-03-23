package com.bdpqchen.appintropractice;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mContext = this;
        setContentView(R.layout.activity_main);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
//                startActivity(new Intent(mContext, AppIntroActivity.class));
                startActivity(new Intent(mContext, ScreenSlideViewPager.class));
            }
        });
        thread.start();



    }
}
