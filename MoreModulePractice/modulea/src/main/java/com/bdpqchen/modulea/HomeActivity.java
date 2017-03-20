package com.bdpqchen.modulea;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;

import com.bdpqchen.modulea.base.BaseActivity;
import com.bdpqchen.modulea.fragment.FirstFragment;

/**
 * Created by chen on 17-2-24.
 */

public class HomeActivity extends BaseActivity {

    @Override
    public int getLayout() {
        return R.layout.activity_home;
    }

    @Override
    protected Toolbar getToolbar() {
        return null;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_home);

        FirstFragment firstFragment = new FirstFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frame_layout, firstFragment);
        fragmentTransaction.commit();

    }
}
