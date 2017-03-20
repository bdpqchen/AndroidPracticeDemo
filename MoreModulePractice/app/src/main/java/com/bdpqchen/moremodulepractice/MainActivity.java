package com.bdpqchen.moremodulepractice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bdpqchen.modulea.HomeActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.button)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        View view = MainActivity.class;
        ButterKnife.bind(this);

    }

    @OnClick({R.id.tv, R.id.button})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv:
                startActivity(new Intent(this, HomeActivity.class));

                break;
            case R.id.button:
                startActivity(new Intent(this, HomeActivity.class));

                break;
        }
    }
}
