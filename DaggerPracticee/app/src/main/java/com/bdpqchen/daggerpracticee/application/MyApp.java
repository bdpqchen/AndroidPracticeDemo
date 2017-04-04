package com.bdpqchen.daggerpracticee.application;

import android.app.Application;

import com.bdpqchen.daggerpracticee.component.TestComponent;
import com.bdpqchen.daggerpracticee.module.AppModule;
import com.bdpqchen.daggerpracticee.module.NetModule;



/**
 * Created by bdpqchen on 17-4-3.
 */

public class MyApp extends Application {


    private TestComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

      /*  component = DaggerTestComponent
                .builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("url"))
                .build();
*/
    }

    public TestComponent getNetComponent() {
        return component;
    }
}
