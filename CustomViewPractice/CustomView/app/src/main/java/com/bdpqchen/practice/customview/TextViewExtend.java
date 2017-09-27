package com.bdpqchen.practice.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import java.util.function.LongUnaryOperator;

/**
 * Created by bdpqchen on 17-9-21.
 */

public class TextViewExtend extends android.support.v7.widget.AppCompatTextView {

    private int mWidth;
    private Paint mPaint;
    private LinearGradient mLinearGradient;
    private Matrix mGradientMatrix;
    private int mTranslate;

    public TextViewExtend(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
       /* Paint paint1 = new Paint(), paint2 = new Paint();
        paint1.setColor(getColor(R.color.colorPrimaryDark));
        paint1.setStyle(Paint.Style.FILL);

        paint2.setColor(Color.RED);
        paint2.setStyle(Paint.Style.FILL);

        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), paint1);
        canvas.drawRect(10, 10, getMeasuredWidth() - 10, getMeasuredHeight() - 10, paint2);
        canvas.save();
        canvas.translate(0, 0);*/
        super.onDraw(canvas);
//        canvas.restore();
        if (mGradientMatrix != null){
            Log.d("onDraw()", String.valueOf(mTranslate));

            mTranslate += mWidth / 5;
            if (mTranslate > 2 * mWidth){
                mTranslate = -mWidth;
            }

            mGradientMatrix.setTranslate(mTranslate, 0);
            mLinearGradient.setLocalMatrix(mGradientMatrix);
            postInvalidateDelayed(100);
        }


    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
//        if (mWidth == 0) {
        mWidth = getMeasuredWidth();
        Log.d("onSizeChanged", String.valueOf(mWidth));
        if (mWidth > 0) {
                mPaint = new Paint();
                mLinearGradient = new LinearGradient(0, 0, mWidth, 0,
                        new int[]{Color.BLUE, 0xffffff, Color.BLUE},
                        null,
                        Shader.TileMode.CLAMP
                );
                mPaint.setShader(mLinearGradient);
                mGradientMatrix = new Matrix();
            }
//        }
    }

    int getColor(int color) {
        return ContextCompat.getColor(getContext(), color);
//        return getResources().getColor(color, );
    }

}
