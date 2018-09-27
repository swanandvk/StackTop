package stacktop.swanand.com.stacktop.di;

import android.app.Application;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import stacktop.swanand.com.stacktop.StackApplication;

@StackApplicationScope
@Component(modules = {
        AndroidInjectionModule.class,
        StackApplicationModule.class,
        ActivityBuilder.class
})
public interface StackApplicationComponent {

  @Component.Builder
  interface Builder {
    @BindsInstance
    Builder application(Application application);
    StackApplicationComponent build();
  }

  void inject(StackApplication app);
}
