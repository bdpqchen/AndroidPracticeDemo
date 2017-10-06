package com.bdpqchen.progressbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by bdpqchen on 17-10-5.
 */

public class ProgressButton extends RelativeLayout {

    private static final int STATUS_INIT = 0;
    private static final int STATUS_PROGRESS = 1;
    private static final int STATUS_ERROR = 2;
    private static final int STATUS_DOWN = 3;

    private ImageView mImageView;
    private TextView mTextView;
    private Context mContext;
    private RelativeLayout mLayout;
    private GradientDrawable mDrawable;
    private int mBackgroundColor;
    private int mCornerRadius;
    private String mText;
    private int mProgressImage;
    private int mDownImage;
    private int mErrorImage;
    private int mMeasuredWidth;
    private int mTextColor;
    private float mTextSize;
    private ProgressBar mProgressBar;
    private int mTranlateDuration = 100;
    /* Status of ProgressButton
    * 0 default, everything is as just init.
    * 1 the progress image is progressing(just like rotating), the text is invisible.
    * 2 the error image is showing, but the other view are invisible, and automatically reverse to status 0 after some times.
    * 3 the done image is showing, and then to do users want.
    * */
    private int mStatus;

    public ProgressButton(Context context) {
        super(context);
        init(null);
    }

    public ProgressButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public ProgressButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        mContext = getContext();
        mTextView = new TextView(mContext);
        mLayout = new RelativeLayout(mContext);
        mImageView = new ImageView(mContext);
        mProgressBar = new ProgressBar(mContext);
        if (attrs != null) {
            TypedArray typedValue = mContext.obtainStyledAttributes(attrs, R.styleable.ProgressButton);
            mBackgroundColor = typedValue.getColor(R.styleable.ProgressButton_backgroundColor, getResources().getColor(R.color.colorAccent));
            mCornerRadius = typedValue.getInteger(R.styleable.ProgressButton_radius, 12);
            mText = typedValue.getString(R.styleable.ProgressButton_text);
            mTextColor = typedValue.getColor(R.styleable.ProgressButton_textColor, Color.WHITE);
            mTextSize = typedValue.getDimensionPixelSize(R.styleable.ProgressButton_textSize, sp2px(14));
            mTextSize = px2sp(mTextSize);
            mDownImage = typedValue.getResourceId(R.styleable.ProgressButton_doneImage, R.drawable.ic_done_black_24dp);
            mErrorImage = typedValue.getResourceId(R.styleable.ProgressButton_errorImage, R.drawable.ic_priority_high_black_24dp);
            mProgressImage = typedValue.getResourceId(R.styleable.ProgressButton_progressImage, R.drawable.ic_refresh_black_24dp);
            typedValue.recycle();
        }


        mDrawable = new GradientDrawable();
        mDrawable.setColor(mBackgroundColor);
        mDrawable.setCornerRadius(mCornerRadius);
        mLayout.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        mLayout.setGravity(Gravity.CENTER);
        mLayout.setBackground(mDrawable);

        LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.addRule(CENTER_IN_PARENT);
        mTextView.setText(mText);
        mTextView.setGravity(Gravity.CENTER);
        mTextView.setTextSize(mTextSize);
        mTextView.setTextColor(mTextColor);
        mTextView.setLayoutParams(layoutParams);

        mLayout.addView(mTextView);

        mImageView.setLayoutParams(layoutParams);
        mImageView.setImageResource(mProgressImage);
        mImageView.setScaleType(ImageView.ScaleType.CENTER);
//        mImageView.setAlpha(0.1f);
        mImageView.setVisibility(INVISIBLE);
        mLayout.addView(mImageView);

        addView(mLayout);
        mLayout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                log("mLayout is Clicked");
                progress();
            }
        });

    }

    private void progress() {
        if (mStatus == STATUS_INIT) {
            mStatus = STATUS_PROGRESS;
            mImageView.setVisibility(VISIBLE);
            mTextView.setVisibility(INVISIBLE);
//            hideView(mTextView);
//            showView(mImageView);
            mMeasuredWidth = getWidth() - getPaddingStart() - getPaddingEnd();
            transformLayout(180,
                    mLayout.getMeasuredWidth(),
                    mLayout.getMeasuredHeight(),
                    new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            showProgress();
                        }
                    });
        }
    }

    private void transformLayout(int toRadius, int fromWidth, int toWidth, AnimatorListenerAdapter listenerAdapter) {
        final int duration = mTranlateDuration;
        ValueAnimator animator = ObjectAnimator.ofFloat(mDrawable, "cornerRadius", toRadius);
        animator.setDuration(duration);

        ValueAnimator valueAnimator = ValueAnimator.ofInt(fromWidth, toWidth);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int val = (int) valueAnimator.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams = mLayout.getLayoutParams();
                layoutParams.width = val;
                mLayout.setLayoutParams(layoutParams);
            }
        });
        animator.addListener(listenerAdapter);
        valueAnimator.setDuration(duration);
        valueAnimator.start();
        animator.start();

    }

    private void showProgress() {
        RotateAnimation animation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        mImageView.setImageResource(mProgressImage);
        animation.setRepeatCount(Animation.INFINITE);
        animation.setDuration(300);
        animation.setFillEnabled(true);
        animation.setFillAfter(true);
        animation.setInterpolator(new LinearInterpolator());
        mImageView.startAnimation(animation);
        callOnClick();
    }

    public void error() {
        if (mStatus == STATUS_PROGRESS) {
            mStatus = STATUS_ERROR;
            stopImageAnim();
            mImageView.setImageResource(mErrorImage);
            Animation shakeAnimation = new TranslateAnimation(-40, 40, 0, 0);
            shakeAnimation.setDuration(100);
            shakeAnimation.setRepeatCount(3);
            shakeAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
            shakeAnimation.setRepeatMode(Animation.REVERSE);
            mLayout.startAnimation(shakeAnimation);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    reverse();
                }
            }, 1000);
        }
    }

    public void reverse() {
        if (mStatus == STATUS_PROGRESS || mStatus == STATUS_ERROR || mStatus == STATUS_DOWN) {
            mStatus = STATUS_INIT;
            stopImageAnim();
            stopLayoutAnim();
            mImageView.setVisibility(INVISIBLE);
            transformLayout(mCornerRadius, mLayout.getMeasuredWidth(), mMeasuredWidth,
                    new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
//                            showProgress();
                            mTextView.setVisibility(VISIBLE);

                        }
                    });
        }
    }

    public void done() {
        if (mStatus == STATUS_PROGRESS) {
            mStatus = STATUS_DOWN;
            stopImageAnim();
            stopLayoutAnim();
            mImageView.setImageResource(mDownImage);
        }
    }

    private void stopImageAnim() {
        Animation animation = mImageView.getAnimation();
        if (animation != null) {
            animation.cancel();
        }
        mImageView.clearAnimation();
    }

    private void stopLayoutAnim() {
        Animation shakeAnimation = mLayout.getAnimation();
        if (shakeAnimation != null) {
            shakeAnimation.cancel();
        }
        mLayout.clearAnimation();
    }

    public void setOnBtnClickListener(OnClickListener listener) {
        setOnClickListener(listener);
    }

    private float px2sp(float px) {
        return px / getScaleDensity();
    }

    private int sp2px(int sp) {
        return (int) (sp * getScaleDensity());
    }

    private float getScaleDensity() {
        return getResources().getDisplayMetrics().scaledDensity;
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
