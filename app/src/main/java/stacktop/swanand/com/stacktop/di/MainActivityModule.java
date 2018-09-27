package stacktop.swanand.com.stacktop.di;

import dagger.Module;
import dagger.Provides;
import stacktop.swanand.com.stacktop.MainActivity;

@Module
public class MainActivityModule {


    @Provides
    MainActivity provideMainView(MainActivity mainActivity){
        return mainActivity;
    }

}