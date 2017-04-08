package com.bdpqchen.swipebackpractice;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

/**
 * Created by bdpqchen on 17-4-7.
 */

public class SecondActivity extends com.aitangba.swipeback.SwipeBackActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        final Button button = (Button) findViewById(R.id.btn_start_third);
        getSupportActionBar().setTitle("Secondctivity");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SecondActivity.this, ThirdActivity.class));
                button.setText("old data");

//                finish();
            }
        });
//        Slidr.attach(this);

    }
}
