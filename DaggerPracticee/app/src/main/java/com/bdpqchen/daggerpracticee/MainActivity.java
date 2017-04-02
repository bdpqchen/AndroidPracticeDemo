package com.bdpqchen.daggerpracticee;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.bdpqchen.daggerpracticee.component.DaggerFlowerComponent;
import com.bdpqchen.daggerpracticee.model.Pot;
import com.bdpqchen.daggerpracticee.module.FlowerModule;
import com.bdpqchen.daggerpracticee.module.PotModule;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

  /*  @Inject
    Heater mHeater;

    @Inject
    Gson mGson;
*/
    @Inject
    Pot mPot;

    private TextView mTextView1, mTextView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/*
        DaggerMainActivityComponent.builder().potComponent(
                DaggerPotComponent.builder().flowerComponent(
                        DaggerFlowerComponent.create()).build()
        ).build().inject(this);
*/
        DaggerFlowerComponent.create()
                .plus(new PotModule())
                .plus()
                .inject(this);

        mTextView1 = (TextView) findViewById(R.id.text1);
        mTextView2 = (TextView) findViewById(R.id.text2);
//        mTextView1.setText(mHeater.getmName());

//        String json = mGson.toJson()
//        mTextView2.setText(mGson.getmName());

       String showStr =  mPot.show();
       mTextView2.setText(showStr);

    }
}
