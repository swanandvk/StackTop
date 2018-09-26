package stacktop.swanand.com.stacktop.di;

import com.squareup.picasso.Picasso;

import dagger.Component;
import stacktop.swanand.com.stacktop.ApiInterface;

@StackApplicationScope
@Component(modules = {ApiInterfaceModule.class,PicassoModule.class})
public interface StackApplicationComponent {

  Picasso getPicasso();
  ApiInterface getApiInterface();
}
