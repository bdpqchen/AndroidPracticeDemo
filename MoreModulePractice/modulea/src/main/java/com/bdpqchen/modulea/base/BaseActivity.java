package com.bdpqchen.modulea.base;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.WindowManager;


/**
 * Created by chen on 17-2-9.
 */

public abstract class BaseActivity extends AppCompatActivity {

    public abstract int getLayout();

    protected abstract Toolbar getToolbar();

    private Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(getLayout());
//        ButterKnife.bind(this);
//        mToolbar = getToolbar();
        initToolbar();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//            SystemBarTintManager tintManager = new SystemBarTintManager(this);
//            tintManager.setStatusBarTintEnabled(true);
//            tintManager.setNavigationBarTintEnabled(true);
//            tintManager.setStatusBarTintResource(R.color.colorPrimaryDark);
//        }
//        AppActivityManager.getActivityManager().addActivity(this);
        }

    }

    private void initToolbar(){
        if(mToolbar != null){
            setSupportActionBar(mToolbar);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        AppActivityManager.getActivityManager().finishActivity(this);
    }
}
