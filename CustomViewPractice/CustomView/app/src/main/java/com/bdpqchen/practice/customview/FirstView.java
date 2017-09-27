package com.bdpqchen.practice.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import static android.view.View.MeasureSpec.AT_MOST;

/**
 * Created by bdpqchen on 17-9-21.
 */

public class FirstView extends View {


    public FirstView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(measureWidth(widthMeasureSpec), measureHeight(heightMeasureSpec));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(getResources().getColor(R.color.colorAccent));
    }

    private int measureWidth(int measureSpec){
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        if (specMode == MeasureSpec.EXACTLY){
            result = specSize;
        }else{
            result = 400;
            if (specMode == AT_MOST){
                result = Math.min(result, specSize);
            }
        }
        return result;
    }

    private int measureHeight(int measureSpec){
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        if (specMode == MeasureSpec.EXACTLY){
            result = specSize;
        }else{
            result = 400;
            if (specMode == AT_MOST){
                result = Math.min(result, specSize);
            }
        }
        return result;
    }

}
