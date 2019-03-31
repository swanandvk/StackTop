package stacktop.swanand.com.stacktop;

import android.app.Activity;
import android.app.Application;
import javax.inject.Inject;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import stacktop.swanand.com.stacktop.di.DaggerStackApplicationComponent;
import timber.log.Timber;

public class StackApplication extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new Timber.DebugTree());

        DaggerStackApplicationComponent
                .builder()
                .application(this)
                .build()
                .inject(this);

    }


    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }
}
