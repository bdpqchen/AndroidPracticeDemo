package com.bdpqchen.progressbutton;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;

/**
 * Created by bdpqchen on 17-10-5.
 */

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        final ProgressButton progressButton = findViewById(R.id.btn);
        progressButton.setOnBtnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("onClicked", "btn");
            }
        });

        Button stop = findViewById(R.id.btn_stop);
        Button reverse = findViewById(R.id.btn_reverse);
        final Button done = findViewById(R.id.btn_done);

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressButton.error();
            }
        });
        reverse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressButton.reverse();
            }
        });
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressButton.done();
                log(done.getPivotX());
                log(done.getPivotY());
                log(done.getWidth());

                RotateAnimation animation = new RotateAnimation(0, 360, done.getPivotX(), done.getPivotY());
                animation.setDuration(1000);
                animation.setRepeatCount(3);
                done.startAnimation(animation);
            }
        });


    }



    private void log(String s) {
        Log.d("progress_button_log", s);
    }

    private void log(float f) {
        log(String.valueOf(f));
    }

    private void log(int s) {
        log(String.valueOf(s));
    }

}
