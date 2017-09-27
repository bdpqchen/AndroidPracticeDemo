package com.bdpqchen.practice.customview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

/**
 * Created by bdpqchen on 17-9-21.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomToolsLayout bottomToolsLayout = findViewById(R.id.custom_bottom_tools);
        final int size = 5;
        int[] reses = new int[size];
        int[] ids   = new int[size];
        for (int i = 0; i < size; i++){
            reses [i] = R.drawable.ic_clear_black_24dp;
            ids[i] = R.id.id_first;
        }

        bottomToolsLayout.addTabs(reses, ids, this);


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.id_first:
                Log.d("image is click", String.valueOf(view.getId()));
                break;
            case R.id.id_second:
                Log.d("image is click", String.valueOf(view.getId()));
                break;
        }
    }
}
