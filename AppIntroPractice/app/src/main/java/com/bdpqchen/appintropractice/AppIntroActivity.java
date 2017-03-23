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
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;

/**
 * Created by bdpqchen on 17-three-23.
 */

public class AppIntroActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {

    private static final String TAG = "AppIntroActivity";
    private Context mContext;
    private ViewFlipper mFlipper;
    private GestureDetector mGestureDetector;
    private float mFlingRange = 100;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        this.mContext = this;
        mFlipper = (ViewFlipper) findViewById(R.id.view_flipper);
        mFlipper.addView(addImage(R.drawable.eighth), 0);
        mFlipper.addView(addImage(R.drawable.sixth), 1);c
//        mFlipper.addView(addImage(R.drawable.eighth), 2);
//        mFlipper.addView(addImage(R.drawable.eighth), 3);
//        mFlipper.addView(addImage(R.drawable.fifth), 4);
//        mFlipper.addView(addImage(R.drawable.fifth), 5);
        mGestureDetector = new GestureDetector(mContext, this);

    }

    private View addImage(int id) {
        ImageView imageView = new ImageView(mContext);
        Glide.with(mContext)
                .load(id)
                .asBitmap()
                .centerCrop()
                .into(imageView)
        ;
//        imageView.setImageResource(id);
        LinearLayout.LayoutParams layoutParams =
                new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }


    @Override
    public boolean onDown(MotionEvent e) {
        Log.i(TAG, "onDown()");
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        Log.i(TAG, "onShowPress()");

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        Log.i(TAG, "onSingleTapUp()");
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
//        Log.i(TAG, "onScroll()");

        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        Log.i(TAG, "onLongPress()");

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        Log.i(TAG, "onFling()");
        Log.v("motion event one getX", String.valueOf(e1.getX()));
        Log.i("motion event two getX", String.valueOf(e2.getX()));
        Log.v("motion event one getY", String.valueOf(e1.getY()));
        Log.i("motion event two getY", String.valueOf(e2.getY()));

        if (e1.getX() - e2.getX() >= mFlingRange){
            Log.i(TAG, "left fling");
            mFlipper.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.push_left_in));
            mFlipper.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.push_left_out));
            mFlipper.showNext();
        }else if (e2.getX() - e1.getX() >= mFlingRange){
            Log.i(TAG, "right fling");
            mFlipper.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.push_right_in));
            mFlipper.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.push_right_out));
            mFlipper.showPrevious();
        }

        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        return mGestureDetector.onTouchEvent(event);

    }
}
