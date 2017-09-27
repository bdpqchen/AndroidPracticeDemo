package com.bdpqchen.practice.customview;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;

import static android.view.MotionEvent.ACTION_DOWN;

/**
 * Created by bdpqchen on 17-9-21.
 */

public class CustomViewGroup extends ViewGroup {

    private int mScreenHeight;

    private int mStart;
    private int mLastY, mEnd;
    private Scroller mScroller;



    public CustomViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        mScreenHeight = getScreenHeight();
        mScroller = new Scroller(context);

        Log.d("mScreenHeight", String.valueOf(mScreenHeight));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.d("onMeasure()", String.valueOf(heightMeasureSpec));
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View childView = getChildAt(i);
            //测量所有子view
            measureChild(childView, widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();
        MarginLayoutParams mlp = (MarginLayoutParams) getLayoutParams();
        //确定子view的布局
        mlp.height = mScreenHeight * childCount - 100;
//        mlp.width =
        setLayoutParams(mlp);


        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() != View.GONE)
            child.layout(l, i * mScreenHeight, r, (i + 1) * mScreenHeight);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        int y = (int) ev.getY();
        switch (ev.getAction()) {
            case ACTION_DOWN:
                mLastY = y;
                mStart = getScrollY();
                break;
            case MotionEvent.ACTION_MOVE:
                if (!mScroller.isFinished()) {
                    mScroller.abortAnimation();
                }
                int dy = mLastY - y;
                if (getScrollY() < 0){
                    dy = 0;
                }
                if (getScrollY() > getHeight() - mScreenHeight){
                    dy =0;
                }
                scrollBy(0, dy);
                mLastY = y;
                break;
            case MotionEvent.ACTION_UP:
                mEnd = getScrollY();
                int dScrollY = mEnd - mStart;
                if (dScrollY > 0){
                    if (dScrollY < mScreenHeight / 5){
                        mScroller.startScroll(0, getScrollY(), 0, -dScrollY);
                    }else{
                        mScroller.startScroll(0, getScrollY(), 0, mScreenHeight - dScrollY);
                    }
                }else{
                    if (-dScrollY < mScreenHeight / 5){
                        mScroller.startScroll(0, getScrollY(), 0, -dScrollY);
                    }else {
                        mScroller.startScroll(0, getScrollY(), 0, -mScreenHeight - dScrollY);
                    }
                }
                break;
        }
        postInvalidate();
        return true;
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
//        Log.d("computeScroll()", String.valueOf(mScroller.computeScrollOffset()));
        if (mScroller.computeScrollOffset()){
            scrollTo(0, mScroller.getCurrY());
            postInvalidate();
        }
    }

    private int getScreenHeight(){
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

}
