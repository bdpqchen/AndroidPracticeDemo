package com.bdpqchen.thumbview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by bdpqchen on 17-9-29.
 */

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ThumbView thumbView = findViewById(R.id.thumb);
        thumbView.setLikeCount(1);
        thumbView.setIsLiked(true);


    }
}
