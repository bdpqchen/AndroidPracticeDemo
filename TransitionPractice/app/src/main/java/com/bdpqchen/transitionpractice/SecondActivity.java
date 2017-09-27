package com.bdpqchen.transitionpractice;

import android.animation.Animator;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;


/**
 * Created by bdpqchen on 17-9-24.
 */

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupTransition();
        setContentView(R.layout.second_activity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);


    }

    private void setupTransition() {
//        TransUtil.upSlideOut(getWindow());
        Slide slide = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            slide = new Slide();
            slide.setSlideEdge(Gravity.TOP);
            slide.excludeTarget(android.R.id.statusBarBackground, true);
            slide.excludeTarget(android.R.id.navigationBarBackground, true);
//            getWindow().setExitTransition(slide);
        }
        Fade fade = new Fade();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setEnterTransition(fade);
        }

//        TransUtil.rightSlideIn(getWindow());
        if (can()){
            Transition transition = TransitionInflater.from(this).inflateTransition(R.transition.slide_and_fade);
            getWindow().setEnterTransition(transition);
        }


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            finishAfterTransition();
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        switch (item.getItemId()) {
            case android.R.id.home:
                ActivityCompat.finishAfterTransition(this);
                break;
        }
        return true;
    }

    private Animator animateRevealColorFromCoordinates(ViewGroup viewRoot, @ColorRes int color, int x, int y) {
        float finalRadius = (float) Math.hypot(viewRoot.getWidth(), viewRoot.getHeight());

        Animator anim = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            anim = ViewAnimationUtils.createCircularReveal(viewRoot, x, y, 0, finalRadius);
        }
        viewRoot.setBackgroundColor(ContextCompat.getColor(this, color));
        anim.setDuration(1000);
        anim.setInterpolator(new AccelerateDecelerateInterpolator());
        anim.start();
        return anim;
    }

    private boolean can(){
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
    }

}
