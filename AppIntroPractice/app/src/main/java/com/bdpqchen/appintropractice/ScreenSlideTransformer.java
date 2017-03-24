package com.bdpqchen.appintropractice;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

/**
 * Created by bdpqchen on 17-3-24.
 */

public class ScreenSlideTransformer implements ViewPager.PageTransformer {

    @Override
    public void transformPage(View page, float position) {
        int pagePosition = (int) page.getTag();
        float absPosition = Math.abs(position);
        int pageWidth = page.getWidth();
        float pageWidthTimesPosition = pageWidth * position;

        if (position <= -1.0f || position >= 1.0f){
            //The page is not visible. This is a good place to stop
            // any potential work / animations you may have running.
        }else if (position == 0.0f){
            // The page is selected. This is a good time to reset Views
            // after animations as you can't always count on the PageTransformer
            // callbacks to match up perfectly.
        }else{
            // The page is currently being scrolled / swiped. This is
            // a good place to show animations that react to the user's
            // swiping as it provides a good user experience.

            View description = page.findViewById(R.id.view_pager_description);
            description.setTranslationY(-pageWidthTimesPosition / 5f);
            description.setAlpha(1.0f - absPosition);
            View image = page.findViewById(R.id.view_pager_image);
//            if (pagePosition == 0 && null != image){
            if (null != image){
                image.setAlpha(1.0f - absPosition);
                image.setTranslationX(-pageWidthTimesPosition / 1.5f);
            }

            // Finally, it can be useful to know the direction
            // of the user's swipe - if we're entering or exiting.
            // This is quite simple:
            if (position < 0) {
                // Create your out animation here
            } else {
                // Create your in animation here
            }
        }

    }
}
