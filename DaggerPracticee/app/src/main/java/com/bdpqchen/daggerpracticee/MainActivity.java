package com.bdpqchen.daggerpracticee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.bdpqchen.daggerpracticee.activity.SecondActivity;
import com.bdpqchen.daggerpracticee.application.App;
import com.bdpqchen.daggerpracticee.model.Pot;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    Pot mPot;

    @Inject
    Pot mPot2;

    private TextView mTextView1, mTextView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/*
        DaggerMainActivityComponent.builder().potComponent(DaggerPotComponent.builder().flowerComponent(DaggerFlowerComponent.create()).build())
                .build()
                .inject(this);
*/

       /* DaggerMainActivityComponent.builder()
                .potComponent(((App)getApplication()).getPotComponent())
                .build()
                .inject(this);
*/
        mTextView1 = (TextView) findViewById(R.id.text1);
        mTextView2 = (TextView) findViewById(R.id.text2);



        Log.i("pot1", String.valueOf(mPot.hashCode()));
        Log.i("pot2", String.valueOf(mPot2.hashCode()));

       String showStr =  mPot.show();
       mTextView2.setText(showStr);
       startActivity(new Intent(this, SecondActivity.class));

    }
}
