package com.bdpqchen.transitionpractice;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.LinearLayout;

/**
 * Created by bdpqchen on 17-9-24.
 */

public class MainActivity extends AppCompatActivity {

    Intent mIntent;
    LinearLayout mRootView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mIntent = new Intent(this, SecondActivity.class);
        mRootView = findViewById(R.id.ll_root_view);
        final Context context = this;
        final View view = findViewById(R.id.view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                animateRevealColorFromCoordinates(mRootView,
                        R.color.material_blue200,
                        (int) motionEvent.getRawX(),
                        (int) motionEvent.getRawY());

                return false;
            }
        });

    }

    private void explode() {
        startActivity(mIntent, ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle());
    }

    private void slide() {
        View decor = getWindow().getDecorView();
        View statusBar = decor.findViewById(android.R.id.statusBarBackground);
        View navBar = decor.findViewById(android.R.id.navigationBarBackground);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            Pair<View, String> pair = new Pair<>(statusBar, statusBar.getTransitionName());
            Pair<View, String> pair0 = new Pair<>(navBar, navBar.getTransitionName());
            startActivity(mIntent, ActivityOptionsCompat.makeSceneTransitionAnimation(this, pair, pair0).toBundle());
        }

    }

    private Animator animateRevealColorFromCoordinates(ViewGroup viewRoot, @ColorRes int color, int x, int y) {
        float finalRadius = (float) Math.hypot(viewRoot.getWidth(), viewRoot.getHeight());

        Animator anim = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            anim = ViewAnimationUtils.createCircularReveal(viewRoot, x, y, 0, finalRadius);
        }
        viewRoot.setBackgroundColor(ContextCompat.getColor(this, color));
        anim.setDuration(500);
        anim.setInterpolator(new AccelerateDecelerateInterpolator());
        anim.start();
        return anim;
    }

}
