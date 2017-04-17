package com.bdpqchen.nightmodepractice;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.library.viewspread.helper.BaseViewHelper;

/**
 * Created by bdpqchen on 17-4-14.
 */

public class SwitchModeActivity extends BaseActivity {

    private ImageView imageView;
    private Button mButtonNight;

    private BaseViewHelper helper;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (App.isNightMode) {
            Log.i("Switch", "isnightMode");
            helper = new BaseViewHelper
                    .Builder(SwitchModeActivity.this)
                    .isFullWindow(true)
                    .isShowTransition(false)
                    .setDimColor(0xeeeeee)
                    .setDimAlpha(300)
                    .create();

            App.isNightMode = false;
        }
            setContentView(R.layout.activity_night_mode);


        mButtonNight = (Button) findViewById(R.id.btn_set_night);
        final Button buttonDay = (Button) findViewById(R.id.btn_set_day);
        Button buttonNewAct = (Button) findViewById(R.id.start_new_activity);
//        imageView = (ImageView) findViewById(R.id.light1);


        buttonDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//                showAnimation();
//                SwitchModeActivity.this.recreate();
                startMySelf(buttonDay);
            }
        });

        mButtonNight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
//                showAnimation();
//                recreate();
                startMySelf(mButtonNight);
            }
        });

        buttonNewAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SwitchModeActivity.this, CurrencyModeActivity.class));
            }
        });

    }

    public void startMySelf(View view) {
        App.isNightMode = true;
        Intent intent = new Intent(this, SwitchModeActivity.class);
        new BaseViewHelper
                .Builder(this, view)
                .startActivity(intent);
        finish();

//        startActivity(new Intent(this, SwitchModeActivity.class));

    }


    public void showAnimation() {
        final View decorView = getWindow().getDecorView();
        Bitmap cacheBitmap = getCacheBitmapFromView(decorView);
//        imageView.setImageBitmap(cacheBitmap);
        if (decorView instanceof ViewGroup && null != cacheBitmap) {
            final View view = new View(this);
            view.setBackground(new BitmapDrawable(getResources(), cacheBitmap));
            ViewGroup.LayoutParams layoutParam = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT);
            ((ViewGroup) decorView).addView(view, layoutParam);
            ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(view, "alpha", 1f, 0f);
            objectAnimator.setDuration(300);
            objectAnimator.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    ((ViewGroup) decorView).removeView(view);
                }
            });
            objectAnimator.start();

        }
    }

    private Bitmap getCacheBitmapFromView(View view) {
        final boolean drawingCacheEnabled = true;
        view.setDrawingCacheEnabled(drawingCacheEnabled);
        view.buildDrawingCache(drawingCacheEnabled);
        final Bitmap drawingCache = view.getDrawingCache();
        Bitmap bitmap;
        if (drawingCache != null) {
            bitmap = Bitmap.createBitmap(drawingCache);
            view.setDrawingCacheEnabled(false);
        } else {
            bitmap = null;
        }
        return bitmap;
    }

}
