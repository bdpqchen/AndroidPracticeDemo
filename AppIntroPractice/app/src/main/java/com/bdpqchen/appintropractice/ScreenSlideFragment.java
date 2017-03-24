package com.bdpqchen.appintropractice;

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

    private static final String PAGE_FRAGMENT_ID = "page_fragment_id";
    private static final String FRAGMENT_DRAWABLE_ID = "fragment_drawable_id";

    private int mPage;
    private int mDrawableId;

    public ScreenSlideFragment(){

    }

    public static Fragment newInstance(int fragmentId, int drawableId) {
        ScreenSlideFragment screenSlideFragment = new ScreenSlideFragment();
        Bundle b = new Bundle();
        b.putInt(PAGE_FRAGMENT_ID, fragmentId);
        b.putInt(FRAGMENT_DRAWABLE_ID, drawableId);
        screenSlideFragment.setArguments(b);
        return screenSlideFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (null != getArguments() && !getArguments().containsKey(PAGE_FRAGMENT_ID) && !getArguments().containsKey(FRAGMENT_DRAWABLE_ID)){
            throw new RuntimeException("Fragment must contain a " + PAGE_FRAGMENT_ID + "argument");
        }else{
            mPage = getArguments().getInt(PAGE_FRAGMENT_ID);
            mDrawableId = getArguments().getInt(FRAGMENT_DRAWABLE_ID);
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        ViewGroup viewGroup = (ViewGroup) inflater.inflate(mPage, container, false);
        ImageView imageView = (ImageView) viewGroup.findViewById(R.id.view_pager_image);
        Glide.with(this)
                .load(mDrawableId)
                .into(imageView);

        viewGroup.setTag(mPage);
        return viewGroup;
    }



}
