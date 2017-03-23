package com.bdpqchen.appintropractice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by bdpqchen on 17-3-24.
 */

public class ScreenSlideFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_intro_first, container, false);
        return viewGroup;

    }
}
