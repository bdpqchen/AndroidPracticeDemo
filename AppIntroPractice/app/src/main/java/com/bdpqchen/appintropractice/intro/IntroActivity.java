package com.bdpqchen.appintropractice.intro;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.bdpqchen.appintropractice.R;
import com.bdpqchen.appintropractice.ScreenSlideFragment;
import com.github.paolorotolo.appintro.AppIntro2;

/**
 * Created by bdpqchen on 17-3-25.
 */

public class IntroActivity extends AppIntro2 {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addSlide(ScreenSlideFragment.newInstance(R.layout.fragment_intro_first, R.drawable.first));
        addSlide(ScreenSlideFragment.newInstance(R.layout.fragment_intro_second, R.drawable.second));
        showSkipButton(false);

//        setDepthAnimation();
//        setFadeAnimation();
        setFlowAnimation();
//setZoomAnimation();

    }
}
