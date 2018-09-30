package stacktop.swanand.com.stacktop.di;

import dagger.Module;

import dagger.android.ContributesAndroidInjector;

import stacktop.swanand.com.stacktop.ui.MainActivity;

@Module
public abstract class ActivityBuilder {


    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity bindMainActivity();

}
