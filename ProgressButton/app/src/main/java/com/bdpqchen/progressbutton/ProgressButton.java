package com.bdpqchen.progressbutton;

import android.content.Context;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.DrawableUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by bdpqchen on 17-10-5.
 */

public class ProgressButton extends LinearLayout {
    private Paint mPaint;
    private RectF mRectF;
    private CornerPathEffect mCorner;
    private ImageView mImageView;
    private TextView mTextView;
    private ProgressBar mProgress;
    private Context mContext;
    private RelativeLayout mLayout;

    public ProgressButton(Context context) {
        super(context);
        init();
    }

    public ProgressButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ProgressButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {
        mContext = getContext();
//        mTextView = new TextView(mContext);
        mLayout = new RelativeLayout(mContext);
        mImageView = new ImageView(mContext);
        mProgress = new ProgressBar(mContext);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mLayout.setLayoutParams(lp);
        mLayout.setBackground(getResources().getDrawable(R.drawable.shape_rect_radius));
        addView(mLayout);
//        addView(mTextView);
//        mProgress.setScrollBarStyle();
//        mProgress.set
        mLayout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                log("mLayout is Clicked");
                mLayout.setBackground(getResources().getDrawable(R.drawable.shape_oval_circle));
            }
        });

    }






    private void print1(){
        log(getLeft());
        log(getTop());
        log(getRight());
        log(getBottom());
    }

    private void log(String s){
        Log.d("progressbutton_loglog", s);
    }

    private void log(int s){
        log(String.valueOf(s));
    }

    public void setOnBtnClickListener(OnClickListener listener) {
        setOnClickListener(listener);

    }
}
