package com.bdpqchen.progressbutton;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

/**
 * Created by bdpqchen on 17-10-5.
 */

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ProgressButton progressButton = findViewById(R.id.btn);
        progressButton.setOnBtnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("onClicked", "btn");
            }
        });
    }
}
