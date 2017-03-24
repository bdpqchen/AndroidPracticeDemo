package com.bdpqchen.appintropractice;

import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by bdpqchen on 17-3-24.
 */

public class ScreenSlideFragment extends Fragment{

    private static final String PAGE_INDEX = "page_index";

    private int mPage;
    public ScreenSlideFragment(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!getArguments().containsKey(PAGE_INDEX)){
            throw new RuntimeException("Fragment must contain a " + PAGE_INDEX + "argument");
        }else{
            mPage = getArguments().getInt(PAGE_INDEX);
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        int layoutResId;
        int imageResId;
        switch (mPage){
            case 0:
                layoutResId = R.layout.fragment_intro_first;
                imageResId = R.drawable.image1;
                break;
            case 1:
                layoutResId = R.layout.fragment_intro_second;
                imageResId = R.drawable.image2;
                break;
            default:
                layoutResId = R.layout.fragment_intro_first;
                imageResId = R.drawable.image1;

        }

        ViewGroup viewGroup = (ViewGroup) inflater.inflate(layoutResId, container, false);
        ImageView imageView = (ImageView) viewGroup.findViewById(R.id.view_pager_image);
        Glide.with(this)
                .load(imageResId)
                .into(imageView);

        viewGroup.setTag(mPage);
        return viewGroup;
    }

    public static Fragment newInstance(int position) {
        ScreenSlideFragment screenSlideFragment = new ScreenSlideFragment();
        Bundle b = new Bundle();
        b.putInt(PAGE_INDEX, position);
        screenSlideFragment.setArguments(b);
        return screenSlideFragment;
    }
}
