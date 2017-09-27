package com.bdpqchen.practice.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.function.LongUnaryOperator;

/**
 * Created by bdpqchen on 17-9-26.
 */

public class BottomToolsLayout extends LinearLayout {

    private int mTabColor;
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private LinearLayout mLayout;
    private float mIconSize;
    private int mIconTint;

    public BottomToolsLayout(Context context) {
        super(context);
        init(null);
    }

    public BottomToolsLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        mContext = getContext();
        if (attrs != null) {
            TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.BottomToolsLayout);
            mIconTint = typedArray.getColor(R.styleable.BottomToolsLayout_tabIconTint, getResources().getColor(R.color.colorBottomToolsIconTint));
            mIconSize = typedArray.getDimensionPixelSize(R.styleable.BottomToolsLayout_tabIconSize, 0);
            Log.d("iconsize", String.valueOf(mIconSize));
            typedArray.recycle();
        }
        mLayoutInflater = LayoutInflater.from(mContext);
        mLayout = new LinearLayout(mContext);
        mLayout.setOrientation(HORIZONTAL);
        mLayout.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        addView(mLayout, params);

    }

    private int getImageMargin(int resSize, int defWidth) {
        int result;
        int rest = WindowUtil.getWindowWidth(mContext) / resSize - defWidth;
        result = rest / 2;
        return result;
    }

    public void addTabs(@DrawableRes int[] reses, @IdRes int[] ids, OnClickListener listener) {
        int defWidth = (int) mIconSize;
        int size = reses.length;
        int imageMargin = getImageMargin(size, defWidth);
        for (int i = 0; i < size; i++) {
            ImageView view = (ImageView) mLayoutInflater.inflate(R.layout.view_bottom_tab_icon, null);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(defWidth, defWidth);
            lp.setMargins(imageMargin, 0, imageMargin, 0);
            view.setLayoutParams(lp);
            view.setColorFilter(mIconTint, PorterDuff.Mode.SRC_IN);
            view.setImageResource(reses[i]);
            view.setId(ids[i]);
            view.setOnClickListener(listener);
            mLayout.addView(view);
        }

    }

}
