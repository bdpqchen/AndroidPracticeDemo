package com.bdpqchen.daggerpracticee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.bdpqchen.daggerpracticee.module.Gson;
import com.bdpqchen.daggerpracticee.module.Heater;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    Heater mHeater;

    @Inject
    Gson mGson;

    private TextView mTextView1, mTextView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerMainComponent.builder().build().inject(this);


        mTextView1 = (TextView) findViewById(R.id.text1);
        mTextView1.setText(mHeater.getmName());

        mTextView2 = (TextView) findViewById(R.id.text2);


    }
}
