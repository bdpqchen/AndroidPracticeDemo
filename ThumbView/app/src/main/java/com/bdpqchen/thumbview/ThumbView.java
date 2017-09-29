package com.bdpqchen.thumbview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.support.annotation.Nullable;
import android.support.v4.content.res.ResourcesCompat;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by bdpqchen on 17-9-29.
 */

public class ThumbView extends LinearLayout {

    private int mLike = 0;
    private boolean mIsLiked = false;
    private Context mContext;
    private LinearLayout mLayout;
    private ImageView mImageView;
    private TextView mTextView;

    public ThumbView(Context context) {
        super(context);
        init(null);
    }

    public ThumbView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }


    private void init(AttributeSet attrs) {
        mContext = getContext();

        if (attrs != null) {
            TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.ThumbView);
            mLike = Integer.parseInt(typedArray.getString(R.styleable.ThumbView_like));
            mIsLiked = typedArray.getBoolean(R.styleable.ThumbView_is_liked, false);
            typedArray.recycle();
        }
        mLayout = new LinearLayout(mContext);
        mLayout.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        addView(mLayout, params);
        addThumb();
        addCount();


    }

    private void addCount() {
        mTextView = new TextView(mContext);
//        mTextView.
        setLikeCount(mLike);
    }

    private void addThumb() {
        mImageView = new ImageView(mContext);
        mImageView.setImageResource(R.drawable.ic_thumb_up_black_24dp);
        mImageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mIsLiked) {
                    unlike();
                } else {
                    addLike();
                }
            }
        });

        mLayout.addView(mImageView);
        mLayout.addView(mTextView);
    }

    public void setLikeCount(int count) {
        if (count < 0) count = 0;
        mTextView.setText(String.valueOf(count));
    }

    public void setImageColorTint(int tint) {
        if (mImageView != null) {
            mImageView.setColorFilter(tint, PorterDuff.Mode.SRC_IN);
        }
    }

    public void addLike() {
        mLike++;
        mIsLiked = true;
//        mImageView.startAnimation();
        setImageColorTint(mContext.getResources().getColor(R.color.colorThumbUp));
    }

    public void unlike() {
        minusLike();
        mIsLiked = false;
//        mImageView.startAnimation();
        setImageColorTint(mContext.getResources().getColor(R.color.colorThumbDown));
    }

    private void minusLike() {
        if (mLike > 0) mLike--;
        else mLike = 0;

    }


}
