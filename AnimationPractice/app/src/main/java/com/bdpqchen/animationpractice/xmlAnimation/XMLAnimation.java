package com.bdpqchen.animationpractice.xmlAnimation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.bdpqchen.animationpractice.R;

/**
 * Created by bdpqchen on 17-4-12.
 */

public class XMLAnimation extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xml_activity);

        final Button button = (Button) findViewById(R.id.xml_button);
        Button btnOperator = (Button) findViewById(R.id.btn_operator);
        final Animation animation = AnimationUtils.loadAnimation(this, R.anim.xml_activity);

//        button.setAnimation(animation);


        btnOperator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setAnimation(animation);
                button.startAnimation(animation);
            }
        });

    }
}
