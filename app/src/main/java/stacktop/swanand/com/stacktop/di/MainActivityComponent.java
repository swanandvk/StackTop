package stacktop.swanand.com.stacktop.di;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import stacktop.swanand.com.stacktop.MainActivity;

@Subcomponent(modules = MainActivityModule.class)
public interface MainActivityComponent extends AndroidInjector<MainActivity>{
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity>{}
}
