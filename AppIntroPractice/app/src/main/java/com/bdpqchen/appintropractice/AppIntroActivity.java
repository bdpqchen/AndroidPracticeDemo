package com.bdpqchen.appintropractice;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

/**
 * Created by bdpqchen on 17-3-23.
 */

public class AppIntroActivity extends AppCompatActivity implements GestureDetector.OnGestureListener{

    private Context mContext;
    private ViewFlipper mFilpper;
    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        this.mContext = this;
        mFilpper = (ViewFlipper) findViewById(R.id.view_flipper);
        mFilpper.addView(addImage(R.mipmap.ic_launcher), 0);
        mFilpper.addView(addImage(R.mipmap.ic_launcher), 1);
        gestureDetector = new GestureDetector(mContext, this);

    }

    private View addImage(int id) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(id);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }


    @Override
    public boolean onDown(MotionEvent e) {
        Log.i()
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

        return false;
    }
}
