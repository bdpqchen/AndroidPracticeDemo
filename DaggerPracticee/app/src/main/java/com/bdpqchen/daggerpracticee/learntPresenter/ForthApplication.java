package com.bdpqchen.daggerpracticee.learntPresenter;

import android.app.Application;

/**
 * Created by bdpqchen on 17-4-4.
 */

public class ForthApplication extends Application {

    private ForthAppComponent mComponent;

    @Override
    public void onCreate() {
        super.onCreate();
/*        mComponent = DaggerDemoApplication_ApplicationComponent
                .builder()
                .androidModule(new ApplicationModule(getApplicationContext()))
                .build();*/

        mComponent = DaggerForthAppComponent.builder()
                .forthApplicationModule(new ApplicationModule(getApplicationContext()))
                .build();

    }

    public ForthAppComponent getForthAppComponent(){
        return mComponent;
    }
}
