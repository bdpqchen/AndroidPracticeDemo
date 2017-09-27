package com.bdpqchen.transitionpractice;

import android.os.Build;
import android.transition.Slide;
import android.view.Window;

/**
 * Created by bdpqchen on 17-9-24.
 */

public final class TransUtil {
    private static int sdkInt = Build.VERSION.SDK_INT;
    private static int versionCode = Build.VERSION_CODES.LOLLIPOP;

    private static boolean can() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
    }

    public static void slide(Window window, Slide slide) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setEnterTransition(slide);
        }

    }

    private static Slide getSlide(int gravity) {
        Slide slide = null;
        if (can()) {
            slide = new Slide();
            slide.setSlideEdge(gravity);
            slide.excludeTarget(android.R.id.statusBarBackground, true);
            slide.excludeTarget(android.R.id.navigationBarBackground, true);
        }
        return slide;
    }



}
