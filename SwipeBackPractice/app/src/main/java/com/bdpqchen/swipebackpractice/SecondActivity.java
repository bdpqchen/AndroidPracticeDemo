package com.bdpqchen.swipebackpractice;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.oubowu.slideback.SlideBackHelper;
import com.oubowu.slideback.SlideConfig;
import com.oubowu.slideback.widget.SlideBackLayout;
import com.r0adkll.slidr.Slidr;

/**
 * Created by bdpqchen on 17-4-7.
 */

public class SecondActivity extends AppCompatActivity{


    public SlideBackLayout mSlideBackLayout;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        final Button button = (Button) findViewById(R.id.btn_start_third);
        getSupportActionBar().setTitle("Secondctivity");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SecondActivity.this, ThirdActivity.class));
                button.setText("old data");

//                finish();
            }
        });
//        Slidr.attach(this);


        mSlideBackLayout = SlideBackHelper.attach(
                // 当前Activity
                this,
                // Activity栈管理工具
                App.getActivityHelper(),
                // 参数的配置
                new SlideConfig.Builder()
                        // 屏幕是否旋转
                        .rotateScreen(true)
                        // 是否侧滑
                        .edgeOnly(false)
                        // 是否禁止侧滑
                        .lock(false)
                        // 边缘滑动的响应阈值，0~1，对应屏幕宽度*percent
                        .edgePercent(0.1f)
                        // 关闭页面的阈值，0~1，对应屏幕宽度*percent
                        .slideOutPercent(0.5f).create(),
                // 滑动的监听
                null);

//        mSlideBackLayout.

        // 其它初始化

    }
}
