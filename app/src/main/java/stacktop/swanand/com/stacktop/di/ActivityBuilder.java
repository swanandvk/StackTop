package stacktop.swanand.com.stacktop.di;

import android.app.Activity;

import dagger.Module;

import dagger.android.ContributesAndroidInjector;

import stacktop.swanand.com.stacktop.MainActivity;

@Module
public abstract class ActivityBuilder {


    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity bindMainActivity();

}
